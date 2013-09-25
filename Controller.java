/**
 * Controller for project - contains game loop.
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

public class Controller {
	Grid gridref;
	View view;
	
	private double scount;
	private double hcount;
	private double ncount;
	
	private double hperc;
	private double sperc;
	public Controller()
	{
		gridref = new Grid();
		view = new View(gridref);
		
		scount = 0.0;
		hcount = 0.0;
		ncount = 0.0;
		
		sperc = 0;
		hperc = 0;	
	}
	
	/**
	 * gameLoop()
	 * @description Contains the primary functions
	 */
	
	
	public void gameLoop() throws InterruptedException
	{
		/*
		 * initialize
		 * navigate to 1st cell
		 * check its neighbors
		 * update previous
		 * set current based on hperc/sperc
		 * update counters
		 * repeat
		 */
		gridref.initialize();
		JFrame frame = new JFrame();
		frame.setTitle("The Game of Life");
		frame.setSize(650, 820);
		frame.addWindowListener(new WindowAdapter() {
		  public void windowClosing(WindowEvent e) {
		    System.exit(0);
		  }
		});
		Container contentPane = frame.getContentPane();
		    
		//gens -> generation iterator
		for(int gens=0; gens<=1000; gens++)
			{
				for(int i=0;i<gridref.grid.length;i++)
				{
					for(int j=0;j<gridref.grid[i].length;j++)
					{
						
						if(i-1>=0 && j-1>=0) 
						{
							ncount++;
							if((gridref.grid[i-1][j-1].getCurrent()) == 1 || (gridref.grid[i-1][j-1].getCurrent()) == 2)
								this.scount++;
							if(gridref.grid[i-1][j-1].getCurrent() == 0)
							{
								this.hcount++;
							}
								
						}
						if(i-1>=0) 
						{
							ncount++;
							if((gridref.grid[i-1][j].getCurrent()) == 1 || gridref.grid[i-1][j].getCurrent() == 2)
								this.scount++;
							if(gridref.grid[i-1][j].getCurrent() == 0)
							{
								this.hcount++;
							}
								
						}
						if(i-1>=0 && j+1<=gridref.grid[i].length-1) 
						{
							ncount++;
							if((gridref.grid[i-1][j+1].getCurrent()) == 1 || (gridref.grid[i-1][j+1].getCurrent()) == 2)
								this.scount++;
							if(gridref.grid[i-1][j+1].getCurrent() == 0)
							{
								this.hcount++;
							}
								
						}
						if(i+1<=gridref.grid[i].length-1) 
						{
							ncount++;
							if((gridref.grid[i+1][j].getCurrent()) == 1 || (gridref.grid[i+1][j].getCurrent()) == 2)
								this.scount++;
							if(gridref.grid[i+1][j].getCurrent() == 0)
							{
								this.hcount++;
							}
								
						}
						if(i+1<=gridref.grid[i].length-1 && j-1>=0) 
						{
							ncount++;
							if((gridref.grid[i+1][j-1].getCurrent()) == 1 || (gridref.grid[i+1][j-1].getCurrent()) == 2)
								this.scount++;
							if(gridref.grid[i+1][j-1].getCurrent() == 0)
							{
								this.hcount++;
							}
								
						}
						if(i+1<=gridref.grid[i].length-1 && j+1<=gridref.grid[i].length-1) 
						{
							ncount++;
							if((gridref.grid[i+1][j+1].getCurrent()) == 1 || (gridref.grid[i+1][j+1].getCurrent()) == 2)
								this.scount++;
							if(gridref.grid[i+1][j+1].getCurrent() == 0)
							{
								this.hcount++;
							}
								
						}
						if(j-1>=0) 
						{
							ncount++;
							if((gridref.grid[i][j-1].getCurrent()) == 1 || (gridref.grid[i][j-1].getCurrent()) == 2)
								this.scount++;
							if(gridref.grid[i][j-1].getCurrent() == 0)
							{
								this.hcount++;
							}
								
						}
						if(j+1<=gridref.grid[i].length-1) 
						{
							ncount++;
							if((gridref.grid[i][j+1].getCurrent()) == 1 || gridref.grid[i][j+1].getCurrent() == 2)
								this.scount++;
							if(gridref.grid[i][j+1].getCurrent() == 0)
							{
								this.hcount++;
							}
								
						}
						this.sperc = (scount/ncount);
						this.hperc = (hcount/ncount);
						gridref.grid[i][j].setPrevious();
						gridref.grid[i][j].setCurrent(this.hperc,this.sperc);
						gridref.grid[i][j].updateCounters();
						
						
					}
				}
				view.printGen(gridref.grid);
				contentPane = frame.getContentPane();
				contentPane.add(new View(gridref));
				frame.show();
				Thread.sleep(75);
				
			}

		
	}
}
	

