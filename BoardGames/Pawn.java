import java.util.*;

public class Pawn extends Piece
{
    public Pawn(Boolean color) {
        super(color);
        name = "P";
    }
    
    protected LinkedList<ChessTile> moves(ChessTile tile) { 
        LinkedList<ChessTile> moves = new LinkedList<ChessTile>();
        
        moves.add(tile.getNeighbor(0,1));
        return moves;
        /*
        could also just do:
        
        return tile.getNeighbor(0,1);
        
        */
    }
}
