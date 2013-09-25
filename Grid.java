/**
 * @author Ryan Koon (rkoon2)
 * Grid class for project 1.
 * 
 */


public class Grid {
	
	/**
	 * Properties of a Grid.
	 */
	
	public Cell[][] grid;
	
	private final int HEIGHT;
	
	private final int WIDTH;
	
	/**
	 * Constructor for Grid.
	 */
	public Grid()
	{
		HEIGHT = 50;
		WIDTH = 30;
	
		grid = new Cell[HEIGHT][WIDTH];
		
		
		
	}
	/**
	 * initialize()
	 * 
	 * @description Loads the grid array 
	 * 
	 */
	public void initialize()
	{
		for(int i = 0;i<=HEIGHT-1; i++)
			for(int j=0;j<=WIDTH-1; j++)
			{
				grid[i][j] = new Cell();
			}
	}
	
}
