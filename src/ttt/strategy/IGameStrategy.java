package ttt.strategy;

import ttt.game.IGame;
import ttt.game.IMove;

public interface IGameStrategy {
    // Naechsten Zug berechnen
    IMove nextMove(IGame g);
}
