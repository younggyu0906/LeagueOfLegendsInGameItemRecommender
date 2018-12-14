<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>RestTest</title>
    <%--using bootstrap--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%--ChampionDAO 테스트 페이지--%>
<c:forEach var="champion" items="${champions}">
    이름: ${champion.name}
    id: ${champion.id}<br/>
    attack: ${champion.attack}
    magic: ${champion.magic}
    defense: ${champion.defense}
    difficulty: ${champion.difficulty}<br/>
    Mage: ${champion.mage}
    Tank: ${champion.tank}
    Assassin: ${champion.assassin}
    Fighter: ${champion.fighter}
    Support: ${champion.support}
    Marksman: ${champion.marksman}<br/>
    -------------------------<br/>
</c:forEach>

<c:forEach var="item" items="${items}">
    ${item.toString()}<br/>
    -------------------------<br/>
</c:forEach>


</body>
</html>
