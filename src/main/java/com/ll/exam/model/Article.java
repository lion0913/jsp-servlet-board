package com.ll.exam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private long id;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    private String title;
    private String body;
    private long boardId;

}
