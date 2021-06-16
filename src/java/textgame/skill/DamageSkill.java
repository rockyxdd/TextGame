package java.textgame.skill;

public class DamageSkill implements ISkill {

    private String name;
    private String description;
    private int usagePerFight;
    private int damagePoints;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getUsagePerFight() {
        return usagePerFight;
    }

    public void setUsagePerFight(int usagePerFight) {
        this.usagePerFight = usagePerFight;
    }

    public int getDamagePoints() {
        return damagePoints;
    }

    public void setDamagePoints(int damagePoints) {
        this.damagePoints = damagePoints;
    }

}