package ttt.game;

import ttt.strategy.IGameStrategy;

public class Player implements IPlayer{
	
	private IGameStrategy gameStrategy;
	
	@Override
	public void setStrategy(IGameStrategy s) {
		this.gameStrategy = s;
	}

	@Override
	public IMove nextMove(IGame g) {
		return gameStrategy.nextMove(g);
	}

	@Override
	public char getSymbol() {
		return 0;
	}
	

}
