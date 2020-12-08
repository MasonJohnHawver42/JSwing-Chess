
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ChessTile extends Tile<ChessBoard>
{
    public ChessTile(ChessBoard b, int r, int c, boolean col) {
        super(b, r, c);
        
        setPreferredSize(new Dimension(50, 50));
        
        if ( col == Chess.dark ) { setBackground(new Color(152,251,152)); }
        else { setBackground(Color.WHITE); }
        
        if ( piece == null ) { setText(" "); }
        else { setText(piece.getName()); }
    }
    
    private void removePiece() { 
        if (piece != null) {
            board.getGame().removePiece(piece);
            setText(" ");
        }
        
        piece = null; 
    }
    private void addPiece(Piece p) { 
        if (p != null) { 
            if (p.color == Chess.dark) { setForeground(Color.BLACK); }
            else { setForeground(Color.GRAY); }
            
            setText(p.getName()); 
        }
            
        piece = p; 
    }
    
    public void setPiece(Piece p) { 
        removePiece();
        addPiece(p);
    }
    
    protected State initState() { return new State(this); }
    
    Piece piece;
}
