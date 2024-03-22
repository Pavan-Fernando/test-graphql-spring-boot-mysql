package com.graphql.graphql_test.model.repository;

import com.graphql.graphql_test.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
