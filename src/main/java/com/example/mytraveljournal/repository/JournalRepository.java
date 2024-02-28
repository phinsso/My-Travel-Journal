package com.example.mytraveljournal.repository;

import com.example.mytraveljournal.entity.Journal;
import org.springframework.data.repository.CrudRepository;

public interface JournalRepository extends CrudRepository<Journal, Long> {
}
