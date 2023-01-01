package com.hithesh.exceptionhandling.repository;

import com.hithesh.exceptionhandling.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends CrudRepository<Book,Integer> {
}
