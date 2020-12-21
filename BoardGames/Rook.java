 

import java.util.*;

public class Rook extends Piece
{
    public Rook(Player o) 
    {
        super(o);
        name = "R";
        value = 5;
    }
    
    protected LinkedList<Move> moves() 
    { 
      LinkedList<Move> moves = new LinkedList<Move>();
      try 
      {
        ChessTile up = tile.getNeighbor (-1,0);
        while(up.empty())  
        {
          moves.add(new NormalMove(this, up)); 
          up = up.getNeighbor(-1, 0);
        }
        if(up.getPiece().getColor() != tile.getPiece().getColor() ) { moves.add(new NormalMove(this, up)); }
      } catch(RuntimeException e) {}
      
      try 
      {
        ChessTile down = tile.getNeighbor (1,0);
        while(down.empty())  
        {
          moves.add(new NormalMove(this, down)); 
          down = down.getNeighbor(1, 0);
        }
        if(down.getPiece().getColor() != tile.getPiece().getColor() ) { moves.add(new NormalMove(this, down)); }
      } catch(RuntimeException e) {}
      
      try 
      {
        ChessTile left = tile.getNeighbor (0,-1);
        while(left.empty())  
        {
          moves.add(new NormalMove(this, left)); 
          left = left.getNeighbor(0, -1);
        }
        if(left.getPiece().getColor() != tile.getPiece().getColor() ) { moves.add(new NormalMove(this, left)); }
      } catch(RuntimeException e) {}
      
      try 
      {
        ChessTile right = tile.getNeighbor (0,1);
        while(right.empty())  
        {
          moves.add(new NormalMove(this, right)); 
          right = right.getNeighbor(0, 1);
        }
        if(right.getPiece().getColor() != tile.getPiece().getColor() ) { moves.add(new NormalMove(this, right)); }
      } catch(RuntimeException e) {}

      return moves;
    }
}
