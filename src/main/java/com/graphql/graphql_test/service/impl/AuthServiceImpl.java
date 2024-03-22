package com.graphql.graphql_test.service.impl;

import com.graphql.graphql_test.exception.TestException;
import com.graphql.graphql_test.model.entity.Author;
import com.graphql.graphql_test.model.dto.AuthorResponseDto;
import com.graphql.graphql_test.model.pojo.Filters;
import com.graphql.graphql_test.model.projection.TestAuthorProjection;
import com.graphql.graphql_test.model.projection.TestBookProjection;
import com.graphql.graphql_test.model.repository.AuthorRepository;
import com.graphql.graphql_test.service.AuthService;
import graphql.GraphQLException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthorRepository authorRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AuthServiceImpl(AuthorRepository authorRepository, ModelMapper modelMapper) {
        this.authorRepository = authorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AuthorResponseDto> getAuthors() {
        List<Author> authors = authorRepository.findAll();

        return modelMapper.map(authors, new TypeToken<List<AuthorResponseDto>>() {}.getType());
    }

    @Override
    public AuthorResponseDto getAuthorById(long id) {
        return modelMapper.map(authorRepository.findById(id).get(), AuthorResponseDto.class);
    }

    @Override
    public AuthorResponseDto authorByIdAndName(Filters filters) {
        //Add Logs
        TestAuthorProjection author = authorRepository.findAuthorByName(filters.getAuthorName());
        //Check Nullability and throws exception
        Set<String> bookTitles = author.getBooks()
                .stream()
                .map(TestBookProjection::getTitle)
                .filter(title -> title.equals(filters.getBookName()))
                .collect(Collectors.toSet());
        if (bookTitles.contains(filters.getBookName())){
            //Map AuthorResponse
            //Add Logs
            return new AuthorResponseDto();
        }
        //Add Logs
        throw new GraphQLException();
    }
}
