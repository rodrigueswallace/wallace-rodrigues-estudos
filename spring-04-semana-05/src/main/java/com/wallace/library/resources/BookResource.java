package com.wallace.library.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wallace.library.dto.BookDTO;
import com.wallace.library.entities.Book;
import com.wallace.library.resources.util.URL;
import com.wallace.library.services.BookService;

@RestController
@RequestMapping(value = "/books")
public class BookResource {

	@Autowired
	private BookService service;

	@GetMapping
	public ResponseEntity<List<BookDTO>> findAll() {
		List<Book> list = service.findAll();
		List<BookDTO> listDto = list.stream().map(x -> new BookDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@GetMapping("/filters")
	public ResponseEntity<List<Book>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
		text = URL.decodeParam(text);
		List<Book> list = service.findByTextInAnyField(text);
		return ResponseEntity.ok().body(list);
	}

/*	@GetMapping("/Year")
	public ResponseEntity<List<Book>> findByYear(@RequestParam(value = "year", defaultValue = "0") Integer year) {
		List<Book> list = service.findByYear(year);
		return ResponseEntity.ok().body(list);
	} */
	@GetMapping("/books-after-year")
	public ResponseEntity<List<Book>> findByYear(@RequestParam(value = "year", required = false) Integer year) {
	    if (year == null) {
	        // Por exemplo, retornar todos os livros
	        List<Book> allBooks = service.findAll();
	        return ResponseEntity.ok().body(allBooks);
	    }
	    List<Book> list = service.findByYear(year);
	    return ResponseEntity.ok().body(list);
	}

	
/*	@RequestMapping(value="/titlesearch", method=RequestMethod.GET)
 	public ResponseEntity<List<Book>> findByTitle(@RequestParam(value="text", defaultValue="") String text) {
		text = URL.decodeParam(text);
		List<Book> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	} */

	@GetMapping("/{id}")
	public ResponseEntity<BookDTO> findById(@PathVariable String id) {
		Book obj = service.findById(id);
		return ResponseEntity.ok().body(new BookDTO(obj));
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody BookDTO objDto) {
		Book obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody BookDTO objDto, @PathVariable String id) {
		Book obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

}
