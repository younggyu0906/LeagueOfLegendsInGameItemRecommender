package koreatech.cse.domain.match;

import koreatech.cse.domain.staticData.ChampionDAO;

import java.util.ArrayList;

public class CurrentMatch {
    String summonerName;
    int myTeamId;
    ChampionDAO myChampion;
    ArrayList<ChampionDAO> teamChampions = new ArrayList<>();
    ArrayList<ChampionDAO> enemyChampions = new ArrayList<>();

    public String getSummonerName() {
        return summonerName;
    }

    public int getMyTeamId() {
        return myTeamId;
    }

    public void setMyTeamId(int myTeamId) {
        this.myTeamId = myTeamId;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public ChampionDAO getMyChampion() {
        return myChampion;
    }

    public void setMyChampion(ChampionDAO myChampion) {
        this.myChampion = myChampion;
    }

    public ArrayList<ChampionDAO> getTeamChampions() {
        return teamChampions;
    }

    public void addTeamChampions(ChampionDAO teamChampion) {
        this.teamChampions.add(teamChampion);
    }

    public ArrayList<ChampionDAO> getEnemyChampions() {
        return enemyChampions;
    }

    public void addEnemyChampions(ChampionDAO enemyChampion) {
        this.enemyChampions.add(enemyChampion);
    }

    @Override
    public String toString() {
        return "CurrentMatch{" +
                "summonerName='" + summonerName + '\'' +
                ", myChampion=" + myChampion + "\n" +
                ", teamChampions=" + teamChampions + "\n" +
                ", enemyChampions=" + enemyChampions +
                '}';
    }
}
