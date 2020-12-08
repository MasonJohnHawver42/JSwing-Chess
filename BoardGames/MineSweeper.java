
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

///
/// Game
///


public class MineSweeper extends Game
{
    public MineSweeper() {
        super("Mine Sweeper");
    }

    protected void init() {
        board = new MSBoard(this, 10);
        add(board);
    }

    ///
    /// Board
    ///

    private class MSBoard extends Board<MineSweeper> {
        public MSBoard(MineSweeper g, int size) {
            super(g, size, size);
        }

        @Override
        public Tile initTile(int i, int j) { return new MSTile(this, i, j); }
    }

    ///
    /// Cell
    ///

    private class MSTile extends Tile<MSBoard> {

        public MSTile(MSBoard b, int r, int c) {
            super(b, r, c);
        }

        @Override
        public Tile.State initState() { return new UnInit(this); }

        private Boolean mined;

        ///
        /// States
        ///

        // State UnInit

        private class UnInit extends State<MSTile> {
            public UnInit(MSTile t) {
                super(t);
                t.setText("U");
            }
            public void update(ActionEvent e) {

                tile.mined = false;

                tile.state = new UnChecked(tile);
                tile.state.start();

                LinkedList<MSTile> ns = tile.getNeighbors();
                for (MSTile n: ns) { n.mined = false; n.setState(new UnChecked(n)); }

                tile.setState(new Checked(tile));

            }
            public void start() { super.start(); }
            public void terminate() { super.terminate(); }
        }

        // State UnChecked

        private class UnChecked extends State<MSTile> {
            public UnChecked(MSTile t) {
                super(t);
                t.setText(" ");
            }
            public void start() {
              super.start();

              LinkedList<MSTile> ns = tile.getNeighbors();
              for (MSTile n: ns) {
                if (n.state instanceof UnInit) {
                  n.mined = Math.random() > .8;
                  n.setState(new UnChecked(n));
                }
              }
            }
            public void update(ActionEvent e) {
              tile.setState(new Checked(tile));
            }
            public void terminate() { super.terminate(); }
        }

        // State Checked

        private class Checked extends State<MSTile> {
            public Checked(MSTile t) {
                super(t);
            }
            public void start() {
              super.start();

              String label = "B";

              if (!tile.mined) {
                int bombs = 0;
                LinkedList<MSTile> ns = tile.getNeighbors();
                for (MSTile n : ns) { bombs += n.mined ? 1 : 0; }
                if (bombs == 0) {
                  for (MSTile n : ns) {
                    if (n.state instanceof UnChecked) { n.setState(new Checked(n)); }
                  }
                }

                label = Integer.toString(bombs);
              }

              tile.setText(label);

            }
            public void update(ActionEvent e) { }
            public void terminate() { super.terminate(); }
          }
        }

    public static void main(String[] args) {
        Game ms = new MineSweeper();
        ms.play();
    }
}
