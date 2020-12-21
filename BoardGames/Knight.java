 

import java.util.*;

public class Knight extends Piece
{
  public Knight(Player o) 
  {
        super(o);
        name = "Kn";
        value = 3;
  }
    
   protected LinkedList<Move> moves() 
   { 
      LinkedList<Move> moves = new LinkedList<Move>();
      int[] offsets =  { 2, -1,
                         2,  1,
                        -2,  1,
                        -2, -1,
                         1,  2,
                        -1,  2,
                         1, -2,
                        -1, -2 };
      
      for (int i = 0; i < offsets.length; i += 2 ) {
        try {
            ChessTile place = tile.getNeighbor(offsets[i], offsets[i + 1]);
            
            if (!place.empty()) {
                Piece other = place.getPiece();
                if (other.getColor() != getColor() ) { moves.add(new NormalMove(this, place)); }
            }
            else {
                moves.add(new NormalMove(this, place));
            }
        } catch(RuntimeException e) {}
      }
        
      return moves;
  } 
}
