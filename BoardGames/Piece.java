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


*/ // This is how I did it so It wokered with the rest of the code joshimport java.util.*;

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


*/ // This is how I did it so It wokered with the rest of the code joshimport java.util.*;

import java.util.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;

abstract public class Piece
{
    public Piece(Boolean c)
    {
        color = c;
        name = "NULL";
        
        if (icons == null) { loadIcons(); }
    }
    
    static public void loadIcons() {
        icons = new HashMap<String, Icon>();
        icons.put("LP", new ImageIcon("assets/LightPawn.png") );
        icons.put("LKn",new ImageIcon("assets/LightKnight.png") );
        icons.put("LB", new ImageIcon("assets/LightBishop.png") );
        icons.put("LR", new ImageIcon("assets/LightRook.png") );
        icons.put("LK", new ImageIcon("assets/LightKing.png") );
        icons.put("LQ", new ImageIcon("assets/LightQueen.png") );
         icons.put("DP", new ImageIcon("assets/DarkPawn.png") );
        icons.put("DKn",new ImageIcon("assets/DarkKnight.png") );
        icons.put("DB", new ImageIcon("assets/DarkBishop.png") );
        icons.put("DR", new ImageIcon("assets/DarkRook.png") );
        icons.put("DK", new ImageIcon("assets/DarkKing.png") );
        icons.put("DQ", new ImageIcon("assets/DarkQueen.png") );
    }
    
    static public Icon getIcon(Piece p) { 
        return icons.get((p.color ? "D" : "L") + p.name);
    }
    
    public void move(ChessTile t) { t.setPiece(this); }
    
    public String getName() { return name; }
    public boolean getColor() { return color; }
    
    abstract protected LinkedList<ChessTile> moves(ChessTile tile);
    
    protected String name;
    protected Boolean color;
    
    static Map<String, Icon> icons;
}

