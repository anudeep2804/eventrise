package com.example.MinorProj1.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // @Id makes it primary key and GenerationType.IDENTITY -> auto_increment;
    private int id;

    private String name;
    private int cost;

    /*

    EnumType.ORDINAL: This is the default strategy, where the enum constants are mapped based on their ordinal values. This means that the first constant is mapped to 0, the second to 1, and so on.

    EnumType.STRING: With this strategy, the enum constants are mapped based on their string representation. This means that each constant is mapped to its name in the database column.
     */
    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @ManyToOne // Relationship type
    @JoinColumn // creates foreign_key
    private Author author;

    @ManyToOne
    @JoinColumn // student_id will be foreign key in book table , so @JoinColumn is written to create a foreign key
    private Student student;

    @OneToMany(mappedBy = "my_book")
    private List<Transaction> transactionList;

//    private Student tempColumn; // Just for explanation of back reference

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;
}