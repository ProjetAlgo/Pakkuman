
public class Maze {
	private Box[][] maze;

	public Maze(int y, int x) {
		this.maze = new Box[y][x];
	}
	
	public void getWidth() {
		System.out.println(maze.length);
	}
}
