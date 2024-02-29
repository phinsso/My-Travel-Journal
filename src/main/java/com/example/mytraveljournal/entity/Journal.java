package com.example.mytraveljournal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Journal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 기본키

    @Column
    private String title; // 제목

    @Column
    private String place; // 장소

    @Column
    private LocalDate startDate; // 여행 시작일

    @Column
    private LocalDate endDate; // 여행 종료일

    @Column
    private String content; // 본문 내용

    @Column
    private byte[] image; // 이미지

    // 일부 데이터 수정 시, 기존 데이터가 날아가는 현상을 방지하기 위한 메서드
    public void patch(Journal journal) {
        if(journal.title != null)
            this.title = journal.title;
        if(journal.place != null)
            this.place = journal.place;
        if(journal.startDate != null)
            this.startDate = journal.startDate;
        if(journal.endDate != null)
            this.endDate = journal.endDate;
        if(journal.content != null)
            this.content = journal.content;
        if(journal.image != null)
            this.image = journal.image;
    }
}
