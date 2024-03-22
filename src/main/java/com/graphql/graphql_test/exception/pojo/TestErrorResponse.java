package com.graphql.graphql_test.exception.pojo;

import com.graphql.graphql_test.model.dto.ErrorRespDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestErrorResponse {
    private ErrorRespDto error;

    public TestErrorResponse() {
    }

    public TestErrorResponse(String code, String type, String message) {
        ErrorRespDto errorResponse = new ErrorRespDto();
        errorResponse.setCode(code);
        errorResponse.setType(type);
        errorResponse.setMessage(message);

        this.error = errorResponse;
    }
}