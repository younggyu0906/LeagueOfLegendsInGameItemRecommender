package koreatech.cse.domain.rest;

import java.util.ArrayList;
import java.util.HashMap;

public class ChampionInfoRestOut {

    boolean isProgress;
    String championName;
    ArrayList<String> tag = new ArrayList<>();
    HashMap<String, Integer> stats = new HashMap<>();
    HashMap<String, Double> winRate = new HashMap<>();
    HashMap<String, Double> playRate = new HashMap<>();
    HashMap<String, Double> banRate = new HashMap<>();

    public ChampionInfoRestOut() {
        isProgress = false;
    }

    public boolean getIsProgress() {
        return isProgress;
    }

    public void setIsProgress(boolean progress) {
        isProgress = progress;
    }

    public String getChampionName() { return championName; }

    public void setChampionName(String championName) { this.championName = championName; }

    public ArrayList<String> getTag() { return tag; }

    public void setTag(ArrayList<String> tag) { this.tag = tag; }

    public void addTag(String tagName) {
        this.tag.add(tagName);
    }

    public HashMap<String, Integer> getStats() {
        return stats;
    }

    public void setStats(HashMap<String, Integer> stats) {
        this.stats = stats;
    }

    public void putStats(String statName, int statValue) {
        this.stats.put(statName, statValue);
    }

    public HashMap<String, Double> getWinRate() {
        return winRate;
    }

    public void setWinRate(HashMap<String, Double> winRate) {
        this.winRate = winRate;
    }

    public void putWinRate(String elo, double rate) {
        this.winRate.put(elo, rate);
    }

    public HashMap<String, Double> getPlayRate() {
        return playRate;
    }

    public void setPlayRate(HashMap<String, Double> playRate) {
        this.playRate = playRate;
    }

    public void putPlayRate(String elo, double rate) {
        this.playRate.put(elo, rate);
    }

    public HashMap<String, Double> getBanRate() {
        return banRate;
    }

    public void setBanRate(HashMap<String, Double> banRate) {
        this.banRate = banRate;
    }

    public void putBanRate(String elo, double rate) {
        this.banRate.put(elo, rate);
    }
}