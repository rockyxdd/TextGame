package textgame.scanner;

import java.util.Scanner;

public class ConsolePlayerInput implements IPlayerInput {

	private final Scanner in = new Scanner(System.in);

	@Override
	public String playerInput() {
		return in.nextLine();
	}
}
