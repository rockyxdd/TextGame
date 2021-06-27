package java.textgame.game;

import java.textgame.message.Message;
import java.textgame.printer.ConsolePrinter;
import java.textgame.printer.IPrinter;
import java.textgame.scanner.ConsolePlayerInput;
import java.textgame.skill.ISkill;
import java.textgame.unit.Monster;
import java.textgame.unit.Player;

public class ConsoleCombat implements ICombat{

    private final IPrinter printer =  new ConsolePrinter();;
    private final ConsolePlayerInput in = new ConsolePlayerInput();
    private Player player;
    private Monster monster;
    private int roundCounter;
    private Message msg;

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
            monsterTurn();
        } else {
            monsterTurn();
            playerTurn();
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
