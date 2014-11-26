package system;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MazePrinter {
	
	public static void printMaze(Square[][] maze, String filePath) {
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filePath)));
			for (int i=0; i<maze.length; i++) {
				for (int j=0; j<maze[i].length; j++) { // dessine le nord
					if (maze[i][j].isNorthOpen()) {
						out.print("+   ");
					}
					else {
						out.print("+---");
					}
				}
				out.println("+");
				for (int j=0; j<maze[i].length; j++) { // dessine l'ouest et le contenu
					if (maze[i][j].isWestOpen()) {
						out.print(" ");
					}
					else {
						out.print("|");
					}
					if (maze[i][j].hasPakkuman()) {
						out.print(" P ");
					}
					else if (maze[i][j].hasMonster()) {
						out.print(" M ");
					}
					else if (maze[i][j].hasCandy()) {
						out.print(" C ");
					}
					else {
						out.print("   ");
					}
				}
				out.println("|");
			}
			for (int i=0; i<(maze[0].length)-1; i++) {
				out.print("+---");
			}
			out.print("+   +");
		    out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
