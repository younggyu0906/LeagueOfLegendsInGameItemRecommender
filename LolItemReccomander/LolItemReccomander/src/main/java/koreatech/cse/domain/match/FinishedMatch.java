package koreatech.cse.domain.match;

public class FinishedMatch {
    int id;
    int championId;
    int itemId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChampionId() {
        return championId;
    }

    public void setChampionId(int championId) {
        this.championId = championId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "FinishedMatch{" +
                "id=" + id +
                ", championId=" + championId +
                ", itemId=" + itemId +
                '}';
    }
}
