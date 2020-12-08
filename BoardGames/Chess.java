
/**
 * Write a description of class Chess here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Chess extends Game 
{
    public Chess() {
        super("Chess");
    }
    
    public void init() {
        board = new ChessBoard(this);
        add(board);
    }
}
