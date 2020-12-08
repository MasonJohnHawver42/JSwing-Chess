//Josh
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
