
import java.util.*;


public class Chess extends Game 
{
    static final boolean light = false; 
    static final boolean dark = true;
    
    public Chess() {
        super("Chess");
        light_pieces = new LinkedList<Piece>();
        dark_pieces = new LinkedList<Piece>();
        
        turn = light;
    }
    
    public void init() {
        board = new ChessBoard(this);
        add(board);
    }
    
    public void select(Tile t) { selected = t; }
    public Tile getSelected() { return selected; }
    
    public void addPiece(Piece p) {
        if (p.color == light) { light_pieces.add(p); }
        else { dark_pieces.add(p); }
    }
    
    public void removePiece(Piece p) {
        if (p.color == light) { light_pieces.remove(p); }
        else { dark_pieces.remove(p); }
    }
    
    private LinkedList<Piece> dark_pieces;
    private LinkedList<Piece> light_pieces;
    
    boolean turn;
    
    Tile selected;
    
    
    public static void main(String[] args) {
        Game chess = new Chess();
        chess.play();
    }
}
