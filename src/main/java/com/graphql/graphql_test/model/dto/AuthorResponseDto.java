package com.graphql.graphql_test.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponseDto {

    private long id;
    private String name;
    private List<BookResponseDTO> books;
}
