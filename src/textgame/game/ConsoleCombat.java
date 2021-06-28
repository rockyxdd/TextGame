package textgame.game;


import textgame.message.Message;
import textgame.printer.ConsolePrinter;
import textgame.printer.IPrinter;
import textgame.scanner.ConsolePlayerInput;
import textgame.skill.ISkill;
import textgame.unit.Monster;
import textgame.unit.Player;

public class ConsoleCombat implements ICombat {

	private final IPrinter printer = new ConsolePrinter();
	private final ConsolePlayerInput in = new ConsolePlayerInput();
	private final Message msg = new Message();
	private final Player player;
	private final Monster monster;
	private int roundCounter;

	public ConsoleCombat(Player player, Monster monster) {
		this.player = player;
		this.monster = monster;
		this.roundCounter = 3;
	}

	public boolean executeCombat() {
		while (roundCounter != 0) {
			executeRound();
			if (player.getFullHealth() <= 0) {
				printer.print(msg.playerLost());
				return false;
			}
			if (monster.getHealth() <= 0) {
				printer.print(msg.monsterLost(monster.getName()));
				player.setFullHealth(player.getFullHealthCache());
				return true;
			}
			roundCounter--;
		}
		printer.print(msg.playerLost());
		return false;
	}

	private void executeRound() {
		double random = Math.random();
		if (random >= 0.5) {
			playerTurn();
			if (monster.getHealth() > 0) {
				monsterTurn();
			}
		} else {
			monsterTurn();
			if (player.getFullHealth() > 0) {
				playerTurn();
			}
		}
		printer.print(msg.playerHealth(player.getFullHealth()));
		printer.print(msg.monsterHealth(monster.getHealth()));
	}

	private void playerTurn() {
		ISkill playerSkill = playerChoice();
		if (playerSkill.isHeal()) {
			player.setHealth(player.getHealth() + playerSkill.getHealPoints());
			printer.print(msg.playerHeal(playerSkill.getName(), playerSkill.getHealPoints()));
		}
		if (playerSkill.isDamage()) {
			monster.setHealth(monster.getHealth() - playerSkill.getDamagePoints());
			printer.print(msg.playerDamage(playerSkill.getName(), playerSkill.getDamagePoints()));
		}
	}

	private void monsterTurn() {
		ISkill skill = monster.getSkills().get(0);
		player.setFullHealth(player.getFullHealth() - skill.getDamagePoints());
		printer.print(msg.monsterDamage(skill.getName(), skill.getDamagePoints()));
	}

	private ISkill playerChoice() {
		printer.print(msg.playerSkills(player.getSkills()));
		String choice = in.playerInput();
		for (ISkill skill : player.getSkills()) {
			if (skill.getName().equals(choice)) {
				return skill;
			}
		}
		printer.print(msg.inputErrorMsg());
		return playerChoice();
	}
}
