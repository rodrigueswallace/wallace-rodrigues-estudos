package com.wallace.library.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.wallace.library.entities.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

/*	@Query("{ 'year': { $regex: ?0, $options: 'i' } }")
	List<Book> findByYear(int year); */
	@Query("{ 'year': { $gte: ?0 } }")
	List<Book> findByYear(int year);


	@Query("{ '$or': [ {'title': { $regex: ?0, $options: 'i' }}, {'author': { $regex: ?0, $options: 'i' }}, {'genre': { $regex: ?0, $options: 'i' }} ] }")
	List<Book> findByTextInAnyField(String text); 
	
	// List<Book> findByTitleContainingIgnoreCase(String text);

}
