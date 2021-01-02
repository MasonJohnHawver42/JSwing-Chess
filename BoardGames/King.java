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
      
      ChessTile K1 = (ChessTile)tile.getTile(0,4);
      ChessTile K2 = (ChessTile)tile.getTile(7,4);
      ChessTile Q1 = (ChessTile)tile.getTile(0,3);
      ChessTile Q2 = (ChessTile)tile.getTile(7,3);
      ChessTile other1 = (ChessTile)tile.getTile(7,0);
      ChessTile other2 = (ChessTile)tile.getTile(7,7);
      ChessTile other3 = (ChessTile)tile.getTile(0,0);
      ChessTile other4 = (ChessTile)tile.getTile(0,7);
      ChessTile Kn1 = (ChessTile)tile.getTile(7,1);
      ChessTile Kn2 = (ChessTile)tile.getTile(7,6);
      ChessTile Kn3 = (ChessTile)tile.getTile(0,1);
      ChessTile Kn4 = (ChessTile)tile.getTile(0,6);
      ChessTile Bi1 = (ChessTile)tile.getTile(7,2);
      ChessTile Bi2 = (ChessTile)tile.getTile(7,5);
      ChessTile Bi3 = (ChessTile)tile.getTile(0,2);
      ChessTile Bi4 = (ChessTile)tile.getTile(0,5);
      
      if(getTile().getCol() == 4 && getTile().getRow() == 7)
      {
         if(other1.getPiece() instanceof Rook && Kn1.empty() == true && Bi1.empty() == true && Q1.empty() == true)  
         {
           moves.add(new Castle(this,(Rook)other1.getPiece(),other1.getNeighbor(0,1),K2.getNeighbor(0,-2)));
         }  
         if(other2.getPiece() instanceof Rook && Kn2.empty() == true && Bi2.empty() == true)
         {
           moves.add(new Castle(this,(Rook)other2.getPiece(),other2.getNeighbor(0,-1),K2.getNeighbor(0,1)));  
         }
      }
      
      else if(getTile().getCol() == 4 && getTile().getRow() == 0)
      {
         if(other3.getPiece() instanceof Rook && Kn3.empty() == true && Bi3.empty() == true && Q2.empty() == true)
         {
           moves.add(new Castle(this,(Rook)other3.getPiece(),other3.getNeighbor(0,1),K2.getNeighbor(-7,-2)));  
         }
         if(other4.getPiece() instanceof Rook && Kn4.empty() == true && Bi4.empty() == true)
         {
           moves.add(new Castle(this,(Rook)other4.getPiece(),other4.getNeighbor(0,-1),K2.getNeighbor(-7,1)));   
         } 
      } 
      return moves;
      
    }
}

