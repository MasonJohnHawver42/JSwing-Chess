

import java.util.*;
public class Bishop extends Piece
{
    public Bishop(Player o) 
    {
        super(o);
        name = "B";
        value = 3;
    }
    //fixed
    protected LinkedList<Move> moves() 
    { 
      LinkedList<Move> moves = new LinkedList<Move>();
        ChessTile move;
        int x=-1;
        try{
            move = tile.getNeighbor(-1,-1);
      
            while(move.empty()){
                moves.add(new NormalMove(this, move));
                x--;
                move = tile.getNeighbor(x,x);
            }
            if(move.getPiece()!=null&&move.getPiece().getColor()!=tile.getPiece().getColor())
                moves.add(new NormalMove(this, move));
        }catch(RuntimeException e){}
        
        x=1;
        try{
            move = tile.getNeighbor(1,1);
      
            while(move.empty()){
                moves.add(new NormalMove(this, move));
                x++;
                move = tile.getNeighbor(x,x);
            }
            if(move.getPiece()!=null&&move.getPiece().getColor()!=tile.getPiece().getColor())
                moves.add(new NormalMove(this, move));
        }catch(RuntimeException e){}
        x=1;
        try{
            move = tile.getNeighbor(1,-1);
      
            while(move.empty()){
                moves.add(new NormalMove(this, move));
                x++;
          
                move = tile.getNeighbor(x,-x);
            }
            if(move.getPiece()!=null&&move.getPiece().getColor()!=tile.getPiece().getColor())
                moves.add(new NormalMove(this, move));
        }catch(RuntimeException e){}
        x=-1; 
        try{
            move = tile.getNeighbor(-1,1);
      
            while(move.empty()){
                moves.add(new NormalMove(this, move));
                x--;
                move = tile.getNeighbor(x,-x);
            }
            if(move.getPiece()!=null&&move.getPiece().getColor()!=tile.getPiece().getColor())
                moves.add(new NormalMove(this, move));
        }catch(RuntimeException e){}
      
        return moves;
    }
}
