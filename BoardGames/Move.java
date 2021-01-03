

public abstract class Move
{
    public Move(Piece o, ChessTile h) {
        manifestor = o;
        highlight = h;
    }
    
    abstract public void Do();
    abstract public void Undo();
    
    abstract public String getNotation();
    
    public Piece manifestor;
    public ChessTile highlight;
}

