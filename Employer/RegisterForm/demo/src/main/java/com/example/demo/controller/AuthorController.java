package com.example.demo.controller;

import com.example.demo.DTO.Request.AuthorDTO;
import com.example.demo.model.Author;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
	@Autowired
	private AuthorService authorService;

	@GetMapping("/getAllAuthors")
	public List<Author> getAuthorList(){
		return authorService.getAuthorList();
	}
	@GetMapping("/{id}")
	public Optional<Author> getAuthorDetails(@PathVariable Integer id){
		return authorService.getAuthor(id);
	}
	@PostMapping("/addAuthor")
	public ResponseEntity<Author> addAuthor (@RequestBody AuthorDTO authorDTO) {
		return authorService.addAuthor(authorDTO);

	}
	@DeleteMapping("/DelectAuthor")
	public ResponseEntity<String> delectAuthor (@RequestParam Integer id) {
		return authorService.delectbook(id);

	}
	@PutMapping("/updateAuthor")
	public ResponseEntity <String> updateAuthor (@RequestParam Integer new_id,@RequestParam String new_name,@RequestParam String new_description) {
		return authorService.updateAuthor(new_id,new_name,new_description);

	}


	}




