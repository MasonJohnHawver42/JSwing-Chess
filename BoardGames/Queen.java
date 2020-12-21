
import java.util.*;

//mason

public class Queen extends Piece
{
        public Queen(Player o) {
        super(o);
        name = "Q";
        value = 9;
    }
    
    protected LinkedList<Move> moves() { 
        LinkedList<Move> moves = new LinkedList<Move>();
        
        Bishop bish = new Bishop(owner);
        Rook rook = new Rook(owner);
        
        bish.setTile(tile);
        rook.setTile(tile);
        
        for (Move move : bish.moves()) { moves.add(new NormalMove(this, ((NormalMove)move).to)); }
        for (Move move : rook.moves()) { moves.add(new NormalMove(this, ((NormalMove)move).to)); }
        
        setTile(tile);
        
        return moves;
    }
}
