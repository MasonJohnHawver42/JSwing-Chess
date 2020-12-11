package BoardGames;

import java.util.*;
public class Bishop extends Piece
{
    public Bishop(Boolean color) 
    {
        super(color);
        name = "B";
    }
    //fixed, work now but need to implement some way to check the color of the piece it is trying to take to see if its valid move
    protected LinkedList<ChessTile> moves(ChessTile tile) 
    { 
      LinkedList<ChessTile> moves = new LinkedList<ChessTile>();
        ChessTile move;
        int x=-1;
        try{
            move = tile.getNeighbor(-1,-1);
      
            while(move.empty()){
                moves.add(move);
                x--;
                move = tile.getNeighbor(x,x);
            }
            if(move.getPiece()!=null/*&& move.getColor()!= this pieces color */)
                moves.add(move);
        }catch(RuntimeException e){}
        
        x=1;
        try{
            move = tile.getNeighbor(1,1);
      
            while(move.empty()){
                moves.add(move);
                x++;
                move = tile.getNeighbor(x,x);
            }
            if(move.getPiece()!=null)
                moves.add(move);
        }catch(RuntimeException e){}
        x=1;
        try{
            move = tile.getNeighbor(1,-1);
      
            while(move.empty()){
                moves.add(move);
                x++;
          
                move = tile.getNeighbor(x,-x);
            }
            if(move.getPiece()!=null)
                moves.add(move);
        }catch(RuntimeException e){}
        x=-1; 
        try{
            move = tile.getNeighbor(-1,1);
      
            while(move.empty()){
                moves.add(move);
                x--;
                move = tile.getNeighbor(x,-x);
            }
            if(move.getPiece()!=null)
                moves.add(move);
        }catch(RuntimeException e){}
      
        return moves;
    }
}
