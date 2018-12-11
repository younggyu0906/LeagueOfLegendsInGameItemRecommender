package koreatech.cse.domain.rest;

import java.util.ArrayList;

public class RestOutChampion {
    int id;
    String championName;
    ArrayList<String> tag;


    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getChampionName() { return championName; }

    public void setChampionName(String championName) { this.championName = championName; }

    public ArrayList<String> getTag() { return tag; }

    public void setTag(ArrayList<String> tag) { this.tag = tag; }
}
