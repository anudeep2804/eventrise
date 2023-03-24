package com.example.MinorProj1.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Author {

    @Id
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String country;
    private int age;

    @Column(unique = true,nullable = false)

    private String email;

    @OneToMany(mappedBy = "author")
    private List<Book> bookList;

    @CreationTimestamp
    private Date addedOn;
}
