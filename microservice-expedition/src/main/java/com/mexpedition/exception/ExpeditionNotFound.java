package com.mexpedition.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExpeditionNotFound extends RuntimeException {
    public ExpeditionNotFound(String msg) {
        super(msg);
    }
}
