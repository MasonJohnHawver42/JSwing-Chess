import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.*;

public class ChessTile extends Tile<ChessBoard>
{
    private JButton b1, b2, b3, b4;
    private JFrame frm;
    public ChessTile(ChessBoard b, int r, int c, boolean col) {
        super(b, r, c);
        color = col;
        
        state = new UnSelected(this); 
        state.start();
        
        setPreferredSize(new Dimension(60, 60));
    }
    
    public boolean empty() { return piece == null; }
    
    public Piece getPiece() { return piece; }
    public boolean getColor() { return color; }
    
    public String getName() {
        return Character.toString((char)(col + 97)) + Integer.toString(8 - row);
    }
    
    public Piece removePiece() {
        Piece removed = piece;
        setIcon(null);
        piece = null;
        return removed;
    }
    
    public Piece placePiece(Piece p) {
        Piece removed = this.removePiece();
        piece = p;
        setIcon(Piece.getIcon(p));
        return removed;
    }
    
    public void select() { this.getBoard().getGame().select(this); }
    public void unselect() { this.setState(new UnSelected(this)); this.getBoard().getGame().select(null); }
    
    public class UnSelected extends State<ChessTile> {
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
            
            if (game.hist.atCurrent()) {
                if (tile.getPiece() != null) {
                    if (game.getTurn().getColor() == tile.getPiece().getColor()) {
                        tile.setState(new Selected(tile));
                    }
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
                LinkedList<Move> moves = tile.piece.moves();
                
                Piece p = tile.getPiece();
                
                for (Move move: p.getOwner().moves) {
                    if (move.manifestor == p) {
                        move.highlight.setState(new Highlighted(move));
                        highlights.add(move.highlight);
                    }
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
        public Highlighted(Move m) { super(m.highlight); move = m; }
        public void start() { 
            super.start();
            Color tc = tile.getBackground();
            tile.setBackground(tc.darker());
        }
        
        public void update(ActionEvent e) {
            
            Chess game = tile.getBoard().getGame();
            ChessTile selected = (ChessTile)game.getSelected();
            Player p = selected.getPiece().getOwner();
            p.makeMove(move);
            selected.setState(new UnSelected(selected));

        }
        
        public void terminate() { super.terminate(); }
        
        
        private Move move;
    }
    
    private class Angry extends UnSelected {
    
        public Angry(ChessTile t) {
            super(t);
        }
        
        public void start() { 
            super.start();
            
            tile.setBackground(new Color(230, 45, 45));
        }
    }
    
    public void anger() { this.setState(new Angry(this)); }
   
    
    Piece piece;
    boolean color;
}
