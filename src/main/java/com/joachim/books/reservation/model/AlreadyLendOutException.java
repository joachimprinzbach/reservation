package com.joachim.books.reservation.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class AlreadyLendOutException extends RuntimeException {
}
