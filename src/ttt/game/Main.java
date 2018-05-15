package ttt.game;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Game game = new Game();
		Player playerOne = new Player();
		Player playerTwo = new Player();
		game.setPlayerX(playerOne);
		game.setPlayerO(playerTwo);
		while(game.ended() != true) {
			game.printField();
			System.out.println("Wähle deinen Zug: 1:BestMove 2:OwnMove 3:RandomMove Bei Falscheingabe wird Random gewählt.");
			if(sc.nextInt() == 1) {
				game.currentPlayer().setStrategy(new GameStrategyBestMove());				
			} else if(sc.nextInt() == 2) {
				game.currentPlayer().setStrategy(new GameStrategyOwnMove());
			} else {
				game.currentPlayer().setStrategy(new GameStrategyRandomMove());
			}
			game.doMove(game.currentPlayer().nextMove(game));
		}
	}

}
