
import java.util.*;


public class Chess extends Game 
{
    static final boolean light = false; 
    static final boolean dark = true;
    
    public Chess() {
        super("Chess");
        
        light_player = new Player(this, light);
        dark_player = new Player(this, dark);
        
        light_player.opponnet = dark_player;
        dark_player.opponnet = light_player;
        
        turn = light_player;
    }
    
    public void init() {
        board = new ChessBoard(this);
        add(board);
    }
    
    public void select(Tile t) { selected = t; }
    public Tile getSelected() { return selected; }
    
    public void addPiece(Piece p) {
        if (p.color == light) { light_player.add(p); }
        else { dark_player.add(p); }
    }
    
    public void removePiece(Piece p) {
        if (p.color == light) { light_player.remove(p); }
        else { dark_player.remove(p); }
    }
    
    public Player getTurn() { return turn; }
    
    public Player light_player;
    public Player dark_player;
    
    public Player turn;
    
    
    Tile selected;
    
    public static void main(String[] args) {
        Game chess = new Chess();
        chess.play();
    }
}
