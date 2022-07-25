<%--
  Created by IntelliJ IDEA.
  User: dajung
  Date: 2022/07/25
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <h1>초록창</h1>
    <form action="https://search.naver.com/search.naver" target="_blank">
        <input type="hidden" name="where" value="nexearch" readonly>
        <input type="hidden" name="sm" value="top_hty" readonly>
        <input type="hidden" name="fbm" value="0" readonly>
        <input type="hidden" name="ie" value="utf8" readonly></div>
        <div><input type="text" name="query" value="검색어 입력"></div>
        <div><input type="submit" value="검색"></div>
    </form>
</html>
