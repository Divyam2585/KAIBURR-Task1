package com.kaiburr.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.kaiburr.model.Server;

@Repository
public interface ServerRepository extends MongoRepository<Server, Long>{
	@Query

	public List<Server> findByName(String name);
}
