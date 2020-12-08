
import java.util.*;


public class Chess extends Game 
{
    static final boolean light = false;
    static final boolean dark = true;
    
    public Chess() {
        super("Chess");
        light_pieces = new LinkedList<Piece>();
        dark_pieces = new LinkedList<Piece>();
        
        board = new ChessBoard(this);
        add(board);
    }
    
    public void addPiece(Piece p) {
        if (p.color == light) { light_pieces.add(p); }
        else { dark_pieces.add(p); }
    }
    
    public void removePiece(Piece p) {
        if (p.color == light) { light_pieces.remove(p); }
        else { dark_pieces.remove(p); }
    }
    
    public LinkedList<Piece> dark_pieces;
    public LinkedList<Piece> light_pieces;
    
    public static void main(String[] args) {
        Game chess = new Chess();
        chess.play();
    }
}
