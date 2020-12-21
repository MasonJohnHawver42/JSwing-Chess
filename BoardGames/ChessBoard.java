 

//kunal
public class ChessBoard extends Board<Chess>
{
    public ChessBoard(Chess game) 
    {
      super(game, 8, 8);

      placePiece(new Pawn(game.dark_player), 1, 0);
      placePiece(new Pawn(game.dark_player), 1, 1);
      placePiece(new Pawn(game.dark_player), 1, 2);
      placePiece(new Pawn(game.dark_player), 1, 3);
      placePiece(new Pawn(game.dark_player), 1, 4);
      placePiece(new Pawn(game.dark_player), 1, 5);
      placePiece(new Pawn(game.dark_player), 1, 6);
      placePiece(new Pawn(game.dark_player), 1, 7);
      placePiece(new Rook(game.dark_player), 0, 0);
      placePiece(new Rook(game.dark_player), 0, 7);
      placePiece(new Knight(game.dark_player), 0, 1);
      placePiece(new Knight(game.dark_player), 0, 6);
      placePiece(new Bishop(game.dark_player), 0, 2);
      placePiece(new Bishop(game.dark_player), 0, 5);
      placePiece(new Queen(game.dark_player), 0, 3);
      placePiece(new King(game.dark_player), 0, 4);
      
      placePiece(new Pawn(game.light_player), 6, 0);
      placePiece(new Pawn(game.light_player), 6, 1);
      placePiece(new Pawn(game.light_player), 6, 2);
      placePiece(new Pawn(game.light_player), 6, 3);
      placePiece(new Pawn(game.light_player), 6, 4);
      placePiece(new Pawn(game.light_player), 6, 5);
      placePiece(new Pawn(game.light_player), 6, 6);
      placePiece(new Pawn(game.light_player), 6, 7);
      placePiece(new Rook(game.light_player), 7, 7);
      placePiece(new Rook(game.light_player), 7, 0);
      placePiece(new Knight(game.light_player), 7, 1);
      placePiece(new Knight(game.light_player), 7, 6);
      placePiece(new Bishop(game.light_player), 7, 2);
      placePiece(new Bishop(game.light_player), 7, 5);
      placePiece(new Queen(game.light_player), 7, 3);
      placePiece(new King(game.light_player), 7, 4);
    }
    
    public Tile initTile(int i, int j) { return new ChessTile(this, i, j, i % 2 != j % 2); }
    
    public void placePiece(Piece p, int i, int j) { p.initTile((ChessTile)getTile(i, j)); }
}
