package com.graphql.graphql_test.model.projection;

import java.util.List;

public interface TestAuthorProjection {

    String getName();
    long getId();
    String getAddress();

    List<TestBookProjection> getBooks();
}
