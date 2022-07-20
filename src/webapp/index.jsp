<%--<%@page import="java.awt.List"%>--%>
<%--<%@page import="java.io.Console"%>--%>
<%--<%@page import="com.ll.exam.dto.BoardDto"%>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <link href="css/main.css" rel="stylesheet" type="text/css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="EUC-KR">
    <title>게시판</title>
</head>
<body>
<div id="display">
    <div id="header">
        <h1>박다정의 게시판 메인화면</h1>
    </div>
    <div id="section">
        <div class="board"><a href="#">로그인(미구현)</a></div>
        <div class="login"><a href="list">게시글 리스트</a></div>
    </div>
    <div id="footer">
        <span>나는 박다정. 멋사 백엔드 스쿨 다니는중</span>
    </div>

</div>
</body>
</html>
