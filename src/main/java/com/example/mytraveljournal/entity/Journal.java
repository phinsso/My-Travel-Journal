package com.example.mytraveljournal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
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

}
