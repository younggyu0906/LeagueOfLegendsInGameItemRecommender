package koreatech.cse.domain.rest;

import java.util.HashMap;

public class RecommendedItemDTO {
    Boolean isProgress;
    String championName;
    HashMap<Integer, String> recommendedItems = new HashMap<>();

    public Boolean getIsProgress() {
        return isProgress;
    }

    public void setIsProgress(Boolean progress) {
        isProgress = progress;
    }

    public void addItemNames(int itemCode, String item) {
        recommendedItems.put(itemCode, item);
    }

    public String getChampionName() {
        return championName;
    }

    public void setChampionName(String championName) {
        this.championName = championName;
    }

    public HashMap<Integer, String> getRecommendedItems() {
        return recommendedItems;
    }

    public void setRecommendedItems(HashMap<Integer, String> recommendedItems) {
        this.recommendedItems = recommendedItems;
    }
}
