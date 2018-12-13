<%--
  Created by IntelliJ IDEA.
  User: YGKIM
  Date: 2018-12-13
  Time: 오후 4:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ironGG Public API Document</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="jumbotron text-center">
    <h1>ironGG Public API Document</h1>
    <p>Service-Oriented Computing & Practice, CSE, KoreaTech</p>
</div>

<div class="container">
    <h2>Current game</h2>
    <p>You can get progressing "League of Legends" match information through our public api.</p>

    </br></br>
    <h2>Match Information</h2>
    <p>Request information on ally and enemy teams in the match in progress.</p>

    <h3>URL</h3>
    <p>http://localhost:8080/currentGame/matchInformation?summonerName={summonerName}</p>

    <h3>Parameter</h3>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Name</th> <th>Type</th> <th>Description</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>summonerName</td> <td>String</td> <td>Summoner name of Korean server. Required values</td>
        </tr>
        </tbody>
    </table>

    <h3>MatchInformationDTO</h3>
    <p>This object contains </p>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Name</th> <th>Type</th> <th>Description</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>isProgress</td> <td>Boolean</td>
            <td>설명</td>
        </tr>
        <tr>
            <td>allyChampions</td> <td>ArrayList</td>
            <td>설명</td>
        </tr>
        <tr>
            <td>allyStats</td> <td>HashMap</td>
            <td>설명</td>
        </tr>
        <tr>
            <td>enemyChampions</td> <td>ArrayList</td>
            <td>설명</td>
        </tr>
        <tr>
            <td>enemyStats</td> <td>HashMap</td>
            <td>설명</td>
        </tr>
        </tbody>
    </table>

    <h3>Example Response</h3>
    <p>결과 예시</p>

    <h3>Execute Request</h3>
    <p>이곳에 요청 실행하는 부분을 추가하여라.</p>

    </br></br>
    <h2>Match Information</h2>
    <p>Request information on ally and enemy teams in the match in progress.</p>

    <h3>URL</h3>
    <p>http://localhost:8080/currentGame/matchInformation?summonerName={summonerName}</p>

    <h3>Parameter</h3>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Name</th> <th>Type</th> <th>Description</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>summonerName</td> <td>String</td> <td>Summoner name of Korean server. Required values</td>
        </tr>
        </tbody>
    </table>

    <h3>MatchInformationDTO</h3>
    <p>This object contains </p>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Name</th> <th>Type</th> <th>Description</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>isProgress</td> <td>Boolean</td>
            <td>설명</td>
        </tr>
        <tr>
            <td>allyChampions</td> <td>ArrayList</td>
            <td>설명</td>
        </tr>
        <tr>
            <td>allyStats</td> <td>HashMap</td>
            <td>설명</td>
        </tr>
        <tr>
            <td>enemyChampions</td> <td>ArrayList</td>
            <td>설명</td>
        </tr>
        <tr>
            <td>enemyStats</td> <td>HashMap</td>
            <td>설명</td>
        </tr>
        </tbody>
    </table>

    <h3>Example Response</h3>
    <p>결과 예시</p>

    <h3>Execute Request</h3>
    <p>이곳에 요청 실행하는 부분을 추가하여라.</p>

    </br></br>
    <h2>Match Information</h2>
    <p>Request information on ally and enemy teams in the match in progress.</p>

    <h3>URL</h3>
    <p>http://localhost:8080/currentGame/matchInformation?summonerName={summonerName}</p>

    <h3>Parameter</h3>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Name</th> <th>Type</th> <th>Description</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>summonerName</td> <td>String</td> <td>Summoner name of Korean server. Required values</td>
        </tr>
        </tbody>
    </table>

    <h3>MatchInformationDTO</h3>
    <p>This object contains </p>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Name</th> <th>Type</th> <th>Description</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>isProgress</td> <td>Boolean</td>
            <td>설명</td>
        </tr>
        <tr>
            <td>allyChampions</td> <td>ArrayList</td>
            <td>설명</td>
        </tr>
        <tr>
            <td>allyStats</td> <td>HashMap</td>
            <td>설명</td>
        </tr>
        <tr>
            <td>enemyChampions</td> <td>ArrayList</td>
            <td>설명</td>
        </tr>
        <tr>
            <td>enemyStats</td> <td>HashMap</td>
            <td>설명</td>
        </tr>
        </tbody>
    </table>

    <h3>Example Response</h3>
    <p>결과 예시</p>

    <h3>Execute Request</h3>
    <p>이곳에 요청 실행하는 부분을 추가하여라.</p>

    </br></br></br></br>
    <h4>Source Code</h4>
    <p>https://github.com/younggyu0906/LeagueOfLegendsInGameItemRecommender</p>
    </br>
    <h4>E-mail</h4>
    <p>이곳에 너의 이메일을 입력하는건 어때? 이런것도 추가해도 괜찮을듯</p>
    <p>younggyu0906@gmail.com</p>
</div>
</body>
</html>
