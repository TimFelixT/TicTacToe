package ttt.game;

public class Move implements IMove {
	private int row,column = 0;
	
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

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof IMove))return false;
		
		if(this.row == ((IMove)o).getRow()) {
			if(this.column == ((IMove)o).getColumn()) {
				return true;
			}
			else return false;
		}
		return false;
	}
}
