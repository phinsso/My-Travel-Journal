package com.example.mytraveljournal.controller;

import com.example.mytraveljournal.dto.JournalDto;
import com.example.mytraveljournal.entity.Journal;
import com.example.mytraveljournal.service.JournalService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class JournalController {

    @Autowired
    private JournalService journalService; // 서비스 객체 주입

    // GET
    // 전체 조회
    @GetMapping("api/journals")
    public List<Journal> findAllJournals() {
        return journalService.findAllJournals();
    }

    // 단일 조회
    @GetMapping("api/journals/{id}")
    public Journal findJournalById(@PathVariable Long id) {
        return journalService.findJournalById(id);
    }


    // POST
    @PostMapping("api/journals")
    public ResponseEntity<Journal> create(@RequestBody JournalDto dto) {
        Journal created = journalService.create(dto);
        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


    // PATCH
    @PatchMapping("api/journals/{id}")
    public ResponseEntity<Journal> update(@PathVariable Long id, @RequestBody JournalDto dto) {
        Journal updated = journalService.update(id, dto);
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


    // DELETE
    @DeleteMapping("api/journals/{id}")
    public ResponseEntity<Journal> delete(@PathVariable Long id) {
        Journal deleted = journalService.delete(id);
        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
