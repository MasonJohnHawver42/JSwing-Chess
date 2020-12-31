    
import java.util.*; 
    
public class Player {
    
    public Player(Chess g, boolean c) {
        game = g;
        
        pieces = new LinkedList<Piece>();
        moves = new LinkedList<Move>();
        checkors = new LinkedList<Piece>();
        color = c;
        
        checked = false;
        
        points = 0;
    }
    
    public boolean getColor() { return color; }
    public int getPoints() { return points; }
    
    public Chess getGame() { return game; }
    
    public void add(Piece p) { pieces.add(p); points += p.getValue(); }
    public void remove(Piece p) { pieces.remove(p); points -= p.getValue(); }
    
    public void check() { 
        checked = true;
        System.out.println("Check");
    }
    public boolean checked() { return checked; }
    
    public void beginTurn() {
        LinkedList<Piece> ps = new LinkedList(pieces);
        
        moves.clear();
        if (!checked) {
            for (Piece p: ps) {
                
                    moves.addAll(p.moves());
                
            }
        }
        else {
            System.out.println(checkors);
            if (checkors.size() == 1) {
                
                Piece checkor = checkors.get(0);
                
                System.out.println(checkor);
                
                for (Piece p: ps) {
                    
                    LinkedList<Move> pmoves = p.moves();
                    
                    if(!(p instanceof King)) {
                           for (Move m : pmoves) {
                           boolean addit = false;
                           
                           if (m instanceof NormalMove) {
                               if(((NormalMove)m).captured == checkor) {
                                   moves.add(m);
                                   addit = true;
                               }
                           }
                           
                           if (!addit) {
                               m.Do();
                               
                               addit = true;
                               
                               for (Move em : checkor.moves()) {
                                  if (em instanceof NormalMove) {
                                       if (((NormalMove)em).captured instanceof King) {
                                            addit = false;
                                            break;
                                       }
                                  }
                               }
                               
                               m.Undo();
                               
                               if (addit) { moves.add(m); }
                               
                           }
                       }
                    }
                 
                    else {
                        
                       LinkedList<Piece> eps = new LinkedList(opponnet.pieces);
                       
                       for (Move m : pmoves) {
                           if (m instanceof NormalMove) {
                               m.Do();
                               
                               boolean addit = true;
                               
                               
                               for (Piece ep : eps) {
                                   for (Move em : ep.moves()) {
                                       if (em instanceof NormalMove) {
                                           if (((NormalMove)em).captured == p) {
                                                addit = false;
                                                break;
                                           }
                                       }
                                   }
                                   if (!addit) { break; }
                               }
                               if (addit) { moves.add(m); }
                               m.Undo();
                           }
                       }
                    }
                    
                    
                
                }
            }
            
            if (moves.size() > 0) {
                checked = false;
                checkors.clear();
            }
        }
        
    }
    
    public void makeMove(Move m) {
        try {
            game.hist.add(m);
            m.Do();
            endTurn();
            
        } catch(RuntimeException e) {}
    }
    
    public void endTurn() {
        
        for (Piece p: pieces) {
            for (Move move : p.moves()) {
               if (move instanceof NormalMove) {
                   if (((NormalMove)move).captured instanceof King) { 
                       if (!opponnet.checked()) { opponnet.check(); }
                       opponnet.checkors.add(p);
                    }
               }
            }
        }
        
        game.turn = opponnet;
        opponnet.beginTurn();
        //end clock or somthing
    }
    
    private Chess game;
    public Player opponnet;
    
    private LinkedList<Piece> pieces;
    private boolean color;
    private int points;
    
    private boolean checked;
    
    public LinkedList<Piece> checkors;
    
    public LinkedList<Move> moves;
    
}
