package textgame.unit;


import textgame.item.ItemBoots;
import textgame.item.ItemHat;
import textgame.item.ItemSword;
import textgame.skill.ISkill;

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
    private int fullHealthCache;

    public Player() {
        this.name = "";
        this.health = 100;
        this.skills = null;
        this.hat = null;
        this.boots = null;
        this.sword = null;
        calculateFullHealth();
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

    public int getFullHealth() {
        return fullHealth;
    }

    public int getFullHealthCache() {
        return fullHealthCache;
    }

    private void calculateFullHealth() {
        int fullHeathCount = health;
        if (hat != null) {
            fullHeathCount += hat.getHealthPoints();
        }
        if (boots != null) {
            fullHeathCount += boots.getHealthPoints();
        }
        if (sword != null) {
            fullHeathCount += sword.getHealthPoints();
        }
        this.fullHealth = fullHeathCount;
        this.fullHealthCache = fullHealth;
    }
}