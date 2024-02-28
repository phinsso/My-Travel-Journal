package com.example.mytraveljournal.repository;

import com.example.mytraveljournal.entity.Journal;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface JournalRepository extends CrudRepository<Journal, Long> {

    @Override
    ArrayList<Journal> findAll();
}
