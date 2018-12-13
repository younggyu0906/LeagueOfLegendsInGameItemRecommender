<%--
  Created by IntelliJ IDEA.
  User: YGKIM
  Date: 2018-12-13
  Time: 오후 4:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div class="jumbotron text-center" style="background-image: url(https://4.bp.blogspot.com/-tuGhY7q8LVw/W6wOujB78XI/AAAAAAABIJc/2h0uDwU6fcE9MASeTXM-kHNeYOwnrG_UACLcBGAs/s1600/Dn4NDQFU0AAntFZ.jpg);
         background-size: 100%; height:100vh; background-blend-mode:hard-light;">
    <h1 style="color: white;">ironGG Public API Document</h1>
    <p style="color: white;">Service-Oriented Computing & Practice, CSE, KoreaTech</p>
</div>

<div class="container">
    <h2>Current game</h2>
    <p>You can get progressing "League of Legends" match information through our public api.</p>
    <p>Game patch version is ${riot.version}, Korea.</p>

    </br></br>
    <h2>Match Information</h2>
    <p>Request information on ally and enemy teams in the match in progress.</p>

    <h3>Request URL</h3>
    <div class="panel panel-default">
        <div class="panel-body">http://localhost:8080/currentGame/matchInformation?summonerName={summonerName}</div>
    </div>

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
    <form action="/requestMatchInfo" method="get">
        <div class="form-group">
            <label for="summonerName">summonerName:</label>
            <input type="text" class="form-control" id="summonerName" name="summonerName">
        </div>
        <button type="submit" class="btn btn-danger">Execute Request</button>
    </form>

    </br></br>
    <h2>Champion Information</h2>
    <p>Request information on ally and enemy teams in the match in progress.</p>

    <h3>Request URL</h3>
    <div class="panel panel-default">
        <div class="panel-body">http://localhost:8080/currentGame/championInformation?summonerName={summonerName}</div>
    </div>

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
            <td>The champion name that the summoner is playing.</td>
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
            <td>The win rate of the champion that the summoner is playing. The key is elo, the value is rate.</td>
        </tr>
        <tr>
            <td>playRate</td> <td>HashMap&lt;String, Double&gt;</td>
            <td>The play rate of the champion that the summoner is playing. The key is elo, the value is rate.</td>
        </tr>
        <tr>
            <td>banRate</td> <td>HashMap&lt;String, Double&gt;</td>
            <td>The ban rate of the champion that the summoner is playing. The key is elo, the value is rate.</td>
        </tr>
        </tbody>
    </table>

    <h3>Example Response</h3>
    <div class="panel panel-default">
        <div class="panel-body">{"isProgress":true,"championName":"Yasuo","tag":["Assassin","Fighter"],"stats":{"magic":4,"difficulty":10,"defense":4,"attack":8},"
            </br>
            winRate":{"GOLD":0.47959591918383676,"BRONZE":0.5018973437187937,"PLATINUM,DIAMOND,MASTER,CHALLENGER":0.47825206908960055,
            </br>
            "SILVER":0.491381144924452,"PLATINUM":0.4802727715538237},
            </br>
            "playRate":{"GOLD":0.06319928191253998,"BRONZE":0.07510589188246611,"PLATINUM,DIAMOND,MASTER,CHALLENGER":0.059033078429971124,
            </br>
            "SILVER":0.06715971274775624,"PLATINUM":0.06031166680761853},
            </br>
            "banRate":{"GOLD":0.0551603054400182,"BRONZE":0.054520910088027674,"PLATINUM,DIAMOND,MASTER,CHALLENGER":0.04977950995722945,
            </br>
            "SILVER":0.05558648921136646,"PLATINUM":0.053164072410677325}}</div>
    </div>

    <h3>Execute Request</h3>
    <form action="/requestChampionInformation" method="get">
        <div class="form-group">
            <label for="summonerName2">summonerName:</label>
            <input type="text" class="form-control" id="summonerName2" name="summonerName">
        </div>
        <button type="submit" class="btn btn-danger">Execute Request</button>
    </form>

    </br></br>
    <h2>Recommended Items</h2>
    <p>Request information on ally and enemy teams in the match in progress.</p>

    <h3>Request URL</h3>
    <div class="panel panel-default">
        <div class="panel-body">http://localhost:8080/currentGame/recommendedItem?summonerName={summonerName}</div>
    </div>

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
            <td>The champion name that the summoner is playing.</td>
        </tr>
        <tr>
            <td>recommendedItems</td> <td>ArrayList&lt;String&gt;</td>
            <td>ArrayList of recommended items.</td>
        </tr>
        </tbody>
    </table>

    <h3>Example Response</h3>
    <div class="panel panel-default">
        <div class="panel-body">{"isProgress":true,"championName":"Kha'Zix","recommendedItems":["Duskblade of Draktharr","Enchantment: Warrior","Youmuu's Ghostblade","Enchantment: Warrior","Maw of Malmortius","Mercury's Treads"]}</div>
    </div>

    <h3>Execute Request</h3>
    <form action="/requestRecommendedItem" method="get">
        <div class="form-group">
            <label for="summonerName3">summonerName:</label>
            <input type="text" class="form-control" id="summonerName3" name="summonerName">
        </div>
        <button type="submit" class="btn btn-danger">Execute Request</button>
    </form>


    </br></br></br></br>
    <h4>Source Code</h4>
    <p>https://github.com/younggyu0906/LeagueOfLegendsInGameItemRecommender</p>
    </br>
    <h4>E-mail</h4>
    <p>vkv6581@gmail.com</p>
    <p>younggyu0906@gmail.com</p>
</div>
</body>
</html>
