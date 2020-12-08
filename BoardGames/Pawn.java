import java.util.*;

public class Pawn extends Piece
{
    public Pawn(Boolean color) {
        super(color);
        name = "P";
    }
    
    protected LinkedList<ChessTile> moves(ChessTile tile) { return null; }
}
