package com.example.mytraveljournal.service;

import com.example.mytraveljournal.dto.JournalDto;
import com.example.mytraveljournal.entity.Journal;
import com.example.mytraveljournal.repository.JournalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class JournalService {

    @Autowired
    private JournalRepository journalRepository; // 리파지터리 객체 주입

    public List<Journal> findAllJournals() {
        return journalRepository.findAll();
    }

    public Journal findJournalById(Long id) {
        return journalRepository.findById(id).orElse(null);
    }

    public Journal create(JournalDto dto) {
        Journal journal = dto.toEntity();
        if(journal.getId() != null)
            return null;

        return journalRepository.save(journal);
    }

    public Journal update(Long id, JournalDto dto) {
        // dto -> entity
        Journal journal = dto.toEntity();

        // 타깃 조회 (수정하려는 타깃이 db에 존재하는지)
        Journal target = journalRepository.findById(id).orElse(null);

        // 잘못된 요청 처리 (대상 엔티티가 없거나, 수정 요청 id와 본문 id가 다를 경우)
        if(target == null || id != journal.getId()) {
            log.info("잘못된 요청. id: {}, journal: {}", id, journal.toString());
            return null;
        }

        // 업데이트 및 정상 응답
        target.patch(journal); // 기존 데이터에 새 데이터 붙이기
        Journal updated = journalRepository.save(target);
        return updated;
    }

    public Journal delete(Long id) {
        // 삭제할 대상 찾기
        Journal target = journalRepository.findById(id).orElse(null);

        // 잘못된 요청 처리 (삭제 요청이 들어온 대상이 존재하지 않는 경우)
        if(target == null)
            return null;

        // 대상 삭제
        journalRepository.delete(target);
        return target; // 삭제한 대상을 보내줘야 하므로 target 반환
    }
}
