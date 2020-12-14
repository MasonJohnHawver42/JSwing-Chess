import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Chess extends Game 
{
    static final boolean light = false; 
    static final boolean dark = true;
    static int whitePoint, blackPoint;
    static JLabel wPoint, bPoint;
    
    
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
        if (p.color == light) { 
            light_pieces.remove(p); 
            blackPoint += p.getValue();
            bPoint.setText("Black Points: " + Integer.toString(blackPoint));
        }
        else { 
            dark_pieces.remove(p); 
            whitePoint += p.getValue(); 
            wPoint.setText("White Points: " + Integer.toString(whitePoint));
        }
    }
    
    private LinkedList<Piece> dark_pieces;
    private LinkedList<Piece> light_pieces;
    
    boolean turn;
    
    Tile selected;
    
    
    public static void main(String[] args) {
        Game chess = new Chess();
        JPanel points = new JPanel();
        
        chess.setLayout(new BorderLayout());
        wPoint = new JLabel();
        JLabel spacer = new JLabel();
        bPoint = new JLabel();
        
        wPoint.setText("White Points: " + Integer.toString(whitePoint));
        spacer.setText("|\t|");
        bPoint.setText("Black Points: " + Integer.toString(blackPoint));
        
        points.add(wPoint);
        points.add(spacer);
        points.add(bPoint);
        
        chess.add(points, BorderLayout.NORTH);
        
        chess.play();
    }
}
