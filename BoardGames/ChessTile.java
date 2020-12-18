import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.*;

//made prettier, need to allign text to center still

public class ChessTile extends Tile<ChessBoard> implements ActionListener
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
        if(p.getName().equals("P"))
        {
            promotion(p);
            piece = p;
            setIcon(Piece.getIcon(p));
        }
    }
    
    public Piece promotion(Piece p)
    {
        try{
            if((piece.getColor()==false && piece.getTile().getRow()==1) || (p.getColor() && p.getTile().getRow()==6))
            {
                frm = new JFrame("Promotion");
                frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frm.setLayout(new GridLayout(5, 1));
                //245
                frm.setPreferredSize(new Dimension(60,480));
                JLabel promote = new JLabel("<html>Select a piece to promote your pawn to.</html>");
                //promote.setAlignmentX(JLabel.CENTER_ALIGNMENT);
                //promote.setHorizontalAlignment(JLabel.CENTER);
                //promote.setVerticalAlignment(JLabel.CENTER);
                //promote.setLocation((this.getWidth()-promote.getWidth())/2,60);
                frm.add(promote);
                
                if(piece.getColor()==false)
                {
                    b1 = new JButton(new ImageIcon("assets/LightQueen.png"));
                    b2 = new JButton(new ImageIcon("assets/LightKnight.png"));
                    b3 = new JButton(new ImageIcon("assets/LightRook.png"));
                    b4 = new JButton(new ImageIcon("assets/LightBishop.png"));
                    /*
                    b1 = new JButton(new ImageIcon("C:\\Users\\addag\\OneDrive\\Desktop\\Code for AP Comp\\AP Comp Project\\Test 5\\boardgame666666\\BoardGames\\assets\\LightQueen.png") );
                    b2 = new JButton(new ImageIcon("C:\\Users\\addag\\OneDrive\\Desktop\\Code for AP Comp\\AP Comp Project\\Test 5\\boardgame666666\\BoardGames\\assets\\LightKnight.png") );
                    b3 = new JButton(new ImageIcon("C:\\Users\\addag\\OneDrive\\Desktop\\Code for AP Comp\\AP Comp Project\\Test 5\\boardgame666666\\BoardGames\\assets\\LightRook.png") );
                    b4 = new JButton(new ImageIcon("C:\\Users\\addag\\OneDrive\\Desktop\\Code for AP Comp\\AP Comp Project\\Test 5\\boardgame666666\\BoardGames\\assets\\LightBishop.png") );
                     */
                }else{
                    b1 = new JButton(new ImageIcon("assets/DarkQueen.png"));
                    b2 = new JButton(new ImageIcon("assets/DarkKnight.png"));
                    b3 = new JButton(new ImageIcon("assets/DarkRook.png"));
                    b4 = new JButton(new ImageIcon("assets/DarkBishop.png"));
                    /*
                    b1 = new JButton(new ImageIcon("C:\\Users\\addag\\OneDrive\\Desktop\\Code for AP Comp\\AP Comp Project\\Test 5\\boardgame666666\\BoardGames\\assets\\DarkQueen.png") );
                    b2 = new JButton(new ImageIcon("C:\\Users\\addag\\OneDrive\\Desktop\\Code for AP Comp\\AP Comp Project\\Test 5\\boardgame666666\\BoardGames\\assets\\DarkKnight.png") );
                    b3 = new JButton(new ImageIcon("C:\\Users\\addag\\OneDrive\\Desktop\\Code for AP Comp\\AP Comp Project\\Test 5\\boardgame666666\\BoardGames\\assets\\DarkRook.png") );
                    b4 = new JButton(new ImageIcon("C:\\Users\\addag\\OneDrive\\Desktop\\Code for AP Comp\\AP Comp Project\\Test 5\\boardgame666666\\BoardGames\\assets\\DarkBishop.png") );
                     */
                }
                b1.setBackground(new Color(118, 190, 100));
                b2.setBackground(new Color(238, 238, 210));
                b3.setBackground(new Color(118, 190, 100));
                b4.setBackground(new Color(238, 238, 210));
                
                b1.addActionListener(this);
                b2.addActionListener(this);
                b3.addActionListener(this);
                b4.addActionListener(this);
                
                frm.add(b1);
                frm.add(b2);
                frm.add(b3);
                frm.add(b4);
                
                frm.pack();
                frm.setVisible(true);
            }
        }catch(NullPointerException e){}
        return p;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        board.getGame().removePiece(piece);;
        if(e.getSource()==b1)
            piece = new Queen(piece.getColor());
        else if(e.getSource()==b2)
            piece = new Knight(piece.getColor());
        else if(e.getSource()==b3)
            piece = new Rook(piece.getColor());
        else if(e.getSource()==b4)
            piece = new Bishop(piece.getColor());
        setPiece(piece);
        board.getGame().addPiece(piece);
        
        frm.dispose();
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
