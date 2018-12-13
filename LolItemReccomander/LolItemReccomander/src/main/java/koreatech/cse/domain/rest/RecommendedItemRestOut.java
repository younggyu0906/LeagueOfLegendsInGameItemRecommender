package koreatech.cse.domain.rest;

import java.util.ArrayList;

public class RecommendedItemRestOut {
    Boolean isProgress;
    String championName;
    ArrayList<String> recommendedItems;

    public Boolean getIsProgress() {
        return isProgress;
    }

    public void setIsProgress(Boolean progress) {
        isProgress = progress;
    }

    public void addItemNames(String item) {
        recommendedItems.add(item);
    }

    public String getChampionName() {
        return championName;
    }

    public void setChampionName(String championName) {
        this.championName = championName;
    }

    public ArrayList<String> getRecommendedItems() {
        return recommendedItems;
    }

    public void setRecommendedItems(ArrayList<String> recommendedItems) {
        this.recommendedItems = recommendedItems;
    }
}
