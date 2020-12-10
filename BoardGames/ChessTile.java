import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.*;

//mason

public class ChessTile extends Tile<ChessBoard>
{
    public ChessTile(ChessBoard b, int r, int c, boolean col) {
        super(b, r, c);
        color = col;
        
        state = new UnSelected(this); 
        state.start();
        
        setPreferredSize(new Dimension(60, 60));
    }
    
    public boolean empty() { return piece == null; }
    
    public Piece getPiece() {
        return piece;
    }
   
    
    public boolean getColor() {
        return color;
    }
    
    private void removePiece() { 
        if (piece != null) {
            board.getGame().removePiece(piece);
            setIcon(null);
        }
        
        piece = null; 
    }
    private void addPiece(Piece p) { 
        if (p != null) {
            board.getGame().addPiece(p);
            setIcon(Piece.getIcon(p));
        }
            
        piece = p; 
    }
    
    public void setPiece(Piece p) { 
        removePiece();
        addPiece(p);
    }
    
    public void movePiece(ChessTile place) {
        place.setPiece(piece);
        setIcon(null);
        piece = null;
    }
    
    public void select() { this.getBoard().getGame().select(this); }
    
    private class UnSelected extends State<ChessTile> {
        public UnSelected(ChessTile tile) { super(tile); }
        
        public void start() { 
            super.start();
            Color tc;
            
            if (tile.getColor() == Chess.dark) { tc = new Color(118, 190, 100); }
            else { tc = new Color(238, 238, 210); }
            
            tile.setBackground(tc);
        }
        public void update(ActionEvent e) {
            
            ChessTile selected = (ChessTile)tile.getBoard().getGame().getSelected();
            
            if ( selected == null ) {
                tile.setState(new Selected(tile)); 
            }
            else {
                selected.setState(new UnSelected(selected));
                tile.setState(new Selected(tile)); 
            }
        }
        public void terminate() { super.terminate(); }
    }
    
    private class Selected extends State<ChessTile> {
        public Selected(ChessTile tile) { 
            super(tile); 
            highlights = new LinkedList<ChessTile>();
        }
        
        public void start() { 
            super.start();
            Color tc = tile.getBackground();
            tile.setBackground(tc.darker().darker());
            
            tile.select();
            
            if (tile.piece != null) {
                LinkedList<ChessTile> moves = tile.piece.moves(tile);
                
                for (ChessTile move: moves) {
                    move.setState(new Highlighted(move));
                    highlights.add(move);
                }
            }
        }
        public void update(ActionEvent e) { 
            
            tile.setState(new UnSelected(tile)); 
        }
            
        public void terminate() { 
            super.terminate(); 
            tile.getBoard().getGame().select(null);
            
            for (ChessTile highlight: highlights) {
                 highlight.setState(new UnSelected(highlight));
            }
            
            highlights.clear();
        }
        
        LinkedList<ChessTile> highlights;
    }
    
    private class Highlighted extends State<ChessTile> {
        public Highlighted(ChessTile tile) { super(tile); }
        public void start() { 
            super.start();
            Color tc = tile.getBackground();
            tile.setBackground(tc.darker());
        }
        
        public void update(ActionEvent e) {
            
            
            ChessTile selected = (ChessTile)tile.getBoard().getGame().getSelected();
            
            selected.movePiece(tile);
            selected.setState(new UnSelected(selected));
        
        }
        
        public void terminate() { super.terminate(); }
    
    }
    
    Piece piece;
    boolean color;
}
