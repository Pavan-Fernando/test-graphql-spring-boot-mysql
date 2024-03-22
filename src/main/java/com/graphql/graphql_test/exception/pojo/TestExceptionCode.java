package com.graphql.graphql_test.exception.pojo;

import com.graphql.graphql_test.utill.Constant;
import lombok.Getter;

import java.util.EnumSet;

@Getter
public enum TestExceptionCode {

    SVR00X(Constant.ERROR_TYPE_SERVER),
    SLCB00X(Constant.ERROR_TYPE_INVALID_INPUT); // Invalid team number in Team Fixture


    private final String type;

    TestExceptionCode(String type) {
        this.type = type;
    }

    public static TestExceptionCode getByValue(String value) {
        for (final TestExceptionCode element : EnumSet.allOf(TestExceptionCode.class)) {
            if (element.toString().equals(value)) {
                return element;
            }
        }
        return null;
    }

    public String getType() {
        return type;
    }
}
