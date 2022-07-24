package com.ll.exam.type.board;

public enum BoardType {
    FREE("자유"),
    NOTICE("공지사항");

    private String value;

    BoardType(String value) { this.value = value;}


    public String getKey() {
        return name();
    }

    public String getValue() {
        return value;
    }
}
