package koreatech.cse.domain.match;

public class FinishedMatch {
    int id;
    int championId;
    int item0Id;
    int item1Id;
    int item2Id;
    int item3Id;
    int item4Id;
    int item5Id;
    int item6Id;

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

    public int getItem0Id() {
        return item0Id;
    }

    public void setItem0Id(int item0Id) {
        this.item0Id = item0Id;
    }

    public int getItem1Id() {
        return item1Id;
    }

    public void setItem1Id(int item1Id) {
        this.item1Id = item1Id;
    }

    public int getItem2Id() {
        return item2Id;
    }

    public void setItem2Id(int item2Id) {
        this.item2Id = item2Id;
    }

    public int getItem3Id() {
        return item3Id;
    }

    public void setItem3Id(int item3Id) {
        this.item3Id = item3Id;
    }

    public int getItem4Id() {
        return item4Id;
    }

    public void setItem4Id(int item4Id) {
        this.item4Id = item4Id;
    }

    public int getItem5Id() {
        return item5Id;
    }

    public void setItem5Id(int item5Id) {
        this.item5Id = item5Id;
    }

    public int getItem6Id() {
        return item6Id;
    }

    public void setItem6Id(int item6Id) {
        this.item6Id = item6Id;
    }

    @Override
    public String toString() {
        return "FinishedMatch{" +
                "id=" + id +
                ", championId=" + championId +
                ", item0Id=" + item0Id +
                ", item1Id=" + item1Id +
                ", item2Id=" + item2Id +
                ", item3Id=" + item3Id +
                ", item4Id=" + item4Id +
                ", item5Id=" + item5Id +
                ", item6Id=" + item6Id +
                '}';
    }
}
