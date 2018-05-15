package ttt.game;

import java.util.ArrayList;
import java.util.List;

public class Game implements IGame {
	
	private Move one = new Move(1,1);
	private Move two = new Move(1,2);
	private Move three = new Move(1,3);
	private Move four = new Move(2,1);
	private Move five = new Move(2,2);
	private Move six = new Move(2,3);
	private Move seven = new Move(3,1);
	private Move eight = new Move(3,2);
	private Move nine = new Move(3,3);
	
	List<IMove> remainingMoves  =  new ArrayList<IMove>();
	
	private char[][] board = new char [3][3];
	private int lastChanged;
	
	
		
	Player currentPlayer;
	Player playerOne;
	Player playerTwo;
	private boolean gameended = false;
	
	public Game() {
		this.newList();
	}
	
	public void newList() {		
		remainingMoves.add(one);
		remainingMoves.add(two);
		remainingMoves.add(three);
		remainingMoves.add(four);
		remainingMoves.add(five);
		remainingMoves.add(six);
		remainingMoves.add(seven);
		remainingMoves.add(eight);
		remainingMoves.add(nine);
	}
	
	
	
	@Override
	public void setPlayerX(IPlayer p) {
		playerOne=(Player) p;
		playerOne.symbol = 'x';
	}

	@Override
	public void setPlayerO(IPlayer p) {
		playerTwo=(Player) p;
		playerTwo.symbol = 'o';
	}

	@Override
	public IPlayer currentPlayer() {
		if(this.currentPlayer == null) this.currentPlayer = this.playerOne;
	}

	@Override
	public List<IMove> remainingMoves() {
		return remainingMoves;
	}

	@Override
	public void doMove(IMove m) {
		Move helpm = new Move(1,1);
		helpm.equals(m);
		helpm.setStatus(this.currentPlayer().getSymbol());
		m.equals(helpm);
		remainingMoves.remove(m);
		whoseturn ^= true;
	}

	@Override
	public void undoMove(IMove m) {
		whoseturn ^= true;
	}

	@Override
	public boolean ended() {
		return gameended;
	}

	@Override
	public int evalState(IPlayer p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void printField() {
		System.out.print("\n " + one.getStatus() + " |  " + two.getStatus() + "  |  " + three.getStatus() + "\n-------------\n" + four.getStatus() + "  |  " + five.getStatus() + "  |  " + six.getStatus() + "\n-------------\n" + seven.getStatus() + "  |  " + eight.getStatus() + "  |  " + nine.getStatus() + "\n\n");
	}

}
