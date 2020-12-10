package BoardGames;

import java.util.*;
public class Bishop extends Piece
{
    public Bishop(Boolean color) 
    {
        super(color);
        name = "B";
    }
    //Not finished, will work on tonight to try and fix - Josh
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
                move = tile.getNeighbor(color ? 1:x,x);
            }
        }catch(RuntimeException e){}
        x=1;
        try{
            move = tile.getNeighbor(1,1);
      
            while(move.empty()){
                moves.add(move);
                x++;
                move = tile.getNeighbor(color ? 1:x,x);
            }
        }catch(RuntimeException e){}
        x=1;
        try{
            move = tile.getNeighbor(1,-1);
      
            while(move.empty()){
                moves.add(move);
                x++;
          
                move = tile.getNeighbor(color ? 1:x,-x);
            }
        }catch(RuntimeException e){}
        x=-1; 
        try{
            move = tile.getNeighbor(-1,1);
      
            while(move.empty()){
                moves.add(move);
                x--;
                move = tile.getNeighbor(color ? 1:x,-x);
            }
        }catch(RuntimeException e){}
      
        return moves;
    }
}
