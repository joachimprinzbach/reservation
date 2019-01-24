package com.joachim.books.reservation.web;

import com.joachim.books.reservation.repository.BookRepository;
import com.joachim.books.shelf.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping("/reservation/api/v1/books")
@RequiredArgsConstructor
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class BookLendingRestController {

    private final BookRepository repository;

    @GetMapping(produces = {"application/hal+json"})
    public ResponseEntity<?> getAllLendingBooks() {
        List<Book> allBooks = repository.findAll();
        List<Resource<Book>> books = allBooks.stream()
                .map(book -> {
                    Resource<Book> resource = new Resource<>(book);
                    Link link = linkTo(BookLendingRestController.class).slash(book.getId()).withSelfRel();
                    resource.add(link);
                    return resource;
                })
                .collect(Collectors.toList());
        return new ResponseEntity<>(books, HttpStatus.CREATED);

    }

}
