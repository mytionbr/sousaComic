package com.mytion.sousacomics.api;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mytion.sousacomics.model.entity.Book;
import com.mytion.sousacomics.model.request.BookPostRequestBody;
import com.mytion.sousacomics.service.BookService;

import lombok.RequiredArgsConstructor;


@RequestMapping("/books")
@Controller
@RequiredArgsConstructor
public class BookController extends ApiController{
	
	private final BookService bookService;
	
	public ResponseEntity<Book> save(@RequestBody @Valid BookPostRequestBody bookPostRequestBody) {
		Book book =  this.bookService.save(bookPostRequestBody);
		return new ResponseEntity<>(book,HttpStatus.CREATED);
	}
	
}
