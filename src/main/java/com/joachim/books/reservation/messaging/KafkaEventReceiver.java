package com.joachim.books.reservation.messaging;

import com.joachim.books.reservation.model.Book;
import com.joachim.books.reservation.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaEventReceiver {

    private final BookRepository repository;

    @KafkaListener(topics = "${spring.kafka.topic.book-added-event}")
    public void onBookAdded(Book book) {
        log.info("received payload='{}'", book);
        repository.save(book);
    }
}
