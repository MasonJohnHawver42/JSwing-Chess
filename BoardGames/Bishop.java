

import java.util.*;
public class Bishop extends Piece
{
    public Bishop(Boolean color) 
    {
        super(color, 3);
        name = "B";
    }
    //fixed
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
            if(move.getPiece()!=null&&move.getPiece().getColor()!=tile.getPiece().getColor())
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
            if(move.getPiece()!=null&&move.getPiece().getColor()!=tile.getPiece().getColor())
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
            if(move.getPiece()!=null&&move.getPiece().getColor()!=tile.getPiece().getColor())
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
            if(move.getPiece()!=null&&move.getPiece().getColor()!=tile.getPiece().getColor())
                moves.add(move);
        }catch(RuntimeException e){}
      
        return moves;
    }
}
