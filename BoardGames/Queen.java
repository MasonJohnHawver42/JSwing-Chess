
import java.util.*;

//mason

public class Queen extends Piece
{
        public Queen(Player o) {
        super(o);
        name = "Q";
        value = 9;
    }
    
    protected LinkedList<Move> moves() { 
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
              try 
      {
        ChessTile up = tile.getNeighbor (-1,0);
        while(up.empty())  
        {
          moves.add(new NormalMove(this, up)); 
          up = up.getNeighbor(-1, 0);
        }
        if(up.getPiece().getColor() != tile.getPiece().getColor() ) { moves.add(new NormalMove(this, up)); }
      } catch(RuntimeException e) {}
      
      try 
      {
        ChessTile down = tile.getNeighbor (1,0);
        while(down.empty())  
        {
          moves.add(new NormalMove(this, down)); 
          down = down.getNeighbor(1, 0);
        }
        if(down.getPiece().getColor() != tile.getPiece().getColor() ) { moves.add(new NormalMove(this, down)); }
      } catch(RuntimeException e) {}
      
      try 
      {
        ChessTile left = tile.getNeighbor (0,-1);
        while(left.empty())  
        {
          moves.add(new NormalMove(this, left)); 
          left = left.getNeighbor(0, -1);
        }
        if(left.getPiece().getColor() != tile.getPiece().getColor() ) { moves.add(new NormalMove(this, left)); }
      } catch(RuntimeException e) {}
      
      try 
      {
        ChessTile right = tile.getNeighbor (0,1);
        while(right.empty())  
        {
          moves.add(new NormalMove(this, right)); 
          right = right.getNeighbor(0, 1);
        }
        if(right.getPiece().getColor() != tile.getPiece().getColor() ) { moves.add(new NormalMove(this, right)); }
      } catch(RuntimeException e) {}
        
        return moves;
    }
}
