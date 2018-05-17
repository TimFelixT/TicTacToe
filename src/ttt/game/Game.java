package ttt.game;

import java.util.ArrayList;
import java.util.List;

public class Game implements IGame {
	
	private char[][] board = new char [3][3];
	private int draw = 0;
		
	IPlayer currentPlayer;
	IPlayer playerOne;
	IPlayer playerTwo;
	
	public Game() {
		for(int row = 0; row < 3; row++) {
			for(int column = 0; column < 3; column++) {
				board[row][column] = ' ';
			}
		}
	}
	
	@Override
	public void setPlayerX(IPlayer p) {
		playerOne = p;
	}

	@Override
	public void setPlayerO(IPlayer p) {
		playerTwo = p;
	}

	@Override
	public IPlayer currentPlayer() {
		if(this.currentPlayer == null) this.currentPlayer = this.playerOne;
		return this.currentPlayer;
	}

	@Override
	public List<IMove> remainingMoves() {
		List<IMove> remainingMoves = new ArrayList<IMove>();
		for(int row = 0; row < 3; row++) {
			for(int column = 0; column < 3; column++) {
				if(this.board[row][column] == ' ') {
					remainingMoves.add(new Move(row, column));
				}
			}
		}
		return remainingMoves;
	}

	@Override
	public void doMove(IMove m) {
		if(!(remainingMoves().contains(m))) {
			return;
		}
		this.board[m.getRow()][m.getColumn()] = this.currentPlayer.getSymbol();
		
		if(this.currentPlayer == playerOne)this.currentPlayer=playerTwo;
		else this.currentPlayer=this.playerOne;
	}

	@Override
	public void undoMove(IMove m) {
		this.board[m.getRow()][m.getColumn()] = ' ';
		if(this.currentPlayer == playerOne)this.currentPlayer=playerTwo;
		else this.currentPlayer=this.playerOne;
	}

	@Override
	public boolean ended() {
		if (((board[0][0] == board[0][1] && board[0][1] != ' ') && board[0][0] == board[0][2] ||
				(board[1][0] == board[1][1] && board[1][1] != ' ') && board[1][0] == board[1][2] ||
                (board[2][0] == board[2][1] && board[2][1] != ' ') && board[2][0] == board[2][2] ||
                (board[0][0] == board[1][0] && board[1][0] != ' ') && board[0][0] == board[2][0] ||
                (board[0][1] == board[1][1] && board[1][1] != ' ') && board[0][0] == board[2][1] ||
                (board[0][2] == board[1][2] && board[1][2] != ' ') && board[0][2] == board[2][2] ||
                (board[0][0] == board[1][1] && board[1][1] != ' ') && board[0][0] == board[2][2] ||
                (board[2][0] == board[1][1] && board[1][1] != ' ') && board[2][0] == board[0][2] )){			
            return true;
		}else if(remainingMoves().size() == 0) {
			draw = 1;
			return true;			
        }
        return false;
	}

	@Override
	public int evalState(IPlayer p) {
		int win = 0;
		if(this.remainingMoves().size() == 0 && draw == 1) {
			win = 0;
		} else if(this.remainingMoves().size()%2 == 0 && this.ended() == true) {
			win = 1;
		} else if(this.remainingMoves().size()%2 != 0 && this.ended() == true) {
			win = -1;
		}
		if(p.getSymbol() == 'o') {
			win *= -1;
		}			
		return win;
	}

	@Override
	public void printField() {
		System.out.print("\n " + board[0][0] + " |  " + board[0][1] + "  | " + board[0][2] + "\n-------------\n " + board[1][0] + " |  " + board[1][1] + "  | " + board[1][2] + "\n-------------\n " + board[2][0] + " |  " + board[2][1] + "  | " + board[2][2] + "\n\n");
	}
}
