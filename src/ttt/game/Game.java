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
	
	private char[][] board = new char [3][3];
	private int lastChanged;
	
	List<IMove> remainingMoves  =  new ArrayList<IMove>();
	
	
	
	private boolean whoseturn = false;
	Player playerOne;
	Player playerTwo;
	private boolean gameended = false;
	
	@Override
	public void setPlayerX(IPlayer p) {
		playerOne.equals(p);
	}

	@Override
	public void setPlayerO(IPlayer p) {
		playerTwo.equals(p);
	}

	@Override
	public IPlayer currentPlayer() {
		if(whoseturn == false) {
			return playerOne;
		} else {
			return playerTwo;
		}
	}

	@Override
	public List<IMove> remainingMoves() {
		return remainingMoves;
	}

	@Override
	public void doMove(IMove m) {
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
		
	}

}
