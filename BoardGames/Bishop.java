package BoardGames;

import java.util.*;
public class Bishop extends Piece
{
    public Bishop(Boolean color) 
    {
        super(color);
        name = "B";
    }
    
    protected LinkedList<ChessTile> moves(ChessTile tile) 
    { 
      LinkedList<ChessTile> moves = new LinkedList<ChessTile>();
        
      return moves;
    }
}
