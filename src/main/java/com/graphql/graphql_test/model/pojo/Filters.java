package com.graphql.graphql_test.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Filters {

    private String bookName;
    private String authorName;

}
