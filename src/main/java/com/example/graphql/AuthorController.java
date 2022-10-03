package com.example.graphql;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @QueryMapping
    Iterable<Author> authors() {
        return authorRepository.findAll();
    }

    @QueryMapping
    Optional<Author> authorById(@Argument Long id) {
        return authorRepository.findById(id);
    }

    @SchemaMapping
    Iterable<Book> books(Author author) {
        return bookRepository.findBooksByAuthor_Id(author.getId());
    }

    @MutationMapping
    Book addBook(@Argument BookInput book) {
        Author author = authorRepository.findById(book.authorId)
                .orElseThrow(() -> new IllegalArgumentException("Author id not exist"));
        Book b = new Book(book.title, book.publisher, author);
        return bookRepository.save(b);
    }

    record BookInput(String title, String publisher, Long authorId) {}
}
