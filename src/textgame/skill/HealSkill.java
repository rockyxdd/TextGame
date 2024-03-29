package textgame.skill;

public class HealSkill implements ISkill {

	private String name;
	private String description;
	private int usagePerFight;
	private int healPoints;

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


	@Override
	public boolean isHeal() {
		return true;
	}

	@Override
	public boolean isDamage() {
		return false;
	}

	@Override
	public int getDamagePoints() {
		return 0;
	}

	public void setUsagePerFight(int usagePerFight) {
		this.usagePerFight = usagePerFight;
	}

	public int getHealPoints() {
		return healPoints;
	}

	public void setHealPoints(int healPoints) {
		this.healPoints = healPoints;
	}
}