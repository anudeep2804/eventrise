package com.example.MinorProj1.repositories;

import com.example.MinorProj1.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {


}
