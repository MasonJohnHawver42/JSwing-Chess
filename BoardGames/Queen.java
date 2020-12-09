
import java.util.*;

//mason

public class Queen extends Piece
{
        public Queen(Boolean color) {
        super(color);
        name = "P";
    }
    
    protected LinkedList<ChessTile> moves(ChessTile tile) { 
        LinkedList<ChessTile> moves = new LinkedList<ChessTile>();
        
        Bishop bish = new Bishop(this.color);
        Rook rook = new Rook(this.color);
        
        moves.addAll(bish.moves(tile));
        moves.addAll(rook.moves(tile));
        
        return moves;
    }
}
