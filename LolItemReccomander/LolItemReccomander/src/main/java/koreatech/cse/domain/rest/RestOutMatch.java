package koreatech.cse.domain.rest;

import java.util.ArrayList;
import java.util.Map;

public class RestOutMatch {
    boolean isProgress;
    ArrayList<Map<String, ArrayList>> allyChampions = new ArrayList<>();
    Map<String, Integer> allyStats;
    ArrayList<Map<String, ArrayList>> enemyChampions = new ArrayList<>();
    Map<String, Integer> enemyStats;

    public boolean isProgress() {
        return isProgress;
    }

    public void setProgress(boolean progress) {
        isProgress = progress;
    }

    public ArrayList<Map<String, ArrayList>> getAllyChampions() {
        return allyChampions;
    }

    public void setAllyChampions(ArrayList<Map<String, ArrayList>> allyChampions) {
        this.allyChampions = allyChampions;
    }

    public Map<String, Integer> getAllyStats() {
        return allyStats;
    }

    public void setAllyStats(Map<String, Integer> allyStats) {
        this.allyStats = allyStats;
    }

    public ArrayList<Map<String, ArrayList>> getEnemyChampions() {
        return enemyChampions;
    }

    public void setEnemyChampions(ArrayList<Map<String, ArrayList>> enemyChampions) {
        this.enemyChampions = enemyChampions;
    }

    public Map<String, Integer> getEnemyStats() {
        return enemyStats;
    }

    public void setEnemyStats(Map<String, Integer> enemyStats) {
        this.enemyStats = enemyStats;
    }
}
