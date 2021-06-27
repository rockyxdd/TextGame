package java.textgame.unit;

import java.textgame.item.ItemBoots;
import java.textgame.item.ItemHat;
import java.textgame.item.ItemSword;
import java.textgame.skill.ISkill;

import java.util.ArrayList;
import java.util.List;

public class Player implements IUnit{

    private String name;
    private int health;
    private List<ISkill> skills = new ArrayList<>();
    private ItemHat hat;
    private ItemBoots boots;
    private ItemSword sword;
    private int fullHealth;

    public Player() {
        this.name = "";
        this.health = 100;
        this.skills = null;
        this.hat = null;
        this.boots = null;
        this.sword = null;
        this.fullHealth = 100;
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
        calculateFullHealth();
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
        calculateFullHealth();
    }

    public ItemBoots getBoots() {
        return boots;
    }

    public void setBoots(ItemBoots boots) {
        this.boots = boots;
        calculateFullHealth();
    }

    public ItemSword getSword() {
        return sword;
    }

    public void setSword(ItemSword sword) {
        this.sword = sword;
        calculateFullHealth();
    }

    public void setFullHealth(int fullHealth) {
        this.fullHealth = fullHealth;
    }

    private void calculateFullHealth() {
        this.fullHealth = health + hat.getHealthPoints() + boots.getHealthPoints() + sword.getHealthPoints();
    }

    public int getFullHealth() {
        return fullHealth;
    }
}