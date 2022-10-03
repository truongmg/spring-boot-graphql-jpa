package com.example.graphql;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(AuthorRepository authorRepository, BookRepository bookRepository) {
        return args -> {
            Author truong = authorRepository.save(new Author(null, "Truong"));
            Author muoi = authorRepository.save(new Author(null, "Muoi"));
            bookRepository.saveAll(List.of(
               new Book("fun", "truong", truong),
               new Book("oh oh", "minh", truong),
               new Book("oh oh", "minh", truong),
               new Book("oh oh", "minh", truong),
               new Book("oh oh", "minh", truong),
               new Book("oh oh", "minh", truong),
               new Book("oh oh", "minh", truong),
               new Book("oh oh", "minh", truong),
               new Book("not fun", "muoi", muoi),
               new Book("not fun", "muoi", muoi),
               new Book("not fun", "muoi", muoi),
               new Book("not fun", "muoi", muoi),
               new Book("not fun", "muoi", muoi),
               new Book("not fun", "muoi", muoi),
               new Book("not fun", "muoi", muoi),
               new Book("not fun", "muoi", muoi)
            ));
        };
    }

}
