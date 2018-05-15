package ttt.game;

public class Move implements IMove {
	private int row,column = 0;
	private char status = ' ';
	
	public Move(int r, int c) {
		this.row = r;
		this.column = c;
	}
	@Override
	public int getRow() {
		return row;
	}

	@Override
	public int getColumn() {
		return column;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}

}
