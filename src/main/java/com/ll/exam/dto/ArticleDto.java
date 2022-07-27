package com.ll.exam.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {

    private long id;

    private LocalDateTime createdDate;

    private String title;

    private String body;

    private String name;

}
