//wt
public class ChessBoard extends Board<Chess>
{
    public ChessBoard(Chess game) 
    {
      super(game, 8, 8);
      
      placePiece(new Pawn(Chess.dark), 1, 1);
    }
    
    public Tile initTile(int i, int j) 
    { 
      boolean n = true;
      if(i%2 == 0 && j%2 != 0)
      {
        n = true;  
      }
      if(i%2 != 0 && j%2 == 0)
      {
        n = false;  
      }
      return new ChessTile(this, i, j, n);
    }
    
    public void placePiece(Piece p, int i, int j) {
        ((ChessTile)getTile(i, j)).setPiece(p);
    }
}
