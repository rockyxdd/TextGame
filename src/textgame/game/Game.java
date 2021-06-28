package textgame.game;

import textgame.message.Message;
import textgame.printer.ConsolePrinter;
import textgame.printer.IPrinter;
import textgame.scanner.ConsolePlayerInput;
import textgame.scanner.IPlayerInput;
import textgame.skill.DamageSkill;
import textgame.skill.ISkill;
import textgame.skill.Skills;
import textgame.unit.Monster;
import textgame.unit.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private final Player player = new Player();
	private final Message msg = new Message();
	private final List<String> existingWays = new ArrayList<>();
	private IPrinter printer;
	private IPlayerInput in;
	private boolean isCombat;

	public void execute(String gameType) {
		if ("CONSOLE".equals(gameType)) {
			initConsole();
			printer.print(msg.rules(player.getName()));
			while (isCombat) {
				if (existingWays.isEmpty()) {
					printer.print(msg.win());
					isCombat = false;
				}
				{
					ConsoleCombat combat = new ConsoleCombat(player, playerChoice());
					isCombat = combat.executeCombat();
				}
			}
		}
	}

	private void initConsole() {
		this.printer = new ConsolePrinter();
		this.in = new ConsolePlayerInput();
		this.isCombat = true;
		createPLayer();
		generateWays();
	}

	private void createPLayer() {
		printer.print(msg.greetings());
		player.setName(in.playerInput());
		List<ISkill> skills = new ArrayList<>();
		skills.add(new DamageSkill(Skills.kiss));
		skills.add(new DamageSkill(Skills.oneShot));
		player.setSkills(skills);
	}

	private Monster playerChoice() {
		printer.print(msg.ways(existingWays));
		String choice = in.playerInput();
		while (isNotChoice(choice)) {
			printer.print(msg.inputErrorMsg());
			choice = in.playerInput();
		}
		existingWays.remove(choice);
		return new Monster().generateMonster(choice);
	}

	private void generateWays() {
		this.existingWays.add("Лево");
		this.existingWays.add("Прямо");
		this.existingWays.add("Право");
	}

	private boolean isNotChoice(String choice) {
		for (String way : existingWays) {
			if (way.equals(choice)) {
				return false;
			}
		}
		return true;
	}
}
