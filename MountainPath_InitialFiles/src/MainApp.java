

public class MainApp {

	public static void main(String[] args) {
		
		/* 
		 * Main entry point of the application.
		 * 
		 * If no command line arguments are given when executing the program,
		 * the map specified in the file testMountains.dat will be used. The
		 * map used for the program can be changed by specifying an alternative
		 * map as a command line argument. If more than 1 arguments are given,
		 * however, the program will not execute.
		 * 
		 */
				
		MountainPath mp = null;
		
		if(args.length == 0) {
			
			// No command line arguments given. Use the map testMountains.dat.
			
			mp = new MountainPath("Colorado_480x480.dat");
		} else if (args.length == 1) {
			
			// One command line argument given. Use the map specified in that
			// argument
			
			mp = new MountainPath(args[0]);
		} else {
			
			// Too many command line arguemnts specified. Stop the execution
			
			System.err.println("Too many command line arguments");
			System.exit(0);
		}
		
		mp.startHike(); // Start the hike through the mountains
		
	}

}
