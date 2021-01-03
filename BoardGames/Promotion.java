import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Promotion extends Move 
{
    public Promotion(Pawn p, ChessTile t)
    {
        super(p, t);
        
        pawn = p;
        from = pawn.getTile();
        
        to = t;
    }
    
    public void Do() {
        
        from.removePiece();
        pawn.capture();
        
        promotion = new Queen(pawn.owner);
        promotion.setTile(to);
        to.placePiece(promotion);
        
    }
    public void Undo() {
        promotion.capture();
        to.removePiece();
        
        from.placePiece(pawn);
        pawn.redeem();
    }
    
    private Piece promotion;
    private Piece pawn;
    
    private ChessTile from;
    private ChessTile to;
    
    //gui stuff
    private JButton b1, b2, b3, b4;
    private JFrame frm;
    
    private void promote() {
                frm = new JFrame("Promotion");
                frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //use 60 for width if no JLabel vvv
                frm.setLayout(new BorderLayout());
                JLabel pmt = new JLabel("Promote to:");
                pmt.setPreferredSize(new Dimension(10, 40));
                frm.add(pmt, BorderLayout.NORTH);
           
                //245
                //JLabel promote = new JLabel("<html>Select a piece to promote your pawn to.</html>");
                //promote.setAlignmentX(JLabel.CENTER_ALIGNMENT);
                //promote.setHorizontalAlignment(JLabel.CENTER);
                //promote.setVerticalAlignment(JLabel.CENTER);
                //promote.setLocation((this.getWidth()-promote.getWidth())/2,60);
                //frm.add(promote);
                
                String prefix = (pawn.getColor() ? "D" : "L");
                b1 = new JButton(Piece.getIcon(prefix  + "Q"));
                b2 = new JButton(Piece.getIcon(prefix  + "R"));
                b3 = new JButton(Piece.getIcon(prefix  + "Kn"));
                b4 = new JButton(Piece.getIcon(prefix  + "B"));
                
                b1.setBackground(new Color(118, 190, 100));
                b2.setBackground(new Color(238, 238, 210));
                b4.setBackground(new Color(118, 190, 100));
                b3.setBackground(new Color(238, 238, 210));
                
                b1.setPreferredSize(new Dimension(100, 100));
                b2.setPreferredSize(new Dimension(100, 100));
                b3.setPreferredSize(new Dimension(100, 100));
                b4.setPreferredSize(new Dimension(100, 100));

                //b1.addActionListener(this);
                //b2.addActionListener(this);
                //b3.addActionListener(this);
                //b4.addActionListener(this);
               
                JPanel pms = new JPanel();
                pms.setLayout(new GridLayout(2, 2));
                
                pms.add(b1);
                pms.add(b2);
                pms.add(b3);
                pms.add(b4);
                
                frm.add(pms, BorderLayout.CENTER);
                
                frm.pack();
                frm.setVisible(true);
    }
    
    public String getNotation() {
        return to.getName();
    }
    
}
