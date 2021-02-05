import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.lang.Math;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class Cell extends Observable{
	int x;
	int y;
	boolean[] dir = new boolean[4];//directions up, down, left and right
	boolean visited;

	private final Rectangle rectangle;
	private final int cellSpace = 15;

	public enum Type{
		EMPTY,
		AGENTPATH,
		START,
		GOAL,
		WALL,
		FIRE;
	}

	public Cell(int x, int y, int cellSpace){
		this.x = x;
		this.y = y;
		//this.cellSpace = cellSpace;
		this.type = Type.EMPTY;

		private final Map<Type, Color> typeMap;
		
		dir[0] = false;
		dir[1] = false;
		dir[2] = false;
		dir[3] = false;

		typeMap = new HashMap();
		typeMap.put(Type.EMPTY, Color.WHITE);
		typeMap.put(Type.WALL, Color.BLACK);
		typeMap.put(Type.AGENTPATH, Color.GREEN);
		typeMap.put(Type.START, Color.BLUE);
		typeMap.put(Type.GOAL, Color.PURPLE);
		typeMap.put(Type.FIRE, Color.RED);

	}

	public void visit(){
		visited = true;
	}

	public Type getType(){
		return this.type;
	}

	public boolean isWall(){
		return (this.type == type.WALL);
	}

}



public class Maze extends JFrame {

	
	final int DIM = 50;
	Cell[][] myMaze= new Cell[][]();
	Cell start;
	Cell goal;
	int counter = 0;
	
	Random rand = new Random();
	
    
	
	public Maze(int dimension, int cellsize) {
		setTitle("Maze");
		setSize(640, 480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.DIM = dimension;
		this.myMaze = new Cell[dimension][dimension];
		Random rand = new Random();

		for (int row = 0; row < myMaze.length; row++) {
           		for (int col = 0; col < myMaze[row].length; col++) {
               			Cell cell = new Cell(col, row, cellsize);
						   cell.addObserver(this);
						   myMaze[col][row] = cell;
            }
        }
		
	}
	
	public void generateMaze(Cell currCell) {
		Random rand = new Random();
		currCell.visit();
		count++;


	}

//advancingFire

//checkNeighbor
public Cell checkNeighbor(){
	
}

 public void DFS(){

  }

  public void BFS(){

  }

  public void AStar(){

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
