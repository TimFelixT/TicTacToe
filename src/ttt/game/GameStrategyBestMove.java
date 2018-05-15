package ttt.game;

import ttt.strategy.IGameStrategy;
import ttt.strategy.MinMaxStrategy;

public class GameStrategyBestMove implements IGameStrategy {

	@Override
	public IMove nextMove(IGame g) {
		MinMaxStrategy mms = new MinMaxStrategy();
		return mms.nextMove(g);
	}

}
