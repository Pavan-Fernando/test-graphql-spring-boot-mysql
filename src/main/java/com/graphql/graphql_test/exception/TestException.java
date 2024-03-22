package com.graphql.graphql_test.exception;

import com.graphql.graphql_test.exception.pojo.TestExceptionCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class TestException extends Exception {

    private final HttpStatus statusCode;
    private final String errorCode;
    private final String errorType;
    private final String errorMessage;

    public TestException(HttpStatus statusCode,
                         TestExceptionCode errorCode,
                         String errorMessage,
                         String logMessage) {
        super(logMessage);
        this.statusCode = statusCode;
        this.errorCode = errorCode.name();
        this.errorType = errorCode.getType();
        this.errorMessage = errorMessage;
    }

    public TestException(HttpStatus statusCode,
                         TestExceptionCode errorCode,
                         String errorMessage,
                         String logMessage,
                         Throwable e) {
        super(logMessage, e);
        this.statusCode = statusCode;
        this.errorCode = errorCode.name();
        this.errorType = errorCode.getType();
        this.errorMessage = errorMessage;
    }

    public TestException(HttpStatus statusCode,
                         String errorCode,
                         String errorType,
                         String errorMessage,
                         String logMessage,
                         Throwable e) {
        super(logMessage, e);
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.errorType = errorType;
        this.errorMessage = errorMessage;
    }

}


