package textgame.skill;

public class DamageSkill implements ISkill {

	private String name;
	private String description;
	private int usagePerFight;
	private int damagePoints;

	public DamageSkill(Skills skill) {
		this.name = skill.getName();
		this.description = skill.getDescription();
		this.damagePoints = skill.getDamage();
		this.usagePerFight = skill.getUsagePerFight();
	}

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
		return false;
	}

	@Override
	public boolean isDamage() {
		return true;
	}

	@Override
	public int getHealPoints() {
		return 0;
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