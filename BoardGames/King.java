 

import java.util.*;
public class King extends Piece
{
    public King(Player o) 
    {
     //I just put 1000 because I need a value there, but obvisouly if you get king you win <- ha!
     super(o);
     name = "K";
     value = -1;
    }
    
    protected LinkedList<Move> moves() 
    {
        //tile.getTile(7, 7) <- botom right corner
    
      LinkedList<Move> moves = new LinkedList<Move>();
      LinkedList<ChessTile> tiles = tile.getNeighbors();
      for (ChessTile pos : tiles) {
          if (!pos.empty()) {
              if (pos.getPiece().getColor() != getColor()) { moves.add(new NormalMove(this, pos)); }
          }
          else { moves.add(new NormalMove(this, pos)); }
      }
      
      return moves;
    }
}

