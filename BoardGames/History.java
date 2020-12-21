
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class History extends JPanel implements ActionListener
{
    public History() {
        moves = new LinkedList<Move>();
        current = 0;
        
        
        forward = new JButton(">");
        backward = new JButton("<");
        forward.addActionListener(this);
        backward.addActionListener(this);
        
        add(backward);
        add(forward);
    }
    
    public Move getCurrent() { return moves.get(current - 1); }
    
    public void add(Move m) {
        if ( current == moves.size() ) {
            moves.add(m);
            current++;
        }
        else { throw new RuntimeException("Not at current move"); }
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
    private int current;
    
    private JButton backward, forward;
}
