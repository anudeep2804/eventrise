package com.example.MinorProj1.Controllers;

import com.example.MinorProj1.Services.BookService;
import com.example.MinorProj1.requests.BookCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController

public class BookController {


    @Autowired
    BookService bookService;



    // @RequestBody - JSON to domain object with automatic deserialization
    // @Valid - make sures all the validations defined on the POJO are enforced
    @PostMapping("/book")
    public void CreateBook( @Valid @RequestBody BookCreateRequest bookCreateRequest){

      bookService.create(bookCreateRequest);

    }


}
