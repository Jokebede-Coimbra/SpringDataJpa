package com.bookstore.jpa.repositories;

import com.bookstore.jpa.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<BookModel, UUID> {

//    BookModel findBookModelByTitle(String title);
//
//    @Query(value = "SELECT * FROM tb_book WHERE publisher_id = :id", nativeQuery = true)
//    List<BookModel> findBooksByPublisherId(@Param("id") UUID id);

}
