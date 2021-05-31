package textgame.unit;

import textgame.skill.ISkill;

import java.util.List;

public interface IUnit {

    String getName();

    int getHealth();

    List<ISkill> getSkills();
}