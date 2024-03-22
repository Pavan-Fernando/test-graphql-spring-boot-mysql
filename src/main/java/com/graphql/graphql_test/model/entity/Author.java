package com.graphql.graphql_test.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String gender;
    private String noOfExperienceYears;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;



}
