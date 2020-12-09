package BoardGames;

import java.util.*;
public class King extends Piece
{
    public King(Boolean color) 
    {
        super(color);
        name = "K";
    }
    
    protected LinkedList<ChessTile> moves(ChessTile tile) 
    { 
      LinkedList<ChessTile> moves = new LinkedList<ChessTile>();
        
      return moves;
    }
}
