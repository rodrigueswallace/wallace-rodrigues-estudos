package com.wallace.library.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallace.library.dto.BookDTO;
import com.wallace.library.entities.Book;
import com.wallace.library.repository.BookRepository;
import com.wallace.library.services.exception.ObjectNotFoundException;

@Service
public class BookService {

	@Autowired
	private BookRepository repo;

	public List<Book> findAll() {
		return repo.findAll();
	}

	public Book findById(String id) {
		Optional<Book> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}

	public Book insert(Book obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}

	public Book update(Book obj) {
		Book newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Book newObj, Book obj) {
		newObj.setTitle(obj.getTitle());
		newObj.setAuthor(obj.getAuthor());
		newObj.setYear(obj.getYear());
		newObj.setGenre(obj.getGenre());

	}

	public Book fromDTO(BookDTO objDto) {
		return new Book(objDto.getId(), objDto.getTitle(), objDto.getAuthor(), objDto.getYear(), objDto.getGenre());
	}

/*	public List<Book> findByYear(int year) {
		return repo.findByYear(year);
	} */
	public List<Book> findByYear(int year) {
	    return repo.findByYear(year);
	}


	public List<Book> findByTextInAnyField(String text) {
		return repo.findByTextInAnyField(text);
	} 
	
/*	public List<Book> findByTitle(String text) {
		return repo.findByTitleContainingIgnoreCase(text);
	} */

}
