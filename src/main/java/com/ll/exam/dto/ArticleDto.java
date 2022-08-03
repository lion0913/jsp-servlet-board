package com.ll.exam.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {

    private long id;

    private String createdDate;

    private String title;

    private String body;

    private String name;

    ArticleDto(int id, LocalDateTime createdDate, String title, String body, String name) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String text = createdDate.format(formatter);

        this.id = id;
        this.createdDate = createdDate.format(formatter);
        this.title = title;
        this.body = body;
        this.name = name;
    }

}
