package com.graphql.graphql_test.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String publisher;
    @Column(name = "published_year", columnDefinition = "DATETIME(0)")
    private LocalDateTime publishedYear;

    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;



}
