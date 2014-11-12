import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MazeLoader {
	
	@SuppressWarnings("unused")
	public static Maze loadMaze(String filePath) {
		ArrayList<String> lines = convertFile(filePath);
		int mazeHeight = getMazeHeigth(lines);
		int mazeWidth = getMazeWidth(lines);
		Integer[] pakkumanLoc = getPakkumanLocation(lines, mazeHeight);
		List<Integer[]> monsterLocs = getMonsterLocations(lines, mazeHeight);
		List<Integer[]> candyLocs = getCandyLocations(lines, mazeHeight);
		for (int y=1; y < (mazeHeight*2)+1; y++) {
			String line = lines.get(y);
			for (int x=0; x < line.length(); x++) {
				char ch = line.charAt(x);
			}
		}
		Maze maze = new Maze(mazeHeight, mazeWidth);
		
		return maze;
	}
	
	@SuppressWarnings("resource")
	private static ArrayList<String> convertFile(String filePath) {
		ArrayList<String> lines = new ArrayList<String>();
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
		return lines;
	}
	
	private static int getMazeHeigth(ArrayList<String> lines) {
		return Integer.valueOf(String.valueOf(lines.get(0).charAt(12)));
	}
	
	private static int getMazeWidth(ArrayList<String> lines) {
		return Integer.valueOf(String.valueOf(lines.get(0).charAt(19)));
	}
	
	private static int getMonsterAmount(ArrayList<String> lines, int mazeHeight) {
		int monsterAmount = Integer.valueOf(String.valueOf(lines.get((mazeHeight*2)+3).charAt(11)));
		return monsterAmount;
	}
	
	private static int getCandyAmount(ArrayList<String> lines, int mazeHeight) {
		int candyAmount = Integer.valueOf(String.valueOf(lines.get((mazeHeight*2)+4).charAt(10)));
		return candyAmount;
	}
	
	private static Integer[] getPakkumanLocation(ArrayList<String> lines, int mazeHeight) {
		int y = Integer.valueOf(String.valueOf(lines.get((mazeHeight*2)+6).charAt(12)));
		int x = Integer.valueOf(String.valueOf(lines.get((mazeHeight*2)+6).charAt(14)));
		Integer[] pakkumanLoc = {y,x};
		return pakkumanLoc;
	}
	
	private static List<Integer[]> getMonsterLocations(ArrayList<String> lines, int mazeHeight) {
		int monsterAmount = getMonsterAmount(lines, mazeHeight);
		List<Integer[]> monsterLocs = new ArrayList<Integer[]>();
		int step = 0;
		for (int i=0; i<monsterAmount; i++) {
			int y = Integer.valueOf(String.valueOf(lines.get((mazeHeight*2)+7).charAt(12+step)));
			int x = Integer.valueOf(String.valueOf(lines.get((mazeHeight*2)+7).charAt(14+step)));
			Integer[] monsterLoc = {y,x};
			monsterLocs.add(monsterLoc);
			step = step + 6;
		}
		return monsterLocs;
	}
	
	private static List<Integer[]> getCandyLocations(ArrayList<String> lines, int mazeHeight) {
		int candyAmount = getCandyAmount(lines, mazeHeight);
		List<Integer[]> candyLocs = new ArrayList<Integer[]>();
		int step = 0;
		for (int i=0; i<candyAmount; i++) {
			int y = Integer.valueOf(String.valueOf(lines.get((mazeHeight*2)+8).charAt(11+step)));
			int x = Integer.valueOf(String.valueOf(lines.get((mazeHeight*2)+8).charAt(13+step)));
			Integer[] candyLoc = {y,x};
			candyLocs.add(candyLoc);
			step = step + 6;
		}
		return candyLocs;
	}
	
}
