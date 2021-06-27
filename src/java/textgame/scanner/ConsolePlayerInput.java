package java.textgame.scanner;

import java.util.Scanner;

public class ConsolePlayerInput implements IPlayerInput{

    private Scanner in = new Scanner(System.in);

    @Override
    public String playerInput() {
        return in.nextLine();
    }
}
