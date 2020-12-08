
/**
 * Write a description of class ChessBoard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ChessBoard extends Board<Chess>
{
    public ChessBoard(Chess game) {
        super(game, 8, 8);
    }
    
    public Tile initTile(int i, int j) { return new ChessTile(this, i, j, null, 1); }
}
