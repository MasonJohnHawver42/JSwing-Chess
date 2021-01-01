package BoardGames;

public class Castle extends Move
{

   public Castle(King k, Rook r, ChessTile t1, ChessTile t2)
   {
        super(k, t1); 
        movek = new NormalMove(k, t1);
        mover = new NormalMove(r, k.getTile());
        moverr = new NormalMove(r,t2);
   }
   
   private NormalMove movek;
   private NormalMove mover;
   private NormalMove moverr;

   public void Do() 
   {
     mover.Do();
     movek.Do();
     moverr.Do();
   }

   public void Undo() 
   {
     movek.Undo();
     mover.Undo();
   }
}
