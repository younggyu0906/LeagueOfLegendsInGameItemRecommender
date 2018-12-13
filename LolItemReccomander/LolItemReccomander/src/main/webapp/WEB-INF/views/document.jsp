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
    <p>Game patch version is ${riot.version}, Korea.</p>

    </br></br>
    <h2>Match Information</h2>
    <p>Request information on ally and enemy teams in the match in progress.</p>

    <h3>Request URL</h3>
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
            <td>summonerName</td> <td>String</td> <td>Summoner name of Korean server.</td>
        </tr>
        </tbody>
    </table>

    <h3>MatchInformationDTO</h3>
    <p>This object contains information about the game that the summoner is currently playing.</p>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Name</th> <th>Type</th> <th>Description</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>isProgress</td> <td>Boolean</td>
            <td>Whether the game is in progress. True if in progress, or False.</td>
        </tr>
        <tr>
            <td>allyChampions</td> <td>ArrayList&lt;championTags&gt;</td>
            <td>Ally champions name and tags.</td>
        </tr>
        <tr>
            <td>allyStats</td> <td>HashMap&lt;String,Intager&gt;</td>
            <td>Stats of ally team. The key is stat name, the value is stat value.</td>
        </tr>
        <tr>
            <td>enemyChampions</td> <td>ArrayList&lt;championTags&gt;</td>
            <td>Enemy champions name and tags.</td>
        </tr>
        <tr>
            <td>enemyStats</td> <td>HashMap&lt;String,Intager&gt;</td>
            <td>Stats of enemy team. The key is stat name, the value is stat value.</td>
        </tr>
        </tbody>
    </table>
    <h4>championTags</h4>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Name</th> <th>Type</th> <th>Description</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>championTags</td> <td>HashMap&lt;String, ArrayList&lt;String&gt;&gt;</td>
            <td>The key is champion name, the value is ArrayList of champion tags.</td>
        </tr>
        </tbody>
    </table>

    <h3>Example Response</h3>
    <div class="panel panel-default">
        <div class="panel-body">
            {"isProgress":true,"allyChampions":[{"Cassiopeia":["Mage"]},{"Ezreal":["Mage","Marksman"]},{"Elise":["Fighter","Mage"]},{"Morgana":["Mage","Support"]},{"Vladimir":["Mage","Tank"]}],"allyStats":{"magic":38,"defense":22,"attack":18},"enemyChampions":[{"Syndra":["Mage","Support"]},{"Pyke":["Assassin","Support"]},{"Kai'Sa":["Marksman"]},{"Kha'Zix":["Assassin","Fighter"]},{"Viktor":["Mage"]}],"enemyStats":{"magic":26,"defense":19,"attack":30}}
        </div>
    </div>

    <h3>Execute Request</h3>
    <form>
        <div class="form-group">
            <label for="usr">summonerName:</label>
            <input type="text" class="form-control" id="usr">
        </div>
    </form>
    <button type="button" class="btn btn-danger">Execute Request</button>
    <p>이곳에 요청 실행하는 부분을 추가하여라. 어떻게 사용하는진 모르겠어. 틀만 만들어봤어</p>

    </br></br>
    <h2>Champion Information</h2>
    <p>Request information on ally and enemy teams in the match in progress.</p>

    <h3>Request URL</h3>
    <p>http://localhost:8080/currentGame/championInformation?summonerName={summonerName}</p>

    <h3>Parameter</h3>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Name</th> <th>Type</th> <th>Description</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>summonerName</td> <td>String</td> <td>Summoner name of Korean server.</td>
        </tr>
        </tbody>
    </table>

    <h3>ChampionInformationDTO</h3>
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
            <td>Whether the game is in progress. True if in progress, or False.</td>
        </tr>
        <tr>
            <td>championName</td> <td>String</td>
            <td>The champion name that the summoner are playing.</td>
        </tr>
        <tr>
            <td>tag</td> <td>ArrayList&lt;String&gt;</td>
            <td>ArrayList of the champion Classification.</td>
        </tr>
        <tr>
            <td>stats</td> <td>HashMap&lt;String, Intager&gt;</td>
            <td>Stats of the champion. The key is stat name, the value is stat value.</td>
        </tr>
        <tr>
            <td>winRate</td> <td>HashMap&lt;String, Double&gt;</td>
            <td>설명</td>
        </tr>
        <tr>
            <td>playRate</td> <td>HashMap&lt;String, Double&gt;</td>
            <td>설명</td>
        </tr>
        <tr>
            <td>banRate</td> <td>HashMap&lt;String, Double&gt;</td>
            <td>설명</td>
        </tr>
        </tbody>
    </table>

    <h3>Example Response</h3>
    <div class="panel panel-default">
        <div class="panel-body">결과 예시</div>
    </div>

    <h3>Execute Request</h3>
    <form>
        <div class="form-group">
            <label for="usr">summonerName:</label>
            <input type="text" class="form-control" id="usr2">
        </div>
    </form>
    <button type="button" class="btn btn-danger">Execute Request</button>
    <p>이곳에 요청 실행하는 부분을 추가하여라. 어떻게 사용하는진 모르겠어. 틀만 만들어봤어</p>

    </br></br>
    <h2>Recommended Items</h2>
    <p>Request information on ally and enemy teams in the match in progress.</p>

    <h3>Request URL</h3>
    <p>http://localhost:8080/currentGame/recommendedItem?summonerName={summonerName}</p>

    <h3>Parameter</h3>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Name</th> <th>Type</th> <th>Description</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>summonerName</td> <td>String</td> <td>Summoner name of Korean server.</td>
        </tr>
        </tbody>
    </table>

    <h3>RecommendedItemDTO</h3>
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
            <td>Whether the game is in progress. True if in progress, or False.</td>
        </tr>
        <tr>
            <td>championName</td> <td>String</td>
            <td>설명</td>
        </tr>
        <tr>
            <td>recommendedItems</td> <td>ArrayListString</td>
            <td>설명</td>
        </tr>
        </tbody>
    </table>

    <h3>Example Response</h3>
    <div class="panel panel-default">
        <div class="panel-body">결과 예시</div>
    </div>

    <h3>Execute Request</h3>
    <form>
        <div class="form-group">
            <label for="usr">summonerName:</label>
            <input type="text" class="form-control" id="usr3">
        </div>
    </form>
    <button type="button" class="btn btn-danger">Execute Request</button>
    <p>이곳에 요청 실행하는 부분을 추가하여라. 어떻게 사용하는진 모르겠어. 틀만 만들어봤어</p>


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
