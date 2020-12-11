import java.util.*;

public class Pawn extends Piece
{
    public Pawn(Boolean color) {
        super(color);
        name = "P";
    }
    
    //need to fix problem where pawn on far right (and maybe left) cant detect pieces to capture as moves
    protected LinkedList<ChessTile> moves(ChessTile tile) { 
        LinkedList<ChessTile> moves = new LinkedList<ChessTile>();
        //System.out.println(tile.getRow() + "," + tile.getCol());
        //System.out.println(tile.getPiece().getColor());
        if(tile.getPiece().getColor()==false)
        {
            try {
                ChessTile move = tile.getNeighbor(-1,0);
                if(move.empty())
                    moves.add(move);
                    move = tile.getNeighbor(-1,1);
                if(move.getPiece().getColor()!=tile.getPiece().getColor())
                    moves.add(move);
                move = tile.getNeighbor(-1,-1);
                if(move.getPiece().getColor()!=tile.getPiece().getColor())
                    moves.add(move);
            } catch(RuntimeException e) {}
            if(tile.getRow()==6)
                    moves.add(tile.getNeighbor(-2,0));
        }else{
            try {
                ChessTile move = tile.getNeighbor(1,0);
                if(move.empty())
                    moves.add(move);
                    move = tile.getNeighbor(1,1);
                if(move.getPiece().getColor()!=tile.getPiece().getColor())
                    moves.add(move);
                move = tile.getNeighbor(1,-1);
                if(move.getPiece().getColor()!=tile.getPiece().getColor())
                    moves.add(move);

            } catch(RuntimeException e) {}
            if(tile.getRow()==1)
                    moves.add(tile.getNeighbor(2,0));
        }
        return moves;
    }
}
