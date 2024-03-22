package com.graphql.graphql_test.service;

import graphql.GraphQL;

public interface GraphQlService {

    GraphQL getAllAuthors();
    GraphQL getAuthorById();
}
