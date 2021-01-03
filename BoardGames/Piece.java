import java.util.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;

abstract public class Piece
{
    public Piece(Player o)
    {
        name = "NULL";
        value = 0;
        
        owner = o;
        owner.add(this);
        
        if (icons == null) { loadIcons(); }
    }
    
    public void initTile(ChessTile t) { 
        tile = t;
        tile.placePiece(this);
    }
    
    public void setTile(ChessTile t) { tile = t; }
    
    public Player getOwner() { return owner; }
    public ChessTile getTile() { return tile; }
    public String getName() { return name; }
    public boolean getColor() { return owner.getColor(); }
    public int getValue() {return value;}
    
    public void capture() { owner.remove(this); }
    public void redeem() { owner.add(this); }
    
    abstract protected LinkedList<Move> moves();
    
    protected Player owner;
    
    protected String name;
    protected int value;
    
    protected ChessTile tile; //pos
    
    static public void loadIcons() {
        icons = new HashMap<String, Icon>();
        icons.put("LP", new ImageIcon("assets/LightPawn.png") );
        icons.put("LKN",new ImageIcon("assets/LightKnight.png") );
        icons.put("LB", new ImageIcon("assets/LightBishop.png") );
        icons.put("LR", new ImageIcon("assets/LightRook.png") );
        icons.put("LK", new ImageIcon("assets/LightKing.png") );
        icons.put("LQ", new ImageIcon("assets/LightQueen.png") );
        icons.put("DP", new ImageIcon("assets/DarkPawn.png") );
        icons.put("DKN",new ImageIcon("assets/DarkKnight.png") );
        icons.put("DB", new ImageIcon("assets/DarkBishop.png") );
        icons.put("DR", new ImageIcon("assets/DarkRook.png") );
        icons.put("DK", new ImageIcon("assets/DarkKing.png") );
        icons.put("DQ", new ImageIcon("assets/DarkQueen.png") );
        //icons.put("LP", new ImageIcon("C:\\Users\\addag\\OneDrive\\Desktop\\Code for AP Comp\\AP Comp Project\\Test 5\\boardgame666666\\BoardGames\\assets\\LightPawn.png") );
        //icons.put("LKn",new ImageIcon("C:\\Users\\addag\\OneDrive\\Desktop\\Code for AP Comp\\AP Comp Project\\Test 5\\boardgame666666\\BoardGames\\assets\\LightKnight.png") );
        //icons.put("LB", new ImageIcon("C:\\Users\\addag\\OneDrive\\Desktop\\Code for AP Comp\\AP Comp Project\\Test 5\\boardgame666666\\BoardGames\\assets\\LightBishop.png") );
        //icons.put("LR", new ImageIcon("C:\\Users\\addag\\OneDrive\\Desktop\\Code for AP Comp\\AP Comp Project\\Test 5\\boardgame666666\\BoardGames\\assets\\LightRook.png") );
        //icons.put("LK", new ImageIcon("C:\\Users\\addag\\OneDrive\\Desktop\\Code for AP Comp\\AP Comp Project\\Test 5\\boardgame666666\\BoardGames\\assets\\LightKing.png") );
        //icons.put("LQ", new ImageIcon("C:\\Users\\addag\\OneDrive\\Desktop\\Code for AP Comp\\AP Comp Project\\Test 5\\boardgame666666\\BoardGames\\assets\\LightQueen.png") );
        //icons.put("DP", new ImageIcon("C:\\Users\\addag\\OneDrive\\Desktop\\Code for AP Comp\\AP Comp Project\\Test 5\\boardgame666666\\BoardGames\\assets\\DarkPawn.png") );
        //icons.put("DKn",new ImageIcon("C:\\Users\\addag\\OneDrive\\Desktop\\Code for AP Comp\\AP Comp Project\\Test 5\\boardgame666666\\BoardGames\\assets\\DarkKnight.png") );
        //icons.put("DB", new ImageIcon("C:\\Users\\addag\\OneDrive\\Desktop\\Code for AP Comp\\AP Comp Project\\Test 5\\boardgame666666\\BoardGames\\assets\\DarkBishop.png") );
        //icons.put("DR", new ImageIcon("C:\\Users\\addag\\OneDrive\\Desktop\\Code for AP Comp\\AP Comp Project\\Test 5\\boardgame666666\\BoardGames\\assets\\DarkRook.png") );
        //icons.put("DK", new ImageIcon("C:\\Users\\addag\\OneDrive\\Desktop\\Code for AP Comp\\AP Comp Project\\Test 5\\boardgame666666\\BoardGames\\assets\\DarkKing.png") );
        //icons.put("DQ", new ImageIcon("C:\\Users\\addag\\OneDrive\\Desktop\\Code for AP Comp\\AP Comp Project\\Test 5\\boardgame666666\\BoardGames\\assets\\DarkQueen.png") );
    }
    
    static public Icon getIcon(Piece p) { 
        if(p != null) { return getIcon((p.getColor() ? "D" : "L") + p.name); }
        return null;
    }
    
    static public Icon getIcon(String abbr) { return icons.get(abbr.toUpperCase()); }
   
    
    static Map<String, Icon> icons;
}

