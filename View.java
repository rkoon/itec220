/**
 * View - handles all text that will be displayed
 * @author Ryan K. (rkoon2)
 *
 */

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JPanel{
	Grid grid1;
	
	private final int HEIGHT;
	private final int WIDTH;
	
	
	
	
	public View(Grid _grid)
	{
		/**
		 * Constructor for view
		 */
		grid1= _grid;
		
		HEIGHT = 50;
		WIDTH = 30;
		
	}
	
	/**
	 * Draws rectangles for cells
	 * 
	 * AILVE = GREEN
	 * SICK = ORANGE
	 * DEAD = MAROON
	 * 
	 */
	
	public void paintComponent(Graphics g)
	{
		grid1.initialize();
		super.paintComponent(g);
		for(int i =0;i<=HEIGHT-1;i++)
		{
			for(int j=0;j<=WIDTH-1;j++)
			{
				g.drawRect(15+15*j, 15+15*i, 30, 30);
				if(grid1.grid[i][j].getCurrent() == 0)
				{
					g.setColor(Color.green);
					g.fillRect(15+15*j, 15+15*i, 30, 30);
					
				}
				else if(grid1.grid[i][j].getCurrent() == 1)
				{
					g.setColor(Color.orange);
					g.fillRect(15+15*j, 15+15*i, 30, 30);
					
				}
				else if(grid1.grid[i][j].getCurrent() == 2)
				{
					g.setColor(new Color(120,1,41));
					g.fillRect(15+15*j, 15+15*i, 30, 30);
					
				}
			}
		}
	}
	
	public void printGen(Cell[][] grid1)
	{
		for(int i=0;i<=HEIGHT-1;i++)
		{
			System.out.println();
			for(int j=0;j<=WIDTH-1;j++)
			{
				System.out.print(grid1[i][j].getCurrent());
			}
		}
	}
}
