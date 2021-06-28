package textgame;

import textgame.game.Game;

public class Runner {

	public static void main(String[] args) {
		Game game = new Game();
		String gameType = "CONSOLE";
		game.execute(gameType);
	}
}
