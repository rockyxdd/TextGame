package textgame.skill;

public interface ISkill {

	String getName();

	String getDescription();

	int getUsagePerFight();

	int getDamagePoints();

	int getHealPoints();

	boolean isHeal();

	boolean isDamage();
}