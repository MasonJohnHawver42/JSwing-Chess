import java.util.*;

public class Pawn extends Piece
{
    public Pawn(Player o) {
        super(o);
        name = "p";
        value = 1;
    }
    
    public String getName() { return ""; }
    
    //fixed fully working
    protected LinkedList<Move> moves() { 
        LinkedList<Move> moves = new LinkedList<Move>();
        ChessTile move;
        
        if(tile.getPiece().getColor()==false)
        {
            try {
                move = tile.getNeighbor(-1,0);
                if(move.empty()) {
                    moves.add( new NormalMove(this, move) );
                        if(tile.getRow()==6) {
                        move = tile.getNeighbor(-2,0);
                        if(move.empty()) { moves.add(new NormalMove(this, move)); } 
                } }
                
            } catch(RuntimeException e) {}
            try { move = tile.getNeighbor(-1,1);
                if(move.getPiece().getColor()!=tile.getPiece().getColor())
                    moves.add(new NormalMove(this, move)); } catch(Exception e) {}
            try{
                move = tile.getNeighbor(-1,-1);
                if(move.getPiece().getColor()!=tile.getPiece().getColor()) {
                    moves.add(new NormalMove(this, move));
                    
            }
            } catch(RuntimeException e) {}
            /*if(tile.getRow()==1) {
                    move = tile.getNeighbor(2,0);
                    if(move.empty()) { moves.add(new NormalMove(this, move)); }
                    
            }*/
            if (tile.getRow()==1) {
                move = tile.getNeighbor(-1,0);
                if(move.empty()) { moves.add(new Promotion(this, move)); }
            }
        }else{
            try {
                move = tile.getNeighbor(1,0);
                if(move.empty()) {
                    moves.add( new NormalMove(this, move) );
                        if(tile.getRow()==1) {
                        move = tile.getNeighbor(2,0);
                        if(move.empty()) { moves.add(new NormalMove(this, move)); } 
                } }
                
            } catch(RuntimeException e) {}
            try { move = tile.getNeighbor(1,1);
                if(move.getPiece().getColor()!=tile.getPiece().getColor())
                    moves.add(new NormalMove(this, move)); } catch(Exception e) {}
            try{
                move = tile.getNeighbor(1,-1);
                if(move.getPiece().getColor()!=tile.getPiece().getColor()) {
                    moves.add(new NormalMove(this, move));
                    
            }
            } catch(RuntimeException e) {}
            /*if(tile.getRow()==1) {
                    move = tile.getNeighbor(2,0);
                    if(move.empty()) { moves.add(new NormalMove(this, move)); }
                    
            }*/
            if (tile.getRow()==6) {
                move = tile.getNeighbor(1,0);
                if(move.empty()) { moves.add(new Promotion(this, move)); }
            }
        }
        return moves;
    }
}
