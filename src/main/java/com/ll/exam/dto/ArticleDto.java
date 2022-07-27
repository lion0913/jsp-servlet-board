package com.ll.exam.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ArticleDto {
    private long id;
    private LocalDateTime createDate;
    private String title;
    private String body;

    private String name;

    public ArticleDto(long id, String createDate, String title, String body, String name) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.id = id;
        this.createDate = LocalDateTime.parse(createDate, formatter);
        this.title = title;
        this.body = body;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ArticleDto{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
