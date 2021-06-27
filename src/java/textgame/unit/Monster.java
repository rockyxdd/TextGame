package java.textgame.unit;

import java.textgame.skill.DamageSkill;
import java.textgame.skill.ISkill;

import java.textgame.skill.Skills;
import java.util.ArrayList;
import java.util.List;

public class Monster implements IUnit{

    private String name;
    private int health;
    private List<ISkill> skills = new ArrayList<>();

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

    public Monster generateMonster(String choice) {
        if ("Лево".equals(choice)) {
            leftMonster();
        }
        if ("Право".equals(choice)) {
            rightMonster();
        }
        if ("Прямо".equals(choice)) {
            frontMonster();
        }
        return this;
    }

    private void leftMonster() {
        this.name = "Левый";
        this.health = 100;
        this.skills.add(new DamageSkill(Skills.easyBite));
    }

    private void rightMonster() {
        this.name = "Правый";
        this.health = 150;
        this.skills.add(new DamageSkill(Skills.mediumBite));
    }

    private void frontMonster() {
        this.name = "Прямой";
        this.health = 200;
        this.skills.add(new DamageSkill(Skills.hardBite));
    }
}