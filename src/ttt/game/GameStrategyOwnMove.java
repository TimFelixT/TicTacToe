package ttt.game;

import ttt.strategy.IGameStrategy;

public class GameStrategyOwnMove implements IGameStrategy {
	
	int row;
	int column;
	
	public GameStrategyOwnMove(int k) {
		k -= 1;
		column = k % 3;
		k -= column;
		row = k/3;
	}
	
	@Override
	public IMove nextMove(IGame g) {
		return(new Move(row,column));
	}

}
