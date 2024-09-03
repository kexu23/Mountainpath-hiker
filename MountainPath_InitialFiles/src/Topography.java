
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 * This class represents the topography of a geographical area. It consists
 * of a number of cells that are ordered in a matrix-like manner. Each cell
 * contains information about the elevation at that particular location
 * 
 * @author Kristian Nybom
 *
 */
public class Topography {

	private Cell [][] map;  // The cells in the map. Indexing according to map[row][column]
	private int rows;       // The total number of rows in the map
	private int cols;       // The total number of columns in the map
	
	/*
	 * The constant OUTSIDE_BORDERS should be used by the method
	 * getNeighbouringElevations for informing the invoker that
	 * the elevation of a certain cell is not available, because 
	 * that cell is outside the borders of the map 
	 */
	public final static int OUTSIDE_BORDERS = Integer.MAX_VALUE;  
	
	public Topography(String filename) {
		
		/*
		 * DO NOT MODIFY THE CONSTRUCTOR
		 */
		loadMap(filename);
	}

	private void loadMap(String filename) {
		
		/*
		 * DO NOT MODIFY THIS METHOD
		 */
		try {
			File myFile = new File(filename);
			FileReader fileReader = new FileReader(myFile);
			
			BufferedReader reader = new BufferedReader(fileReader);
			
			boolean mapInitialized = false;
			String line = null;
			int row = 0;
			while ((line = reader.readLine()) != null) {
				if(!mapInitialized) {
					String[] size = line.split(" ");
					rows = Integer.parseInt(size[0]);
					cols = Integer.parseInt(size[1]);
					map = new Cell[rows][];
					for(int i=0;i<rows;i++) {
						map[i] = new Cell[cols];
					}
					mapInitialized = true;
				} else {
					String[] elevs = line.split("\t");
					int col = 0;
					for(String e : elevs) {
						
						int elev = Integer.parseInt(e);
						map[row][col] = new Cell(row, col, elev);
						col++;
					}
					row++;
				}
				
			}
			reader.close();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * TODO: implement the method
	 * 
	 * The method should return the cell with the location
	 * specified in the parameters row and col.
	 * 
	 * Keep in mind that this method can be invoked with
	 * parameters that are outside the borders of the map.
	 * Should this happen, the method should return null.
	 * 
	 * @param row the row of the Cell to get
	 * @param col the column of the Cell to get
	 * 
	 * @return the Cell at indices row and col, or null
	 * if outside the borders of the map
	 */	
	public Cell getCell(int row, int col) {
		if(col > map.length - 1 || row > map[0].length - 1 || row < 0 || col < 0) {
			return null;
		}
		else {
			return (map[row][col]);
		}
	}
	
	/** 
	 * TODO: implement the method
	 * 
	 * If the mountaineer is in cell m, with neighbouring
	 * cells a, b, c, as follows:
	 * 
	 *     a
	 *   / 
	 * m - b
	 *   \
	 *     c
	 *   
	 * then this method should return an integer array arr with 
	 * values set like this
	 * 
	 * arr[0] = elevation of cell a
	 * arr[1] = elevation of cell b
	 * arr[2] = elevation of cell c
	 * 
	 * NOTE: Should any of the cells a, b, or c not exist
	 * (because they are outside the borders of the map), then
	 * the value stored at the corresponding array index should
	 * be set to the value of the constant OUTSIDE_BORDERS.
	 * 
	 * @param row the origin row of the Cell from where to scan
	 * @param col the origin column of the Cell from where to scan
	 * 
	 * @return an integer array of length 3. The value at index 0 
	 * should be equal to the elevation of the cell to NE. The value
	 * at index 1 should be equal to the elevation of the cell to E.
	 * The value at index 2 should be equal to the elevation of the
	 * cell to SE. If any of these cells do not exist, the corresponding
	 * values in the return array should be equal to OUTSIDE_BORDERS.
	 * 
	 */
	public int[] getNeighbouringElevations(int row, int col) {
		int arr[] = new int[3];

		if (getCell(row-1, col+1) == getCell(row-1, 480)) {
			arr[0] = OUTSIDE_BORDERS;
		}
		else {
			arr[0] = getCell(row-1, col+1).getElevation();
		}
		if(getCell(row, col+1) == getCell(row, 480)) {
			arr[1] = OUTSIDE_BORDERS;
		}
		else {
			arr[1] = getCell(row, col+1).getElevation();
		}
		if (getCell(row+1, col+1) == getCell(row+1, 480)) {
			arr[2] = OUTSIDE_BORDERS;
		}
		else {
			arr[2] = getCell(row+1, col+1).getElevation();
		}
		return arr;
	}
	
	/**
	 * TODO: implement the method
	 * 
	 * The method should return the cell in column 0 which 
	 * has the lowest elevation
	 * 
	 * @return The cell in column 0 which has the lowest elevation
	 */
	public Cell findLowestStartingPoint() {

		Cell lowestCell = map[0][0];

		for(int i = 0; i < map[0].length; i++) {
			if(map[i][0].getElevation() < lowestCell.getElevation()) {
				lowestCell = map[i][0];
			}
		}

		return lowestCell;
	}

}
