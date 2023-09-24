# Task 1: Java REST API Example

## Technologies Used :
```
Java
Maven
SpringBoot
MongoDB
```
## Rest Api Endpoints
* Put a server ```http://127.0.0.1:2017/addServer``` Add "server" object in JSON form.

* GET servers ```http://127.0.0.1:2017/getServers``` Returns a list of "server" objects.

* GET server by id ```http://127.0.0.1:2017/getServers/{id}``` Returns a "server" object matching with id.

* GET servers by name ```http://127.0.0.1:2017/getServer/{name}``` Returns a list of "server" objects matching with name.

* DELETE server by id ```http://127.0.0.1:2017/deleteServer/{id}``` Deletes a "server" object matching with id. 

## Testing APIs on POSTMAN

ScreenShots

* ##### Adding Server 
![AddingServer](https://user-images.githubusercontent.com/73234020/158126625-4acafd28-6b27-4000-af10-991f793cb986.png)

* ##### Get Servers : Here we get all the servers present in database.

![GetServers](https://user-images.githubusercontent.com/73234020/158126948-5c6da388-dfda-47ce-84d1-5e65168df338.png)

* ##### Get Server By Id : Here we get only one server for the given id and if there is no server for given id then we get status as ``` 404 NOT FOUND ```.
Get Server By Id
![GetServerById](https://user-images.githubusercontent.com/73234020/158127198-03a097dc-2d2d-4753-ae83-adc39ea20a40.png)

```404 NOT FOUND```
![GetServersById(404 not found)](https://user-images.githubusercontent.com/73234020/158127233-eeb4881d-e29b-42e3-8d8c-8119f9051b59.jpg)

* ##### Get Server By Name : Here we get all servers by name and if there is no server then we get ```404 NOT FOUND```. 

![GetServerByName](https://user-images.githubusercontent.com/73234020/158127958-034116db-7f1d-438f-91f0-19774a2be5f9.png)

```404 NOT FOUND```
![GetServersByName(404 not found)](https://user-images.githubusercontent.com/73234020/158128985-4be3b264-7f4c-4f48-8c3f-e891b0f71077.png)


* ##### Delete Server : Here the server gets deleted for a given id.
![DeleteServer](https://user-images.githubusercontent.com/73234020/158128248-bf5a1522-0f02-4961-939c-7a7e007ba737.png)

* #### MongoDB database 
![MongoDBDatabase](https://user-images.githubusercontent.com/73234020/158129122-cdf80e34-fe71-4d7f-b23c-173d0aa4ca86.png)


## Thank You !!!


