package java.textgame.game;

import java.textgame.message.Message;
import java.textgame.printer.ConsolePrinter;
import java.textgame.printer.IPrinter;
import java.textgame.scanner.IPlayerInput;
import java.textgame.scanner.consolePlayerInput;
import java.textgame.unit.Player;
import java.util.List;

public class Game {

    private Player player = new Player();
    private Message msg;
    private IPrinter printer;
    private IPlayerInput in;
    private List<String> existingWays;

    public void execute(String gameType) {
        if (gameType.equals("CONSOLE")) {
            initConsole();
            printer.print(msg.rules(player.getName()));
        }
    }

    private void initConsole() {
        this.printer = new ConsolePrinter();
        this.in = new consolePlayerInput();
        createPLayer();
        generateWays();
    }

    private void createPLayer() {
        printer.print(msg.greetings());
        player.setName(in.playerInput());
    }

    private String playerChoice() {
        msg.ways(existingWays);
        String choice = in.playerInput();
        while (isNotChoice(choice)) {
            msg.inputErrorMsg();
            choice = in.playerInput();
        }
        return choice;
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
