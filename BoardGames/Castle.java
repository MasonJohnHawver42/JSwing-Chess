package BoardGames;

public class Castle extends Move
{

   public Castle(King k, Rook r, ChessTile t)
   {
        super(k, t); 
        movek = new NormalMove(k, t);
        mover = new NormalMove(r, k.getTile());
   }
   
   private NormalMove movek;
   private NormalMove mover;

   public void Do() 
   {
     mover.Do();
     movek.Do();
   }

   public void Undo() 
   {
     movek.Undo();
     mover.Undo();
   }
}
