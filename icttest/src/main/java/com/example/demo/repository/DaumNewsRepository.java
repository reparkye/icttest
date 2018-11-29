package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.collection.DaumNews;

public interface DaumNewsRepository extends MongoRepository<DaumNews, String>{

	@Query("{aid:?0}")
	public List<DaumNews> findByAid(String aid);
	
}
