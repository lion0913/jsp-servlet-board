<%--
  Created by IntelliJ IDEA.
  User: dajung
  Date: 2022/07/25
  Time: 4:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>초록창</h1>
    <div id="display">
        <form action="write" method="post">
            <input type="text" placeholder="작성자" name="userID" required="required"><br>
            <input type="text" placeholder="제목" name="title" required="required"><br>
            <input type="text" placeholder="내용" name="content" required="required"><br>
            <input type="submit" value="확인">
        </form>
    </div>
</body>
</html>
