package com.graphql.graphql_test.model.repository;

import com.graphql.graphql_test.model.entity.Author;
import com.graphql.graphql_test.model.projection.TestAuthorProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    TestAuthorProjection findAuthorByName(@Param("authorName") String authorName);
}
