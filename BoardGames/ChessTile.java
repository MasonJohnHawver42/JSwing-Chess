
/**
 * Write a description of class ChessTile here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ChessTile extends Tile<ChessBoard>
{
    public ChessTile(ChessBoard b, int r, int c, Piece p, boolean col) {
        super(b, r, c);
        
        piece = p;
        color = col;
    }
    
    protected State initState() { return new State(this); }
    
    Piece piece;
    boolean color;
}
