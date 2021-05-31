package textgame.unit;

import textgame.skill.ISkill;

import java.util.List;

public class Monster implements IUnit{

    private String name;
    private int health;
    private List<ISkill> skills;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public List<ISkill> getSkills() {
        return skills;
    }

    public void setSkills(List<ISkill> skills) {
        this.skills = skills;
    }
}