package com.graphql.graphql_test.controller;

import com.graphql.graphql_test.model.dto.AuthorResponseDto;
import com.graphql.graphql_test.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test/rest/authors")
public class TestRestController {

    private final AuthService authService;

    @Autowired
    public TestRestController(AuthService authService) {;
        this.authService = authService;
    }


    @GetMapping("/all")
    ResponseEntity<List<AuthorResponseDto>> findAll(){
        return new ResponseEntity<>(authService.getAuthors(), HttpStatus.OK);
    }
}
