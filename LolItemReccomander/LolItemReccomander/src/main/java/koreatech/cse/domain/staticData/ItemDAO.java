package koreatech.cse.domain.staticData;

//DB에 넣고 빼고 할 아이템 정보. 필요하고 얻을 수 있는 정보만 취급.
public class ItemDAO {
    private int id;
    private String name;
    private long health;
    private long mana;
    private long armor;
    private long spellBlock;
    private double attackSpeed;
    private long physicalDamage;
    private double critChance;
    private long magicDamage;
    private boolean finished;

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

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

    public long getHealth() {
        return health;
    }

    public void setHealth(long health) {
        this.health = health;
    }

    public long getMana() {
        return mana;
    }

    public void setMana(long mana) {
        this.mana = mana;
    }

    public long getArmor() {
        return armor;
    }

    public void setArmor(long armor) {
        this.armor = armor;
    }

    public long getSpellBlock() {
        return spellBlock;
    }

    public void setSpellBlock(long spellBlock) {
        this.spellBlock = spellBlock;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public long getPhysicalDamage() {
        return physicalDamage;
    }

    public void setPhysicalDamage(long physicalDamage) {
        this.physicalDamage = physicalDamage;
    }

    public double getCritChance() {
        return critChance;
    }

    public void setCritChance(double critChance) {
        this.critChance = critChance;
    }

    public long getMagicDamage() {
        return magicDamage;
    }

    public void setMagicDamage(long magicDamage) {
        this.magicDamage = magicDamage;
    }

    @Override
    public String toString() {
        return "ItemDAO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", health=" + health +
                ", mana=" + mana +
                ", armor=" + armor +
                ", spellBlock=" + spellBlock +
                ", attackSpeed=" + attackSpeed +
                ", physicalDamage=" + physicalDamage +
                ", critChance=" + critChance +
                ", magicDamage=" + magicDamage +
                ", finished=" + finished +
                '}';
    }
}
