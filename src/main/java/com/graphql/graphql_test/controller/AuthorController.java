package com.graphql.graphql_test.controller;

import com.graphql.graphql_test.model.dto.AuthorResponseDto;
import com.graphql.graphql_test.model.pojo.Filters;
import com.graphql.graphql_test.service.AuthService;
import com.graphql.graphql_test.service.GraphQlService;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Controller
public class AuthorController {

    private final GraphQlService graphQlService;
    private final AuthService authService;

    @Autowired
    public AuthorController(GraphQlService graphQlService, AuthService authService) {
        this.graphQlService = graphQlService;
        this.authService = authService;
    }

    @PostMapping("/all")
    ResponseEntity<ExecutionResult> authors(@RequestBody String query){
        return new ResponseEntity<>(graphQlService.getAllAuthors().execute(query), HttpStatus.OK);
    }

    @PostMapping("/byId")
    ResponseEntity<ExecutionResult> authorById(@RequestBody String query){
        return new ResponseEntity<>(graphQlService.getAuthorById().execute(query), HttpStatus.OK);
    }

    @QueryMapping
    ResponseEntity<List<AuthorResponseDto>> authors(){
        return new ResponseEntity<>(authService.getAuthors(), HttpStatus.OK);
    }

    @QueryMapping
    ResponseEntity<AuthorResponseDto> authorByIdAndName(@Argument Filters filters){
        return new ResponseEntity<>(authService.authorByIdAndName(filters), HttpStatus.OK);
    }
}
