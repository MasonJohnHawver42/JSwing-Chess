
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
        
        hist = new History();
        board = new ChessBoard(this);
        
        
    }
    
    public void init() {
        
        add(board);
        add(hist);
    }
    
    public void select(Tile t) { selected = t; }
    public Tile getSelected() { return selected; }
    
    public Player getTurn() { return turn; }
    
    public Player light_player;
    public Player dark_player;
    
    public Player turn;
    
    public History hist;
    
    Tile selected;
    
    public static void main(String[] args) {
        Chess chess = new Chess();
        chess.light_player.beginTurn();
        chess.play();
    }
}
