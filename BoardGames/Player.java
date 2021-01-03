    
import java.util.*;
import static javax.swing.JOptionPane.showMessageDialog;
    
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
            
            King k = null;
            for (Piece p: ps) { if (p instanceof King) { k = (King)p; } }

            for (Piece p: ps) {
                
                int x1 = p.getTile().getCol();
                int y1 = p.getTile().getRow();
                int x2 = k.getTile().getCol();
                int y2 = k.getTile().getRow();
                
                if ( x1 == x2 || y1 == y2 || Math.abs((float)(y2 - y1) / (float)(x2 - x1)) == 1) {
                   LinkedList<Piece> eps = new LinkedList(opponnet.pieces);
                   LinkedList<Move> pmoves = p.moves();
                       
                   for (Move m : pmoves) {
                       
                       m.Do();
                       
                       boolean addit = true;
                       
                       for (Piece ep : eps) {
                           for (Move em : ep.moves()) {
                               if (em instanceof NormalMove) {
                                   if (((NormalMove)em).captured == k) {
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
                else { moves.addAll(p.moves()); }
            }
            
            if (moves.size() == 0) { 
                showMessageDialog(game, "Draw", null, 0, Piece.getIcon((color ? "LK" : "DK")));
            }
        }
        else {
            if (checkors.size() == 1) {
                
                Piece checkor = checkors.get(0);
                
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
                           
                           m.Do();
                           
                           boolean addit = true;
                           
                           for (Piece ep : eps) {
                               for (Move em : ep.moves()) {
                                   if (em instanceof NormalMove) {
                                       if (((NormalMove)em).captured instanceof King) {
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
            
            if (moves.size() > 0) {
                checked = false;
                checkors.clear();
            }
            else {
                System.out.println("CheckMate");
                showMessageDialog(game, "CheckMate", null, 0, Piece.getIcon(checkors.get(0)));
            }
        }
        
        thinking = true;
    }
    
    public void makeMove(Move m) {
        if (game.hist.atCurrent()) {
            m.Do();
            
            LinkedList<Piece> ps = new LinkedList(pieces);
            for (Piece p: ps) {
                for (Move move : p.moves()) {
                   if (move instanceof NormalMove) {
                       if (((NormalMove)move).captured instanceof King) { 
                           if (!opponnet.checked()) { opponnet.check(); ((NormalMove)move).to.anger(); }
                           opponnet.checkors.add(p);
                        }
                   }
                }
            }
            
            King k = null;
            for (Piece p: ps) { if (p instanceof King) { k = (King)p; } }
            k.tile.unselect();
            
            if (opponnet.checked) {
                m = new Check(m);
            }
            
            
            game.hist.add(m);
            endTurn();
        }
    }
    
    public void endTurn() {
        
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
    public boolean thinking = false;
    
    public LinkedList<Piece> checkors;
    
    public LinkedList<Move> moves;
    
}
