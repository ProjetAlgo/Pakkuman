package system;

public class Main {
	private static String filePath = "maze.txt";
	
	public static void main(String[] args) {
		Square[][] maze = MazeLoader.loadMaze(filePath);
		MazePrinter.printMaze(maze, "test.txt");
	}

}
