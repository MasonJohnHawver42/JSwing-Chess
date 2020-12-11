package BoardGames;

import java.util.*;

public class Knight extends Piece
{
  public Knight(Boolean color) 
  {
        super(color);
        name = "Kn";
  }
    
   protected LinkedList<ChessTile> moves(ChessTile tile) 
   { 
      LinkedList<ChessTile> moves = new LinkedList<ChessTile>();
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
            ChessTile move = tile.getNeighbor(offsets[i], offsets[i + 1]);
            
            if (!move.empty()) {
                Piece other = move.getPiece();
                boolean other_color = other.getColor();
                if (other_color != color ) { moves.add(move); }
            }
            else {
                moves.add(move);
            }
        } catch(RuntimeException e) {}
      }
        
      return moves;
  } 
}
