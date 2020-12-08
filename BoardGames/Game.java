import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

abstract public class Game extends JPanel {

    public Game(String n) {
        name = n;
        init();
    }

    public final void play() {
        JFrame frame = new JFrame(name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
    }

    protected Board board;
    protected String name;
}
