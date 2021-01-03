
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class History extends JPanel implements ActionListener
{
    public History(Chess game) {
        this.game = game;
        
        moves = new LinkedList<Move>();
        current = 0;
        
        display = new JTextArea("", 30, 3);
        JScrollPane sbrText = new JScrollPane(display);
        sbrText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        forward = new JButton(">");
        backward = new JButton("<");
        forward.addActionListener(this);
        backward.addActionListener(this);
        
        setLayout(new BorderLayout());
        
        JPanel pan = new JPanel();
        pan.add(backward);
        pan.add(forward);
        
        add(pan, BorderLayout.SOUTH);
        add(sbrText, BorderLayout.CENTER);
    }
    
    Chess game;
    
    public boolean atCurrent() { return current == moves.size(); }
    
    public Move getCurrent() { return moves.get(current - 1); }
    
    public void add(Move m) {
        if ( current == moves.size() ) {
            moves.add(m);
            
            display.setText(display.getText() + m.getNotation() + "\n");
            
            current++;
        } else { throw new RuntimeException("Not at current"); }
    }
    
    public void forward() {
        if ( current < moves.size() ) {
            current++;
            getCurrent().Do();
        }
        else { throw new RuntimeException("At current move"); }
    }
    
    public void backward() {
        if ( current > 0 ) {
            getCurrent().Undo();
            current--;
        }
        else { throw new RuntimeException("At first move"); }
    }
    
    public void actionPerformed(ActionEvent e) {
        
        ChessTile selected = (ChessTile)game.getSelected();
        
        if ( selected != null ) { selected.unselect(); }
        
        
        if (e.getSource() == forward) {
            try { this.forward(); }
            catch (RuntimeException ex) {  }
        }
        if (e.getSource() == backward) {
            try { this.backward(); } 
            catch (RuntimeException ex) {  }
        }
    }
    
    private LinkedList<Move> moves;
    public int current;
    
    private JTextArea display;
    private JButton backward, forward;
}
