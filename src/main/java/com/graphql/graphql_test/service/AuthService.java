package com.graphql.graphql_test.service;

import com.graphql.graphql_test.model.dto.AuthorResponseDto;
import com.graphql.graphql_test.model.pojo.Filters;

import java.util.List;

public interface AuthService {
    List<AuthorResponseDto> getAuthors();

    AuthorResponseDto getAuthorById(long id);

    AuthorResponseDto authorByIdAndName(Filters filters);
}
