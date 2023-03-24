package com.example.MinorProj1.repositories;

import com.example.MinorProj1.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author,Integer> {

    @Query(value = "select a from author a where a.email = ?1", nativeQuery = true)
    public Author getAuthorGivenEmailIdNativeQuery(String author_email); // peter@gmail.com

    @Query("select a from Author a where a.email = ?1")
    public Author getAuthorGivenEmailIdJPQL(String author_email); // peter@gmail.com
}
