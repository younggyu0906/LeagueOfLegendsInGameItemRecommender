package koreatech.cse.domain.staticData;

//DB에 저장하고 불러올 챔피언 정보.
public class ChampionDAO {
    private int id;
    private String name;
    private int attack;      //info -> attack
    private int defense;     //info -> defence
    private int magic;       //info -> magic
    private int difficulty;  //info -> difficulty
    private boolean tank;    //tags ->
    private boolean support;     //tags ->
    private boolean mage;        //tags ->
    private boolean marksman;    //tags ->
    private boolean fighter;     //tags ->
    private boolean assassin;    //tags ->

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public boolean isTank() {
        return tank;
    }

    public void setTank(boolean tank) {
        this.tank = tank;
    }

    public boolean isSupport() {
        return support;
    }

    public void setSupport(boolean support) {
        this.support = support;
    }

    public boolean isMage() {
        return mage;
    }

    public void setMage(boolean mage) {
        this.mage = mage;
    }

    public boolean isMarksman() {
        return marksman;
    }

    public void setMarksman(boolean marksman) {
        this.marksman = marksman;
    }

    public boolean isFighter() {
        return fighter;
    }

    public void setFighter(boolean fighter) {
        this.fighter = fighter;
    }

    public boolean isAssassin() {
        return assassin;
    }

    public void setAssassin(boolean assassin) {
        this.assassin = assassin;
    }

    @Override
    public String toString() {
        return "ChampionDAO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", attack=" + attack +
                ", defense=" + defense +
                ", magic=" + magic +
                ", difficulty=" + difficulty +
                ", tank=" + tank +
                ", support=" + support +
                ", mage=" + mage +
                ", marksman=" + marksman +
                ", fighter=" + fighter +
                ", assassin=" + assassin +
                '}';
    }
}
