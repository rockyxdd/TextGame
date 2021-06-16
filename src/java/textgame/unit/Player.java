package java.textgame.unit;

import java.textgame.item.ItemBoots;
import java.textgame.item.ItemHat;
import java.textgame.item.ItemSword;
import java.textgame.skill.ISkill;

import java.util.List;

public class Player implements IUnit{

    private String name;
    private int health;
    private List<ISkill> skills;
    private ItemHat hat;
    private ItemBoots boots;
    private ItemSword sword;

    public Player() {
        this.name = "";
        this.health = 100;
        this.skills = null;
        this.hat = null;
        this.boots = null;
        this.sword = null;
    }

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

    public ItemHat getHat() {
        return hat;
    }

    public void setHat(ItemHat hat) {
        this.hat = hat;
    }

    public ItemBoots getBoots() {
        return boots;
    }

    public void setBoots(ItemBoots boots) {
        this.boots = boots;
    }

    public ItemSword getSword() {
        return sword;
    }

    public void setSword(ItemSword sword) {
        this.sword = sword;
    }
}