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
    
    public void setPiece(Piece p) {
        p.move(this);
        board.getGame().addPiece(p);
    }
    
    public void removePiece() { 
        if (piece != null) {
            board.getGame().removePiece(piece);
            setIcon(null);
            piece = null; 
        }
    }
    
    public void placePiece(Piece p) {
        this.removePiece();
        piece = p;
        setIcon(Piece.getIcon(p));
    }
    
    public void movePiece() {
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
            
            Chess game = tile.getBoard().getGame();
            ChessTile selected = (ChessTile)game.getSelected();
            
            if ( selected != null ) { selected.setState(new UnSelected(selected)); }
            
            if (tile.getPiece() != null) {
                if (game.getTurn().getColor() == tile.getPiece().getColor()) {
                    tile.setState(new Selected(tile));
                }
                
                
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
                LinkedList<ChessTile> moves = tile.piece.moves();
                
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
            
            Chess game = tile.getBoard().getGame();
            ChessTile selected = (ChessTile)game.getSelected();
            Piece p = selected.getPiece();
            
            
            boolean moved = p.move(tile);
            
            if (moved) {
               selected.setState(new UnSelected(selected));
                
               tile.getBoard().getGame().getTurn().endTurn();
            }
            
        }
        
        public void terminate() { super.terminate(); }
    
    }
    
    public void check() { setState(new Checked(this)); }
    
    public class Checked extends UnSelected {
        public Checked(ChessTile tile) { super(tile); }
        public void start() { 
            super.start();
            Color tc = tile.getBackground();
            tile.setBackground(new Color(240, 20, 20));
        }
    }
    
    Piece piece;
    boolean color;
}
