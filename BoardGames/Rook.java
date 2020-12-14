package BoardGames;

import java.util.*;

public class Rook extends Piece
{
    public Rook(Boolean color, 5) 
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
        if(moveu.getPiece()!=null&&moveu.getPiece().getColor()!=tile.getPiece().getColor())
                moves.add(moveu);
      }catch(RuntimeException e) {}

      try 
      {
        ChessTile moved = tile.getNeighbor(1,0);
        while(moved.empty())  
        {
          moves.add(moved); 
          moved = moved.getNeighbor(1, 0);
        }
        if(moved.getPiece()!=null&&moved.getPiece().getColor()!=tile.getPiece().getColor())
                moves.add(moved);
      }catch(RuntimeException e) {}
      
      try 
      {
        ChessTile movel = tile.getNeighbor(0,-1);

        while(movel.empty())  
        {
          moves.add(movel); 
          movel = movel.getNeighbor(0, -1);
        }
        if(movel.getPiece()!=null&&movel.getPiece().getColor()!=tile.getPiece().getColor())
                moves.add(movel);
      }catch(RuntimeException e) {}
      
      try 
      {
        ChessTile mover = tile.getNeighbor(0,1);
        while(mover.empty())  
        {
          moves.add(mover); 
          mover = mover.getNeighbor(0, 1);
        }
        if(mover.getPiece()!=null&&mover.getPiece().getColor()!=tile.getPiece().getColor())
                moves.add(mover);
      }catch(RuntimeException e) {}
      return moves;
    }
}
