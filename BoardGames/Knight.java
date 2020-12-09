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
        
      return moves;
  } 
}
