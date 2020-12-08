import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
abstract public class Piece<B extends Board> extends JButton
{
    public Piece(B board, int x, int y, Boolean b)
    {
        if(b==true)
            board.getTile(x,y).setBackground(Color.BLACK);
        else
            board.getTile(x,y).setBackground(Color.WHITE);
    }
    
    abstract protected Board moves(int x, int y);
}
