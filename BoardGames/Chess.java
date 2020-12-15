
import java.util.*;


public class Chess extends Game 
{
    static final boolean light = false; 
    static final boolean dark = true;
    
    public Chess() {
        super("Chess");
        
        light_playa = new Player(this, light);
        dark_playa = new Player(this, dark);
        
        light_playa.opponnet = dark_playa;
        dark_playa.opponnet = light_playa;
        
        turn = light_playa;
    }
    
    public void init() {
        board = new ChessBoard(this);
        add(board);
    }
    
    public void select(Tile t) { selected = t; }
    public Tile getSelected() { return selected; }
    
    public void addPiece(Piece p) {
        if (p.color == light) { light_playa.add(p); }
        else { dark_playa.add(p); }
    }
    
    public void removePiece(Piece p) {
        if (p.color == light) { light_playa.remove(p); }
        else { dark_playa.remove(p); }
    }
    
    public Player getTurn() { return turn; }
    
    private Player light_playa;
    private Player dark_playa;
    
    public Player turn;
    
    
    Tile selected;
    
    public static void main(String[] args) {
        Game chess = new Chess();
        chess.play();
    }
}
