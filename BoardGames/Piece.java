import java.util.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;

abstract public class Piece
{
    public Piece(Boolean c, int v)
    {
        color = c;
        name = "NULL";
        value = v;
        if (icons == null) { loadIcons(); }
    }
    
    public void setTile(ChessTile t) { tile = t; }
    
    public boolean move(ChessTile move) {
        if (valid(move)) {
            if(tile != null) {tile.movePiece(); }
            move.placePiece(this);
            
            tile = move;
            return true;
        } else { return false; }
    }
    
    public boolean valid(ChessTile move) {
        return true;
    }
    
    private Player getPlayer() { 
        Chess game = tile.getBoard().getGame();
        return color ? game.light_player : game.dark_player; 
    }
    public ChessTile getTile() { return tile; }
    public String getName() { return name; }
    public boolean getColor() { return color; }
    public int getValue() {return value;}
    
    abstract protected LinkedList<ChessTile> moves();
    
    protected String name;
    protected Boolean color;
    protected int value;
    
    protected ChessTile tile; //pos
    
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
        return icons.get((p.color ? "D" : "L") + p.name);
    }
   
    
    static Map<String, Icon> icons;
}

