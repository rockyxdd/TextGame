package java.textgame.game;

import java.textgame.message.Message;
import java.textgame.printer.ConsolePrinter;
import java.textgame.printer.IPrinter;
import java.textgame.scanner.IPlayerInput;
import java.textgame.scanner.ConsolePlayerInput;
import java.textgame.skill.DamageSkill;
import java.textgame.skill.ISkill;
import java.textgame.skill.Skills;
import java.textgame.unit.Monster;
import java.textgame.unit.Player;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private final Player player = new Player();
    private Message msg;
    private IPrinter printer;
    private IPlayerInput in;
    private List<String> existingWays;
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
