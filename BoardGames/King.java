 

package BoardGames;

 

import java.util.*;
public class King extends Piece
{
    public King(Player o) 
    {
     //I just put 1000 because I need a value there, but obvisouly if you get king you win <- ha!
     super(o);
     name = "K";
     value = -1;
    }
    
    protected LinkedList<Move> moves() 
    {
        //tile.getTile(7, 7) <- botom right corner
    
      LinkedList<Move> moves = new LinkedList<Move>();
      LinkedList<ChessTile> tiles = tile.getNeighbors();
      for (ChessTile pos : tiles) {
          if (!pos.empty()) {
              if (pos.getPiece().getColor() != getColor()) { moves.add(new NormalMove(this, pos)); }
          }
          else { moves.add(new NormalMove(this, pos)); }
      }
      
      ChessTile other1 = (ChessTile)tile.getTile(7,0);
      ChessTile other2 = (ChessTile)tile.getTile(7,7);
      ChessTile other3 = (ChessTile)tile.getTile(0,0);
      ChessTile other4 = (ChessTile)tile.getTile(0,7);
      
      if(getTile().getCol() == 4)
      {
         if(other1.getPiece() instanceof Rook)
         {
           moves.add(new Castle(this,(Rook)other1.getPiece(),other1.getNeighbor(0,1)));
         }
         if(other2.getPiece() instanceof Rook)
         {
           moves.add(new Castle(this,(Rook)other2.getPiece(),other2.getNeighbor(0,-1)));  
         }
         if(other3.getPiece() instanceof Rook)
         {
           moves.add(new Castle(this,(Rook)other3.getPiece(),other3.getNeighbor(0,1)));  
         }
         if(other4.getPiece() instanceof Rook)
         {
           moves.add(new Castle(this,(Rook)other4.getPiece(),other4.getNeighbor(0,-1)));   
         }
      }
      return moves;
      
    }
}

