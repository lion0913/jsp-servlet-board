
<%@page import="java.awt.List"%>
<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%@ include file="../common/header.jspf"%>
<head>
    <link href="css/board.css" rel="stylesheet" type="text/css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <meta charset="EUC-KR">
    <title>board</title>
</head>
<body>
<div id="display">


    <div class="container">
        <button class="btn btn-dark" type="button" onclick="location.href='write'">글쓰기</button>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>번호</th>
                <th>카테고리</th>
                <th>작성일자</th>
                <th>제목</th>
                <th>내용</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${articleList}" var="list">
                <tr>
                    <td>${list.id}</td>
                    <td>${list.name}</td>
                    <td>${list.createdDate}</td>
                    <td>${list.title}</td>
                    <td>${list.body}</td>
                    <td><a onclick="if ( !confirm('정말로 삭제하시겠습니까?') ) return false;" class="w-[100px] hover:underline hover:text-[red]" href="/usr/article/delete/free/${list.id}">삭제</a></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>
</body>
<%@ include file="../common/footer.jspf"%>
</html>
