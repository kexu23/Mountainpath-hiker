

/**
 * This class represents a person moving through a mountainous region.
 *  
 * @author Kristian Nybom
 *
 */
public class Mountaineer {

	private Cell location;       // The current location of the mountaineer
	private int elevationChange; // the total elevationChange so far along the chosen path
		
	
	/**
	 * Sets the starting location of the mountaineer.
	 * @param cell the starting location of the mountaineer
	 */
	public void setStartingPoisition(Cell cell) {
		location = cell;
		elevationChange = 0;
	}
	
	/**
	 * TODO: Implement this method
	 * 
	 * When invoked, this method should move the mountaineer from its
	 * current location to the location given by the parameter cell. The 
	 * method should also update the elevationChange according to the task
	 * description
	 * 
	 * @param cell the cell the mountaineer is moving to
	 */
	public void moveToCell(Cell cell) {
		elevationChange = Math.abs(cell.getElevation() - location.getElevation()) + elevationChange;
		location = cell;
		System.out.println(toString());
	}

	
	/**
	 * Returns the current location of the mountaineer
	 * @return the current location of the mountaineer
	 */
	public Cell getLocation() {
		return location;
	}
	
	/**
	 * Returns the total elevation change the the mountaineer
	 * has produced while following the chosen path
	 * @return the total elevation change so far
	 */
	public int getElevationChange() {
		return elevationChange;
	}
	
	/** 
	 * Use this method for displaying the current location of the mountaineer.
	 * 
	 * DO NOT MODIFY THE CODE IN THIS METHOD!
	 */
	@Override
	public String toString() {
		return "Currently at [" + location.getRow() + ", " + location.getCol() + "] at elevation " + location.getElevation() + ". Elevation change so far: " + elevationChange;
	}
}
