

public abstract class Move
{
    public Move(Piece o, ChessTile h) {
        manifestor = o;
        highlight = h;
    }
    
    public void Do() { }
    public void Undo() {}
    
    public Piece manifestor;
    public ChessTile highlight;
}

