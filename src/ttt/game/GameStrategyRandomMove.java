package ttt.game;

import java.util.Random;

import ttt.strategy.IGameStrategy;

public class GameStrategyRandomMove implements IGameStrategy {

	@Override
	public IMove nextMove(IGame g) {
		int count = g.remainingMoves().size();
		Random r = new Random();
		count = r.nextInt(count);
		return(g.remainingMoves().get(count));

	}

}
