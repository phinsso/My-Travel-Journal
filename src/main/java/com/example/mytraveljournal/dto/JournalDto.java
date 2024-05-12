package com.example.mytraveljournal.dto;

import com.example.mytraveljournal.entity.Journal;
import jakarta.websocket.server.ServerEndpoint;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class JournalDto {

    private Long id;
    private String title;
    private String place;
    private LocalDate startDate;
    private LocalDate endDate;
    private String content;

    public Journal toEntity() {
        return new Journal(null, title, place, startDate, endDate, content);
    }
}
