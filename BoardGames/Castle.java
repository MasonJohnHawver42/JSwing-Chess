package BoardGames;


public class Castle extends Move
{
   public Castle(King k, ChessTile t)
   {
        super(k.getOwner(), t); 
        movek = new NormalMove(k, t); 
   }
   
   public Castle(Rook r, ChessTile t)
   {
      super(r.getOwner(), t);
      mover = new NormalMove(r,t);
   }
   
   private NormalMove movek;
   private NormalMove mover;
   
   public void Do() 
   {
     
   }
   
   public void Undo() 
   {
   
   }
   
}
