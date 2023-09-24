package com.kaiburr.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kaiburr.model.Server;
import com.kaiburr.repository.ServerRepository;
import com.kaiburr.service.ServerService;

@RestController
public class ServerController {

	@Autowired
	public ServerService serverService;

	@GetMapping("/getServers")
	public ResponseEntity<List<Server>> getAllServers() {
		return serverService.getAllServers();
	}

	@GetMapping("/getServers/{id}")
	public ResponseEntity<Optional<Server>> getServerById(@PathVariable("id") long id) {

		return serverService.getServerById(id);

	}

	@PostMapping("/addServer")
	public String addServer(@RequestBody Server server) {

		return serverService.addServer(server);
	}

	@DeleteMapping("/deleteServer/{id}")
	public String deleteServer(@PathVariable("id") long id) {

		return serverService.deleteServer(id);
	}

	@GetMapping("/getServer/{name}")
	public ResponseEntity<List<Server>> getServer(@PathVariable("name") String name) {
		return serverService.getServerByName(name);
	}
}
