package com.graphql.graphql_test.service.impl;

import com.graphql.graphql_test.exception.TestException;
import com.graphql.graphql_test.exception.pojo.TestExceptionCode;
import com.graphql.graphql_test.service.GraphQlService;
import com.graphql.graphql_test.service.fetch.FetchAllAuthors;
import com.graphql.graphql_test.service.fetch.FetchAuthorById;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;


@Service
public class GraphQlServiceImpl implements GraphQlService {

    @Value("classpath:graphql/schema.graphqls")
    private Resource resource;

    private final FetchAllAuthors fetchAllAuthors;
    private final FetchAuthorById fetchAuthorByIds;

    private GraphQL graphQL1;
    private GraphQL graphQL2;

    @Autowired
    public GraphQlServiceImpl(FetchAllAuthors fetchAllAuthors, FetchAuthorById fetchAuthorByIds) {
        this.fetchAllAuthors = fetchAllAuthors;
        this.fetchAuthorByIds = fetchAuthorByIds;
    }


    @PostConstruct
    public void getSchema() throws TestException {
        try {
            File schema = resource.getFile();

            TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(schema);
            RuntimeWiring runtimeWiring1 = RuntimeWiring.newRuntimeWiring()
                    .type("Query", typeWiring -> typeWiring
                            .dataFetcher("authors", fetchAllAuthors))
                    .build();
            RuntimeWiring runtimeWiring2 = RuntimeWiring.newRuntimeWiring()
                    .type("Query", typeWiring -> typeWiring
                            .dataFetcher("authorById", fetchAuthorByIds))
                    .build();
            GraphQLSchema graphQLSchema1 = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, runtimeWiring1);
            GraphQLSchema graphQLSchema2 = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, runtimeWiring2);
            graphQL1 = GraphQL.newGraphQL(graphQLSchema1).build();
            graphQL2 = GraphQL.newGraphQL(graphQLSchema2).build();
        }catch (Exception ex){
            throw new TestException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    TestExceptionCode.SVR00X,
                    "GraphQL Error",
                    "GraphQL Error: " + ex.getMessage()
            );
        }
    }

    @Override
    public GraphQL getAllAuthors() {
        return graphQL1;
    }

    @Override
    public GraphQL getAuthorById() {
        return graphQL2;
    }
}
