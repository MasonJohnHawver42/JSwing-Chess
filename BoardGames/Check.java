

public class Check extends Move
{
   public Check(Move nm) {
       super(nm.manifestor, nm.highlight);
       m = nm;
   }
   
   Move m;
   
   public void Do() 
   {
     m.Do();
   }

   public void Undo() 
   {
     m.Undo();
   }
   
   
   public String getNotation() {
        return m.getNotation() + " +";
   }
}
