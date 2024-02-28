package com.example.mytraveljournal.dto;

import com.example.mytraveljournal.entity.Journal;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@ToString
public class JournalDto {

    private Long id;
    private String title;
    private String place;
    private LocalDate startDate;
    private LocalDate endDate;
    private String content;
    private byte[] image;

    public Journal toEntity() {
        return new Journal(id, title, place, startDate, endDate, content, image);
    }
}
