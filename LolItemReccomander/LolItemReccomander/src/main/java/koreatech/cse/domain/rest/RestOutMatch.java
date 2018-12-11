package koreatech.cse.domain.rest;

import java.util.ArrayList;
import java.util.HashMap;

public class RestOutMatch {
    boolean isProgress;
    ArrayList<HashMap<String, ArrayList<String>>> allyChampions = new ArrayList<>();
    HashMap<String, Integer> allyStats = new HashMap<>();
    ArrayList<HashMap<String, ArrayList<String>>> enemyChampions = new ArrayList<>();
    HashMap<String, Integer> enemyStats = new HashMap<>();;

    public RestOutMatch() {
        isProgress = false;
        allyStats.put("attack", 0);
        allyStats.put("defense", 0);
        allyStats.put("magic", 0);
        enemyStats.put("attack", 0);
        enemyStats.put("defense", 0);
        enemyStats.put("magic", 0);
    }

    public boolean isProgress() {
        return isProgress;
    }

    public void setProgress(boolean progress) {
        isProgress = progress;
    }

    public ArrayList<HashMap<String, ArrayList<String>>> getAllyChampions() {
        return allyChampions;
    }

    public void setAllyChampions(ArrayList<HashMap<String, ArrayList<String>>> allyChampions) {
        this.allyChampions = allyChampions;
    }

    public HashMap<String, Integer> getAllyStats() {
        return allyStats;
    }

    public void setAllyStats(HashMap<String, Integer> allyStats) {
        this.allyStats = allyStats;
    }

    public void addAndPutAllyStats(String statName, int statValue) {
        int value = this.allyStats.get(statName);
        value += statValue;
        this.allyStats.put(statName, value);
    }

    public ArrayList<HashMap<String, ArrayList<String>>> getEnemyChampions() {
        return enemyChampions;
    }

    public void setEnemyChampions(ArrayList<HashMap<String, ArrayList<String>>> enemyChampions) {
        this.enemyChampions = enemyChampions;
    }

    public HashMap<String, Integer> getEnemyStats() {
        return enemyStats;
    }

    public void setEnemyStats(HashMap<String, Integer> enemyStats) {
        this.enemyStats = enemyStats;
    }

    public void addAndPutEnemyStats(String statName, int statValue) {
        int value = this.enemyStats.get(statName);
        value += statValue;
        this.enemyStats.put(statName, value);
    }

    public void addAllyChampions(HashMap<String, ArrayList<String>> champion) {
        this.allyChampions.add(champion);
    }

    public void addAllyStats() {
        return;
    }

    public void addEnemyChmapions(HashMap<String, ArrayList<String>> champion) {
        this.enemyChampions.add(champion);
    }

    public void addEnemyStats() {
        return;
    }
}
