package system;

public class Main {
	private static String filePath = "maze.txt";
	
	public static void main(String[] args) {
		Square[][] maze = MazeLoader.loadMaze(filePath);
		// test
		for (int i=0; i<maze.length; i++) {
			for (int j=0; j<maze[i].length; j++) {
				if (maze[i][j].getContent() == 1) {
					System.out.println(j + " " + i + " pakkuman");
				}
				if (maze[i][j].getContent() == 2) {
					System.out.println(j + " " + i + " monstre");
				}
				if (maze[i][j].getContent() == 3) {
					System.out.println(j + " " + i + " bonbon");
				}
			}
		}
		// test
	}

}
