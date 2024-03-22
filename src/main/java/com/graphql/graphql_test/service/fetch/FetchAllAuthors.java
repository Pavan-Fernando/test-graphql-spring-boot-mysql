package com.graphql.graphql_test.service.fetch;

import com.graphql.graphql_test.model.dto.AuthorResponseDto;
import com.graphql.graphql_test.model.entity.Author;
import com.graphql.graphql_test.model.repository.AuthorRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FetchAllAuthors implements DataFetcher<List<AuthorResponseDto>> {

    private final AuthorRepository authorRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public FetchAllAuthors(AuthorRepository authorRepository, ModelMapper modelMapper) {
        this.authorRepository = authorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AuthorResponseDto> get(DataFetchingEnvironment environment) throws Exception {
        List<Author> authors = authorRepository.findAll();
        return modelMapper.map(authors, new TypeToken<List<AuthorResponseDto>>() {}.getType());
    }
}
