package com.joachim.books.reservation.model;

import org.springframework.context.ApplicationEvent;

public class BookHasBeenLentEvent extends ApplicationEvent {

    public BookHasBeenLentEvent(Object source) {
        super(source);
    }
}
