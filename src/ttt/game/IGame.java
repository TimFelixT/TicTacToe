package ttt.game;

import java.util.List;

public interface IGame {
    // Spieler X setzen
    void setPlayerX(IPlayer p);

    // Spieler O setzen
    void setPlayerO(IPlayer p);

    // Wer ist gerade dran?
    IPlayer currentPlayer();

    // Welche Zuege sind noch moeglich (aka freie Felder)
    List<IMove> remainingMoves();

    // Zug ausfuehren (Feld setzen), naechster Spieler ist "dran"
    void doMove(IMove m);

    // Zug zuruecknehmen (Feld setzen), voriger Spieler ist "dran"
    void undoMove(IMove m);

    // Spiel zuende?
    boolean ended();

    // Bewertung des Zustandes aus Sicht des Players p
    // +1: p hat gewonnen
    // -1: p hat verloren
    // 0: Unentschieden
    int evalState(IPlayer p);

    // Zeichne das aktuelle Feld auf der Konsole
    void printField();
}
