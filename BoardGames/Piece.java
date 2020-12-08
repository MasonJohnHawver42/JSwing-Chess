//Josh
/*
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


*/ // This is how I did it so It wokered with the rest of the code josh
import java.util.*;

abstract public class Piece
{
    public Piece(Boolean c)
    {
        color = c;
        name = "NULL";
    }
    
    public void move(ChessTile t) { t.setPiece(this); }
    
    public String getName() { return name; }
    
    abstract protected LinkedList<ChessTile> moves(ChessTile tile);
    
    protected String name;
    protected Boolean color;
}
