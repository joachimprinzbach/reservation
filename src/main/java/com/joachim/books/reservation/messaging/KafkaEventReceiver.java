package com.joachim.books.reservation.messaging;

import com.joachim.books.reservation.repository.BookRepository;
import com.joachim.books.shelf.model.Book;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaEventReceiver {

    private final BookRepository repository;

   /* @KafkaListener(topics = "${spring.kafka.topic.book-added-event}")
    public void onBookAdded(Book book) {
        log.info("received payload='{}'", book);
        repository.save(book);
    }*/

    @KafkaListener(id = "receiver-api",
            topicPartitions =
                    {@TopicPartition(topic = "${spring.kafka.topic.book-added-event}",
                            partitionOffsets = @PartitionOffset(partition = "0", initialOffset = "0")),
                    })
    public void onBookAdded(Book book) {
        log.info("received payload='{}'", book);
        repository.save(book);
    }
}
