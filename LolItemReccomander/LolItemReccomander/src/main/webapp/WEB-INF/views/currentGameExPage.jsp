<%--
  Created by IntelliJ IDEA.
  User: LeeJaeYoung
  Date: 2018-12-13
  Time: 오후 4:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Current Game data</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<form action="/requestRecommendedItem" method="get">
    <div class="form-group">
        <label for="summonerName">소환사명으로 진행 중인 게임 추천 아이템 검색하기</label>
        <input class="form-control input-lg" id="summonerName" name="summonerName" type="text">
        <input type="submit" value="검색하기"/>
    </div>
</form>


</body>
</html>
