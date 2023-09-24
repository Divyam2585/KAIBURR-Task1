# KAIBURR-Task1

To implement a Java REST API with endpoints for searching, creating, and deleting "server" objects using MongoDB as the database, you can follow these steps. I'll provide you with a simplified example using the Spring Boot framework, which makes it easy to create RESTful APIs in Java. You'll need to set up a Spring Boot project and include the necessary dependencies.

1. Create a Spring Boot Project:

   You can create a Spring Boot project using your preferred IDE or by using Spring Initializer (https://start.spring.io/). Make sure to include the following dependencies:
   
   - Spring Web
   - Spring Data MongoDB
   - Lombok (optional but helpful for reducing boilerplate code)

2. Define the Server Entity:

   Create a Java class to represent the "server" entity. This class will be used to map objects to MongoDB documents. Here's an example:

```java
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "servers")
public class Server {
    @Id
    private String id;
    private String name;
    private String language;
    private String framework;
}
```

3. Create a Repository:

   Create a repository interface that extends `MongoRepository` to perform database operations for the `Server` entity:

```java
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServerRepository extends MongoRepository<Server, String> {
}
```

4. Implement REST Endpoints:

   Create a controller class with the REST endpoints. Here's an example:

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servers")
public class ServerController {

    private final ServerRepository serverRepository;

    @Autowired
    public ServerController(ServerRepository serverRepository) {
        this.serverRepository = serverRepository;
    }

    @GetMapping
    public ResponseEntity<List<Server>> getServers(@RequestParam(required = false) String name) {
        if (name != null) {
            List<Server> servers = serverRepository.findAll(Example.of(new Server(), ExampleMatcher.nameContains().ignoreCase()));
            if (!servers.isEmpty()) {
                return ResponseEntity.ok(servers);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            List<Server> servers = serverRepository.findAll();
            return ResponseEntity.ok(servers);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Server> getServerById(@PathVariable String id) {
        Optional<Server> serverOptional = serverRepository.findById(id);
        return serverOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Server> createServer(@RequestBody Server server) {
        Server savedServer = serverRepository.save(server);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedServer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServer(@PathVariable String id) {
        if (serverRepository.existsById(id)) {
            serverRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
```

5. Configure MongoDB:

   Configure the MongoDB connection in your `application.properties` or `application.yml` file:

```yaml
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=mydb
```

6. Run the Application:

   Run your Spring Boot application, and it should start a web server listening on the defined port (default is 8080).

7. Test the Endpoints:

   You can use tools like Postman, curl, or any other HTTP client to test the implemented endpoints based on your requirements. For example:

   - To create a server: Send a `PUT` request with the server JSON in the request body to `/servers`.
   - To get servers: Send a `GET` request to `/servers` (with optional `name` query parameter).
   - To get a specific server: Send a `GET` request to `/servers/{id}`.
   - To delete a server: Send a `DELETE` request to `/servers/{id}`.

Make sure to adapt this example to your specific requirements and add error handling and security as needed in a production application.
