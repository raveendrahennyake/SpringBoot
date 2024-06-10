package com.example.demo.service;

import com.example.demo.DTO.Request.AuthorDTO;
import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
	public ResponseEntity<Author> addAuthor (@RequestBody AuthorDTO authorDTO) {
		Author author=new Author();
		author.setName(authorDTO.getName());
		author.setDescription(authorDTO.getDescription());
		authorRepository.save(author);
		ResponseEntity<Author> responseEntity=ResponseEntity.ok(author);
		return  responseEntity;


	}
	@Autowired
	private AuthorRepository authorRepository;

	public List<Author> getAuthorList(){
		return authorRepository.findAll();
	}
	public Optional<Author> getAuthor(Integer id){
		return authorRepository.findById(id);
	}
	public ResponseEntity<String>delectbook (@RequestParam Integer id) {
		Optional<Author> optionalAuthor=authorRepository.findById(id);
		if(optionalAuthor.isPresent()){
			authorRepository.deleteById(id);
			return ResponseEntity.ok("It is a Delect ");
		}
		else {
			return ResponseEntity.notFound().build();
		}


	}

	public ResponseEntity <String> updateAuthor (@RequestParam Integer new_id,@RequestParam String new_name,@RequestParam String new_description) {
		Optional <Author> optionalAuthor=authorRepository.findById(new_id);
		if(optionalAuthor.isPresent()){
			Author author=optionalAuthor.get();
			author.setAuthor_id(new_id);
			author.setName(new_name);
			author.setDescription(new_description);
			authorRepository.save(author);
			return ResponseEntity.ok("IT IS UPDATE");
		}
		else {
			return ResponseEntity.notFound().build();
		}

	}














}
