package BoardGames;

//wt
public class ChessBoard extends Board<Chess>
{
    public ChessBoard(Chess game) 
    {
      super(game, 8, 8);
      
      placePiece(new Pawn(Chess.dark), 1, 0);
      placePiece(new Pawn(Chess.dark), 1, 1);
      placePiece(new Pawn(Chess.dark), 1, 2);
      placePiece(new Pawn(Chess.dark), 1, 3);
      placePiece(new Pawn(Chess.dark), 1, 4);
      placePiece(new Pawn(Chess.dark), 1, 5);
      placePiece(new Pawn(Chess.dark), 1, 6);
      placePiece(new Pawn(Chess.dark), 1, 7);
      placePiece(new Rook(Chess.dark), 0, 0);
      placePiece(new Rook(Chess.dark), 0, 7);
      placePiece(new Knight(Chess.dark), 0, 1);
      placePiece(new Knight(Chess.dark), 0, 6);
      placePiece(new Bishop(Chess.dark), 0, 2);
      placePiece(new Bishop(Chess.dark), 0, 5);
      placePiece(new Queen(Chess.dark), 0, 3);
      placePiece(new King(Chess.dark), 0, 4);
      
      placePiece(new Pawn(Chess.light), 6, 0);
      placePiece(new Pawn(Chess.light), 6, 1);
      placePiece(new Pawn(Chess.light), 6, 2);
      placePiece(new Pawn(Chess.light), 6, 3);
      placePiece(new Pawn(Chess.light), 6, 4);
      placePiece(new Pawn(Chess.light), 6, 5);
      placePiece(new Pawn(Chess.light), 6, 6);
      placePiece(new Pawn(Chess.light), 6, 7);
      placePiece(new Rook(Chess.light), 7, 7);
      placePiece(new Rook(Chess.light), 7, 0);
      placePiece(new Knight(Chess.light), 7, 1);
      placePiece(new Knight(Chess.light), 7, 6);
      placePiece(new Bishop(Chess.light), 7, 2);
      placePiece(new Bishop(Chess.light), 7, 5);
      placePiece(new Queen(Chess.light), 7, 3);
      placePiece(new King(Chess.light), 7, 4);
    }
    
    public Tile initTile(int i, int j) 
    { 
      /*boolean n = true;
      if(i%2 == j%2)
      {
        n = true;  
      }
      if(i%2 != j%2)
      {
        n = false;  
      }*/
      return new ChessTile(this, i, j, i % 2 != j % 2);
    }
    
    public void placePiece(Piece p, int i, int j) 
    {
       ((ChessTile)getTile(i, j)).setPiece(p);
    }
}
