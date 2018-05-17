package ttt.game;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Game game = new Game();
		Player playerOne = new Player('x');
		Player playerTwo = new Player('o');
		game.setPlayerX(playerOne);
		game.setPlayerO(playerTwo);
		while(game.ended() != true) {
			game.printField();
			System.out.println("Wähle deinen Zug: 1:BestMove 2:OwnMove 3:RandomMove Bei Falscheingabe wird Random gewählt.");
			int input = sc.nextInt();
			if(input == 1) {
				game.currentPlayer().setStrategy(new GameStrategyBestMove());				
			} else if(input == 2) {
				System.out.println("Das sind die verbleibenden Züge:");
				for(int i = 0;i < game.remainingMoves().size();i++) {
					System.out.print(game.remainingMoves().get(i).getColumn()+1 + game.remainingMoves().get(i).getRow()*3 + ", ");
				}
				System.out.print("\n " + 1 + " |  " + 2 + "  | " + 3 + "\n-------------\n " + 4 + " |  " + 5 + "  | " + 6 + "\n-------------\n " + 7 + " |  " + 8 + "  | " + 9 + "\n\n");
				game.currentPlayer().setStrategy(new GameStrategyOwnMove(sc.nextInt()));
			} else {
				game.currentPlayer().setStrategy(new GameStrategyRandomMove());
			}
			game.doMove(game.currentPlayer().nextMove(game));
		}
		game.printField();
		int x = game.evalState(game.currentPlayer());
		if(x == 0) {
			System.out.println("Unentschieden");
		} else if(x == -1){
			System.out.println("Spieler " + game.currentPlayer().getSymbol() + " verliert.");				
		}		
		sc.close();
	}

}
