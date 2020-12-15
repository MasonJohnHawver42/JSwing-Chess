package BoardGames;

import java.util.*;
public class King extends Piece
{
    public King(Boolean color) 
    {
     //I just put 1000 because I need a value there, but obvisouly if you get king you win <- ha!
     super(color, 1000);
     name = "K";
    }
    
    protected LinkedList<ChessTile> moves() 
    {
        //tile.getTile(7, 7) <- botom right corner
    
      LinkedList<ChessTile> moves = new LinkedList<ChessTile>();  
      try 
      {
            ChessTile moveu = tile.getNeighbor(-1,0);
            if (moveu.empty()) 
            {  
              moves.add(moveu);
              moveu = moveu.getNeighbor(-1, 0); 
            }
            if(moveu.getPiece()!=null&&moveu.getPiece().getColor()!=tile.getPiece().getColor())
                moves.add(moveu);
      } catch(RuntimeException e) {}
      
      try 
      {
            ChessTile moved = tile.getNeighbor(1,0);
            if (moved.empty()) 
            {  
              moves.add(moved);
              moved = moved.getNeighbor(1, 0); 
            }
            if(moved.getPiece()!=null&&moved.getPiece().getColor()!=tile.getPiece().getColor())
                moves.add(moved);
      } catch(RuntimeException e) {}
      
      try 
      {
            ChessTile mover = tile.getNeighbor(0,1);
            if (mover.empty()) 
            {  
              moves.add(mover);
              mover = mover.getNeighbor(0, 1); 
            }
            if(mover.getPiece()!=null&&mover.getPiece().getColor()!=tile.getPiece().getColor())
                moves.add(mover);
      } catch(RuntimeException e) {}
      
      try 
      {
            ChessTile movel = tile.getNeighbor(0,-1);
            if (movel.empty()) 
            {  
              moves.add(movel);
              movel = movel.getNeighbor(0, -1); 
            }
            if(movel.getPiece()!=null&&movel.getPiece().getColor()!=tile.getPiece().getColor())
                moves.add(movel);
      } catch(RuntimeException e) {}
      
      try 
      {
            ChessTile moveul = tile.getNeighbor(-1,-1);
            if (moveul.empty()) 
            {  
              moves.add(moveul);
              moveul = moveul.getNeighbor(-1, -1); 
            }
            if(moveul.getPiece()!=null&&moveul.getPiece().getColor()!=tile.getPiece().getColor())
                moves.add(moveul);
      } catch(RuntimeException e) {}
      
      try 
      {
            ChessTile moveur = tile.getNeighbor(-1,1);
            if (moveur.empty()) 
            {  
              moves.add(moveur);
              moveur = moveur.getNeighbor(-1, 0); 
            }
            if(moveur.getPiece()!=null&&moveur.getPiece().getColor()!=tile.getPiece().getColor())
                moves.add(moveur);
      } catch(RuntimeException e) {}
      
      try 
      {
            ChessTile movedl = tile.getNeighbor(1,-1);
            if (movedl.empty()) 
            {  
              moves.add(movedl);
              movedl = movedl.getNeighbor(1, -1); 
            }
            if(movedl.getPiece()!=null&&movedl.getPiece().getColor()!=tile.getPiece().getColor())
                moves.add(movedl);
      } catch(RuntimeException e) {}
      
      try 
      {
            ChessTile movedr = tile.getNeighbor(1,1);
            if (movedr.empty()) 
            {  
              moves.add(movedr);
              movedr = movedr.getNeighbor(1, 1); 
            }
            if(movedr.getPiece()!=null&&movedr.getPiece().getColor()!=tile.getPiece().getColor())
                moves.add(movedr);
      } catch(RuntimeException e) {}
      return moves;
    }
}

