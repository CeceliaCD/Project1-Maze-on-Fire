import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Maze extends JFrame {
	
	final int DIM = 10;
	int[][] myMaze = new int[DIM][DIM];
	
	Random rand = new Random();
	
    
	
	public Maze() {
		setTitle("Maze");
		setSize(640, 480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void populate(int [][] myMaze) {
		for (int row = 0; row < myMaze.length; row++) {
            for (int col = 0; col < myMaze[row].length; col++) {
                if (rand.nextDouble() < 0.5) {
                    myMaze[row][col] = 1;
                } else {
                    myMaze[row][col] = 0;
                }
            }
        }
		
		int lastItem = myMaze[myMaze.length - 1][myMaze[myMaze.length - 1].length - 1];
		lastItem = 2;
	}
	
	
  @Override
  public void paint(Graphics g)
  {
	  g.translate(50, 50);
	  
	  for(int row = 0; row < myMaze.length; row++) {
		  for(int col = 0; col < myMaze[0].length; col++) {
			  Color color;
			  
			  switch(myMaze[row][col]) {
			  	case 1: color = Color.BLACK; break;
			  	case 2: color = Color.RED; break;
			  	default: color = Color.WHITE;
			  }
			  g.setColor(color);
			  g.fillRect(30 * col, 30 * row, 30, 30);
			  g.setColor(Color.BLACK);
			  g.drawRect(30 * col, 30 * row, 30, 30);
		  }
	  }
  }
  		public static void main(String[] args) {
  			SwingUtilities.invokeLater(new Runnable() {
  				
  				@Override
  				public void run() {
  					Maze maze = new Maze();
  					maze.setVisible(true);
  				}
  				
  			});
  		}
}
