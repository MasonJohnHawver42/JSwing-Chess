    
import java.util.*; 
    
public class Player {
    
    public Player(Chess g, boolean c) {
        game = g;
        
        pieces = new LinkedList<Piece>();
        color = c;
        
        king = null;
        checked = false;
        
        points = 0;
    }
    
    public boolean getColor() { return color; }
    
    public void add(Piece p) { pieces.add(p); points += 1; if (p instanceof King) {king = p;} }
    public void remove(Piece p) { pieces.remove(p); }
    
    public void check() { 
        checked = true;
        king.getTile().check();
    }
    public boolean Checked() { return checked; }
    
    public void beginTurn() {
        //start a clock or somthing
    }
    public void endTurn() {
        
        for (Piece p: pieces) {
            LinkedList<ChessTile> moves = p.moves();
            if (moves.contains(opponnet.king.getTile())) { opponnet.check(); break; }
        }
        
        game.turn = opponnet;
        opponnet.beginTurn();
        //end clock or somthing
    }
    
    private Chess game;
    public Player opponnet;
    
    private LinkedList<Piece> pieces;
    private boolean color;
    private int points;
    
    private Piece king;
    private boolean checked;
    
}