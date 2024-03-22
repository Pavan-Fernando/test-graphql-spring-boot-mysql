package com.graphql.graphql_test.service.fetch;

import com.graphql.graphql_test.model.entity.Author;
import com.graphql.graphql_test.model.repository.AuthorRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FetchAuthorById implements DataFetcher<Author> {

    private final AuthorRepository authorRepository;

    @Autowired
    public FetchAuthorById(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author get(DataFetchingEnvironment environment) throws Exception {
        long id = Long.parseLong(environment.getArgument("id"));
        return authorRepository.findById(id).get();
    }


}
