package com.joachim.books.reservation.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.hateoas.Identifiable;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Book extends AbstractAggregateRoot<Book> implements Identifiable<UUID> {

    @Id
    private UUID id;
    private String isbn;
    private String title;
    private String subtitle;
    private String description;
    private String thumbnailLink;
    private int pageCount;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime created;

    public static Book of(String isbn, String title, String subtitle, String description, String thumbnailLink, int pageCount) {
        return new Book(UUID.randomUUID(), isbn, title, subtitle, description, thumbnailLink, pageCount, LocalDateTime.now());
    }

}
