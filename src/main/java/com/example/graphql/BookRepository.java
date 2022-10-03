package com.example.graphql;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    Iterable<Book> findBooksByAuthor_Id(Long authorId);

}
