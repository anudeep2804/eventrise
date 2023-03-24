package com.example.MinorProj1.Services;

import com.example.MinorProj1.models.Author;
import com.example.MinorProj1.models.Book;
import com.example.MinorProj1.repositories.AuthorRepository;
import com.example.MinorProj1.repositories.BookRepository;
import com.example.MinorProj1.requests.BookCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;



    public void create(BookCreateRequest bookCreateRequest){
        Book book = bookCreateRequest.to();
        //bookRepository.save(book); // this will throw error with foreign key constraint as corresponding author is not saved
        Author author = book.getAuthor();

        Author authorFromDB= authorRepository.getAuthorGivenEmailIdJPQL(author.getEmail());

        if(authorFromDB==null){
            authorRepository.save(author);
        }
        //book.setAuthor(author); this is not required as author in book object and author are pointing to same mem loc, so we just need id and other details will be
        // updated from the book only

       // book.setId(1); // we can set id here but this will throw an error 'foreign key constraint failed' as author is not saved yet , parent object not present. so save author first


        book.setAuthor(authorFromDB);
        bookRepository.save(book);

        
    }
}
