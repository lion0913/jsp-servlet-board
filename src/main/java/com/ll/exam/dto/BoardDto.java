package com.ll.exam.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BoardDto {
    private long id;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private String name;
    private String code;

    public BoardDto(long id, String createDate, String modifyDate, String name, String code) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime dateTime = LocalDateTime.parse(createDate, formatter);
        this.id = id;
        this.createDate = LocalDateTime.parse(createDate, formatter);
        this.modifyDate = LocalDateTime.parse(modifyDate, formatter);
        this.name = name;
        this.code = code;
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

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
