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
      try 
      {
        ChessTile moveu = tile.getNeighbor (-1,0);
        while(moveu.empty())  
        {
          moves.add(moveu); 
          moveu = moveu.getNeighbor(-1, 0);
        }
      }catch(RuntimeException e) {}

      try 
      {
        ChessTile moved = tile.getNeighbor(1,0);
        while(moved.empty())  
        {
          moves.add(moved); 
          moved = moved.getNeighbor(1, 0);
        }
      }catch(RuntimeException e) {}
      
      try 
      {
        ChessTile movel = tile.getNeighbor(0,-1);

        while(movel.empty())  
        {
          moves.add(movel); 
          movel = movel.getNeighbor(0, -1);
        }
      }catch(RuntimeException e) {}
      
      try 
      {
        ChessTile mover = tile.getNeighbor(0,1);
        while(mover.empty())  
        {
          moves.add(mover); 
          mover = mover.getNeighbor(0, 1);
        }
      }catch(RuntimeException e) {}
      return moves;
    }
}
