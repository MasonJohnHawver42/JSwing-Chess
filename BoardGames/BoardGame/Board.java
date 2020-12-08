package BoardGame;

import BoardGame.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

abstract public class Board<G extends Game> extends JPanel {

   public Board(G g, int rows, int cols) {
       game = g;

       setLayout(new GridLayout(rows, cols));

       this.tiles = new Tile[rows][cols];

       for(int i = 0; i < rows; i++) {
          for(int j = 0; j < cols; j++) {
             this.tiles[i][j] = initTile(i, j);
             add(this.tiles[i][j]);
          }
       }
   }

   abstract protected Tile initTile(int i, int j);

  //getters

  public G getGame() { return game; }
  public Tile getTile(int i, int j) { return tiles[i][j]; }
  public boolean valid(int i, int j) { return (0 <= i && i < tiles.length) && (0 <= j && j < tiles[0].length); }

  protected G game;
  public Tile[][] tiles;
}
