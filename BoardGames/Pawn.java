import java.util.*;

public class Pawn extends Piece
{
    public Pawn(Boolean color) {
        super(color);
        name = "P";
    }
    
    protected LinkedList<ChessTile> moves(ChessTile tile) { 
        LinkedList<ChessTile> moves = new LinkedList<ChessTile>();
        
        try {

            ChessTile move = tile.getNeighbor(color ? 1: -1,0);

            if (!move.empty()) {
                Piece other = move.getPiece();
                boolean other_color = other.getColor();
                if (other_color != color /* our color */) { /* do stuff */ }
            }
            else {
                moves.add(move);
            }

            
        } catch(RuntimeException e) {}
        return moves;
        
        //use tile.getNieghbor(row offset, colum offset) to get the a tile thats distance is the same as that offset 
        //(but becarfull if that tile doent exist it will throw a runtime error)
        //use tile.getNeighbors() this returns all the surounding tiles (no exceptions are throw)
        
        //To get info about the tile use move.empty() to determine if it has a piece or not
        //use move.getPiece() if it has a piece to get the piece
        
        //to get info about the piece use:
        //piece.getColor() -> returns if its light(false) or dark(true)
        
        
        /*
        could also just do:
        
        return tile.getNeighbor(0,1); // actually no becuase remember it has to be a linked list of tiles even if its only one
        
        */
    }
}
