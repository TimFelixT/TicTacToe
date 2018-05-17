package ttt.game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int input = 0;
		Scanner sc = new Scanner(System.in);
		Game game = new Game();
		Player playerOne = new Player('x');
		Player playerTwo = new Player('o');
		game.setPlayerX(playerOne);
		game.setPlayerO(playerTwo);
		IMove lastMove = new Move(0, 0);
		while (game.ended() != true) {			
			game.printField();
			System.out.println(
					"Wähle deinen Zug: 1:BestMove 2:OwnMove 3:RandomMove 4:UndoMove Bei Falscheingabe wird Random gewählt.");
			try {
				input = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Falsche Eingabe");
				sc.next();
			} finally {
				if (input == 1) {
					game.currentPlayer().setStrategy(new GameStrategyBestMove());
					lastMove = game.currentPlayer().nextMove(game);
					game.doMove(lastMove);
				} else if (input == 2) {
					System.out.println("Das sind die verbleibenden Züge:");
					for (int i = 0; i < game.remainingMoves().size(); i++) {
						System.out.print(game.remainingMoves().get(i).getColumn() + 1
								+ game.remainingMoves().get(i).getRow() * 3 + ", ");
					}
					System.out.print("\n " + 1 + " |  " + 2 + "  | " + 3 + "\n-------------\n " + 4 + " |  " + 5
							+ "  | " + 6 + "\n-------------\n " + 7 + " |  " + 8 + "  | " + 9 + "\n\n");
					game.currentPlayer().setStrategy(new GameStrategyOwnMove(sc.nextInt()));
					lastMove = game.currentPlayer().nextMove(game);
					game.doMove(lastMove);
				} else if (input == 4) {
					game.undoMove(lastMove);
				} else {
					game.currentPlayer().setStrategy(new GameStrategyRandomMove());
					lastMove = game.currentPlayer().nextMove(game);
					game.doMove(lastMove);
				}
			}

		}
		game.printField();
		if (game.evalState(game.currentPlayer()) == 0) {
			System.out.println("Unentschieden");
		} else if (game.evalState(game.currentPlayer()) == -1) {
			System.out.println("Spieler " + game.currentPlayer().getSymbol() + " verliert.");
		} else if (game.evalState(game.currentPlayer()) == 1) {
			System.out.println("Spieler " + game.currentPlayer().getSymbol() + " verliert.");
		}
		sc.close();

	}

}
