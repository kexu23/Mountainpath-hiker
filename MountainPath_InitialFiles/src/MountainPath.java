

/**
 * This class contains the logic for moving a mountaineer through a
 * mountainous region. Essentially, the method startHike() will
 * simulate the mountaineer moving through the region, by always
 * having the mountaineer choose a path forward, such that the
 * absolute change in elevation is the smallest possible, given the
 * different alternatives
 * 
 * @author Kristian Nybom
 *
 */
public class MountainPath {

	private Topography topo;     // The topography of the mountainous region 
	private Mountaineer mount;   // The mountaineer moving through the mountainous region
	
	public MountainPath(String filename) {
		
		/*
		 * DO NOT MODIFY THE CODE IN THIS CONSTRUCTOR
		 */
		
		topo = new Topography(filename);  // Create Topography object
		mount = new Mountaineer();        // Create the mountaineer
		
		// Set the starting location of the mountaineer
		mount.setStartingPoisition(topo.findLowestStartingPoint());
		
		// Display the current location of the mountaineer.
		System.out.println(mount);
	}

	/**
	 * TODO: Implement this method
	 * 
	 * This method should control the movement of the mountaineer
	 * through the mountainous region. When the mountaineer
	 * reaches the east end of the map, the message already
	 * implemented in this method should be displayed.
	 */
	public void startHike() {
		int direction = scanNeighbours();

		boolean Climb = move(direction);

		while (Climb) {
			direction = scanNeighbours();
			Climb = move(direction);
		}



		System.out.print("Mountaineer reached the end of the map. Total elevation change: " + mount.getElevationChange());
	}
	
	/**
	 * TODO: Implement this method
	 * 
	 * Scans neighbouring cells and returns an integer, representing the direction to move in.
	 * The direction is chosen as the smallest absolute change in elevation when moving in that
	 * direction, based on the mountaineers current location. Note: this method only determines
	 * the direction to move in, but it should not move the mountaineer anywhere.
	 * 
	 * @return An integer representing the direction to move in. Value 0 = NE, 1 = E, and 2 = SE.
	 * Should the return value be anything else, it means that the mountaineer has reached the
	 * border of the map
	 */
	public int scanNeighbours() {
		Cell location = mount.getLocation();
		int row = location.getRow();
		int col = location.getCol();
		int elevation = location.getElevation();

		if (topo.getCell(row, col + 1) == topo.getCell(row, 480)) {
			return -1;
		}
		int E = topo.getCell(row, col + 1).getElevation();
		int NE = topo.getCell(row - 1, col + 1).getElevation();
		int SE = topo.getCell(row + 1, col + 1).getElevation();

		int east = E - elevation;
		if (east < 0) {
			east *= -1;
		}
		int north_east = NE - elevation;
		if (north_east < 0) {
			north_east *= -1;
		}
		int south_east = SE - elevation;
		if (south_east < 0) {
			south_east *= -1;
		}
		if (north_east == east && east == south_east) {
			return 2;
		}
		if (north_east == east && east < south_east) {
			return 1;
		}
		if (north_east == south_east && east > south_east) {
			return 2;
		}
		if (south_east == east && south_east < north_east) {
			return 2;
		}
		if (south_east < east && south_east < north_east) {
			return 2;
		}
		if (east < north_east && east < south_east) {
			return 1;
		}
		if (north_east < east && north_east < south_east) {
			return 0;
		}
		return -1;
	}
	
	/**
	 * TODO: Implement this method
	 * 
	 * Moves the mountaineer in the specified direction
	 * @param direction The value of the parameter corresponds to the return value of the method 
	 * scanNeighbours, i.e. value 0 = NE, 1 = E, and 2 = SE.
	 * @return true on successful movement, false at the end of map
	 */
	public boolean move(int direction) {
		Cell currentCell = mount.getLocation();
		int cellRow = currentCell.getRow();
		int cellCol = currentCell.getCol();

		if (direction == 0){
			mount.moveToCell(topo.getCell(cellRow-1,cellCol+1));
			return true;
		}
		if (direction == 1){
			mount.moveToCell(topo.getCell(cellRow,cellCol+1));
			return true;
		}
		if (direction == 2){
			mount.moveToCell(topo.getCell(cellRow+1,cellCol+1));
			return true;
		}
		return false;
	}
}
