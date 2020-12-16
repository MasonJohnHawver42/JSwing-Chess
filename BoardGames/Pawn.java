import java.util.*;

public class Pawn extends Piece
{
    public Pawn(Boolean color) {
        super(color, 1);
        name = "P";
    }
    
    //fixed fully working
    protected LinkedList<ChessTile> moves() { 
        LinkedList<ChessTile> moves = new LinkedList<ChessTile>();
        ChessTile move;
        if(tile.getPiece().getColor()==false)
        {
            try {
                move = tile.getNeighbor(-1,0);
                if(move.empty())
                    moves.add(move);
                    move = tile.getNeighbor(-1,1);
                if(move.getPiece().getColor()!=tile.getPiece().getColor())
                    moves.add(move);
            } catch(RuntimeException e) {}
            try{
                move = tile.getNeighbor(-1,-1);
                if(move.getPiece().getColor()!=tile.getPiece().getColor())
                    moves.add(move);
            } catch(RuntimeException e) {}
            if(tile.getRow()==6) {
                    move = tile.getNeighbor(-2,0);
                    if(move.empty()) { moves.add(move); }
                    
            }
        }else{
            try {
                move = tile.getNeighbor(1,0);
                if(move.empty())
                    moves.add(move);
                    move = tile.getNeighbor(1,1);
                if(move.getPiece().getColor()!=tile.getPiece().getColor())
                    moves.add(move);
            } catch(RuntimeException e) {}
            try{
                move = tile.getNeighbor(1,-1);
                if(move.getPiece().getColor()!=tile.getPiece().getColor())
                    moves.add(move);
            } catch(RuntimeException e) {}
            if(tile.getRow()==1) {
                    move = tile.getNeighbor(2,0);
                    if(move.empty()) { moves.add(move); }
                
                }
        }
        return moves;
    }
}
