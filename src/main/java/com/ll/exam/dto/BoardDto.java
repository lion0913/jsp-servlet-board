package com.ll.exam.dto;

import java.time.LocalDateTime;

public class BoardDto {
    private long id;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private String name;
    private String code;

    public BoardDto(long id, String createDate, String modifyDate, String name, String code) {
        this.id = id;
        this.createDate = LocalDateTime.parse(createDate);
        this.modifyDate = LocalDateTime.parse(modifyDate);
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
