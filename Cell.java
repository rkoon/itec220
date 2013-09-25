/**
 * Cell class for project 1
 * @author Ryan Koon
 * 
 */

import java.util.*;

public class Cell {
	
	/**
	 * Attributes for a cell
	 */
	private Random rand;
	private int current;
	private int previous;
	private int sickcount;
	private int deadcount;
	
	public Cell() {
		/**
		 * Constructor for class Cell
		 */
		
		rand = new Random();
		
		
		this.current = rand.nextInt(3);
		this.previous = rand.nextInt(3);
		this.sickcount = 0;
		this.deadcount = 0;	
	}
	
	/**
	 * getCurrent()
	 * @description returns the current value of a cell
	 * @return int
	 */
	public int getCurrent()
	{
		return this.current;
	}
	/**
	 * getPrevious()
	 * @description Returns previous
	 * @return int
	 */
	public int getPrevious() {
		return this.previous;
	}
	
	/**
	 * setCurrent()
	 * @param Double hperc-health percent- # of healthy cells in neighborhood
	 * double sperc-sick percent- # of sick cells in neighborhood.
	 * @description Sets the current value of a cell.
	 */
	
	public void setCurrent(double hperc, double sperc) {
		
		if(hperc >= 0.75) 
		{
			this.current = 0;
		}
		if(this.deadcount >= 10)
		{
			this.current = 0;
		}
		if(this.sickcount >= 5)
		{
			this.current = 2;
		}
		if(this.current == 0)
		{
			 if(sperc >= 0.26)
			{
				this.current = 1;
			}
		}
	}
	/**
	 * setPrevious()
	 * @description setter for this.previous.
	 * 
	 */
	public void setPrevious()
	{
		this.previous = this.current;
	}
	/**
	 * updateCounters
	 * @description Iterates sickcount and deadcount.
	 */
	
	public void updateCounters()
	{
		if(this.current == 1)
		{
			sickcount++;
		}
		else
			this.sickcount = 0;
		if(this.current == 2)
		{
			deadcount++;
		}
		else
			this.deadcount = 0;
	}
}






