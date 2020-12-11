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
        //ChessTile moved = tile.getNeighbor(color ? 1: 1,0);
        //ChessTile movel = tile.getNeighbor(color ? 1: 0,-1);
        //ChessTile mover = tile.getNeighbor(color ? 1: 0,1);
        while(moveu.empty())  
        {
          moves.add(moveu);
          //moveu = tile.getNeighbor(-1, 0); - when you do this it sets moveu back to the begining because rember tile is where the piece is
          //Piece other = moveu.getPiece(); - why?
          moveu = moveu.getNeighbor(-1, 0);
          System.out.println(moveu);
        }
        
         
         
        //while(!movel.empty())  
        //{
        //   Piece other = movel.getPiece();
        //  boolean other_color = other.getColor();
        //  if (other_color != color /* our color */) 
        //  {
        
        //  }
        //  else
        //  {
        //    moves.add(movel);   
        //  }
        //}         
        //while(!mover.empty())  
        //{
        //  Piece other = mover.getPiece();
        //  boolean other_color = other.getColor();
        //  if (other_color != color /* our color */) 
        //  {

        //  }
        //  else
        //  {
        //    moves.add(mover);   
        //  }
        //}
        
      }catch(RuntimeException e) {}
      return moves;
    }
}
