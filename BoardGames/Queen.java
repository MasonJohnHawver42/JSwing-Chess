
import java.util.*;

//mason

public class Queen extends Piece
{
        public Queen(Boolean color) {
        super(color, 9);
        name = "Q";
    }
    
    protected LinkedList<ChessTile> moves() { 
        LinkedList<ChessTile> moves = new LinkedList<ChessTile>();
        
        Bishop bish = new Bishop(this.color);
        Rook rook = new Rook(this.color);
        
        bish.setTile(tile);
        rook.setTile(tile);
        
        moves.addAll(bish.moves());
        moves.addAll(rook.moves()); //rember
        
        return moves;
    }
}
