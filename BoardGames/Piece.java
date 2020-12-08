//Josh
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
abstract public class Piece<ChessBoard> extends JButton
{
    public Piece(ChessBoard cb, int x, int y, Boolean b)
    {
        super(cb, y, x);
        if(b==true)
            board.getTile(x,y).setBackground(Color.BLACK);
        else
            board.getTile(x,y).setBackground(Color.WHITE);
    }
    
    abstract protected Board moves(int x, int y);
}
