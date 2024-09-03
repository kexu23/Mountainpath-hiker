

/**
 * An immutable class that represents a location cell in a mountainous region.
 * The location cell has coordinates, an elevation above sea level, and getters
 * to access these.
 * 
 * DO NOT MODIFY THIS CLASS!
 * 
 * @author Kristian Nybom
 * 
 */
public class Cell {

	// Instance variables
	
	private int row;
	private int col;
	private int elevation;
	
	// Constructor
	
	public Cell(int r, int c, int elev) {
		row = r;
		col = c;
		elevation = elev;
	}

	// Getters
	
	/** Returns the row of the cell.
	 * 
	 * @return the row of the cell
	 */
	public int getRow() {
		return row;
	}

	/** Returns the column of the cell.
	 * 
	 * @return the column of the cell
	 */
	public int getCol() {
		return col;
	}

	/** Returns the elevation of the cell.
	 * 
	 * @return the elevation of the cell
	 */
	public int getElevation() {
		return elevation;
	}

	@Override
	public String toString() {
		return "Cell [" + row + ", " + col + "]: elevation " + elevation;
	}
}
