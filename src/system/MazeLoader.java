package system;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MazeLoader {
	private static List<String> dataLines;
	private static List<String> mazeLines;
	private static int mazeHeight;
	private static int mazeWidth;
	private static Square[][] maze;
	
	public static Square[][] loadMaze(String filePath) {
		convertFile(filePath);
		maze = new Square[mazeHeight][mazeWidth];
		for (int i=0; i<mazeHeight; i++) {
			for (int j=0; j<mazeWidth; j++) {
				maze[i][j] = new Square();
			}
		}
		setSquareOpenings();
		setSquareContents();
		return maze;
	}

	private static void convertFile(String filePath) {
		List<String> lines = new ArrayList<String>();
		Scanner reader = null;
		try {
			reader = new Scanner(new File(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(reader.hasNextLine()) {
			String line = reader.nextLine();
			lines.add(line);
		}
		mazeHeight = getMazeHeight(lines);
		mazeWidth = getMazeWidth(lines);
		dataLines = getDataLines(lines);
		mazeLines = getMazeLines(lines);
	}
	
	private static int getMazeHeight(List<String> lines) {
		return Integer.valueOf(String.valueOf(lines.get(0).charAt(12)));
	}
	
	private static int getMazeWidth(List<String> lines) {
		return Integer.valueOf(String.valueOf(lines.get(0).charAt(19)));
	}
	
	private static List<String> getDataLines(List<String> lines) {
		dataLines = new ArrayList<String>();
		for (int i=(mazeHeight*2)+2; i<lines.size(); i++) {
			dataLines.add(lines.get(i));
		}
		return dataLines;
	}
	
	private static List<String> getMazeLines(List<String> lines) {
		mazeLines = new ArrayList<String>();
		for (int i=1; i<=(mazeHeight*2)+1; i++) {
			mazeLines.add(lines.get(i));
		}
		return mazeLines;
	}
	
	private static void setSquareOpenings() {
		for (int i=0; i<mazeLines.size(); i++) {
			for (int j=0; j<mazeLines.get(i).length(); j++) {
				if (String.valueOf(mazeLines.get(i).charAt(j)).equals(" ")) {
					if (i%2 == 0) { // ouvertures N-S
						int xIndex = (j-(j%4))/4;
						int yIndexN = (i/2)-1;
						int yIndexS = i/2;
						if (yIndexN >= 0) {
							maze[yIndexN][xIndex].setSouthOpen();
						}
						if (yIndexS < mazeHeight) {
							maze[yIndexS][xIndex].setNorthOpen();
						}
					}
					else { // ouvertures W-E
						if (j%4 == 0) { // est-on entre deux cases
							int xIndexW = (j/4)-1;
							int xIndexE = j/4;
							int yIndex = (i-1)/2;
							if (xIndexW >= 0) {
								maze[yIndex][xIndexW].setEastOpen();
							}
							if (xIndexE < mazeWidth) {
								maze[yIndex][xIndexE].setWestOpen();
							}
						}
					}
				}
			}
		}
	}
	
	private static void setSquareContents() {
		Integer[] pakkumanLoc = getPakkumanLocation();
		List<Integer[]> monsterLocs = getMonsterLocations();
		List<Integer[]> candyLocs = getCandyLocations();
		maze[pakkumanLoc[0]][pakkumanLoc[1]].setPakkuman();
		for (Integer[] monsterLoc : monsterLocs) {
			maze[monsterLoc[0]][monsterLoc[1]].setMonster();
		}
		for (Integer[] candyLoc : candyLocs) {
			maze[candyLoc[0]][candyLoc[1]].setCandy();
		}
	}
	
	private static Integer[] getPakkumanLocation() {
		int y = Integer.valueOf(String.valueOf(dataLines.get(4).charAt(12)));
		int x = Integer.valueOf(String.valueOf(dataLines.get(4).charAt(14)));
		Integer[] pakkumanLoc = {y,x};
		return pakkumanLoc;
	}
	
	private static List<Integer[]> getMonsterLocations() {
		int monsterAmount = getMonsterAmount();
		List<Integer[]> monsterLocs = new ArrayList<Integer[]>();
		int step = 0;
		for (int i=0; i<monsterAmount; i++) {
			int y = Integer.valueOf(String.valueOf(dataLines.get(5).charAt(12+step)));
			int x = Integer.valueOf(String.valueOf(dataLines.get(5).charAt(14+step)));
			Integer[] monsterLoc = {y,x};
			monsterLocs.add(monsterLoc);
			step = step + 6;
		}
		return monsterLocs;
	}
	
	private static int getMonsterAmount() {
		int monsterAmount = Integer.valueOf(String.valueOf(dataLines.get(1).charAt(11)));
		return monsterAmount;
	}
	
	private static List<Integer[]> getCandyLocations() {
		int candyAmount = getCandyAmount();
		List<Integer[]> candyLocs = new ArrayList<Integer[]>();
		int step = 0;
		for (int i=0; i<candyAmount; i++) {
			int y = Integer.valueOf(String.valueOf(dataLines.get(6).charAt(11+step)));
			int x = Integer.valueOf(String.valueOf(dataLines.get(6).charAt(13+step)));
			Integer[] candyLoc = {y,x};
			candyLocs.add(candyLoc);
			step = step + 6;
		}
		return candyLocs;
	}
	
	private static int getCandyAmount() {
		int candyAmount = Integer.valueOf(String.valueOf(dataLines.get(2).charAt(10)));
		return candyAmount;
	}
	
}
