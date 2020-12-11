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
      try 
      {
            ChessTile moveu = tile.getNeighbor(-1,0);
            if (!moveu.empty()) 
            {  
              moves.add(moveu);
              moveu = moveu.getNeighbor(-1, 0); 
            }
      } catch(RuntimeException e) {}
      
      try 
      {
            ChessTile moved = tile.getNeighbor(1,0);
            if (!moved.empty()) 
            {  
              moves.add(moved);
              moved = moved.getNeighbor(1, 0); 
            }
      } catch(RuntimeException e) {}
      
      try 
      {
            ChessTile mover = tile.getNeighbor(0,1);
            if (!mover.empty()) 
            {  
              moves.add(mover);
              mover = mover.getNeighbor(0, 1); 
            }
      } catch(RuntimeException e) {}
      
      try 
      {
            ChessTile movel = tile.getNeighbor(0,-1);
            if (!movel.empty()) 
            {  
              moves.add(movel);
              movel = movel.getNeighbor(0, -1); 
            }
      } catch(RuntimeException e) {}
      
      try 
      {
            ChessTile moveul = tile.getNeighbor(-1,-1);
            if (!moveul.empty()) 
            {  
              moves.add(moveul);
              moveul = moveul.getNeighbor(-1, -1); 
            }
      } catch(RuntimeException e) {}
      
      try 
      {
            ChessTile moveur = tile.getNeighbor(-1,1);
            if (!moveur.empty()) 
            {  
              moves.add(moveur);
              moveur = moveur.getNeighbor(-1, 0); 
            }
      } catch(RuntimeException e) {}
      
      try 
      {
            ChessTile movedl = tile.getNeighbor(1,-1);
            if (!movedl.empty()) 
            {  
              moves.add(movedl);
              movedl = movedl.getNeighbor(1, -1); 
            }
      } catch(RuntimeException e) {}
      
      try 
      {
            ChessTile movedr = tile.getNeighbor(1,1);
            if (!movedr.empty()) 
            {  
              moves.add(movedr);
              movedr = movedr.getNeighbor(1, 1); 
            }
      } catch(RuntimeException e) {}
      return moves;
    }
}
