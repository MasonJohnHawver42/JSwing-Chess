

public abstract class Move
{
    public Move(Player o, ChessTile h) {
        owner = o;
        highlight = h;
    }
    
    public void Do() { }
    public void Undo() {}
    
    public Player owner;
    public ChessTile highlight;
}

