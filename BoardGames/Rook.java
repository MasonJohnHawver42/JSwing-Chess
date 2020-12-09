package BoardGames;

import java.util.*;

public class Rook extends Piece
{
    public Rook(Boolean color) 
    {
        super(color);
        name = "R";
    }
    
    protected LinkedList<ChessTile> moves(ChessTile tile) 
    { 
      LinkedList<ChessTile> moves = new LinkedList<ChessTile>();
        
      return moves;
    }
}
