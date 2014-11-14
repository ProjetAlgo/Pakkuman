package system;
public class Square {
	public final static int EMPTY = 0;
	public final static int PAKKUMAN = 1;
	public final static int MONSTER = 2;
	public final static int CANDY = 3;
	private int content;
	private boolean northOpen, westOpen, southOpen, eastOpen;
	
	public Square () {
		setContent(EMPTY);
		setNorthOpen(false);
		setWestOpen(false);
		setSouthOpen(false);
		setEastOpen(false);
	}
	
	public int getContent() {
		return content;
	}
	public void setContent(int content) {
		this.content = content;
	}
	public boolean isNorthOpen() {
		return northOpen;
	}
	public void setNorthOpen(boolean northOpen) {
		this.northOpen = northOpen;
	}
	public boolean isWestOpen() {
		return westOpen;
	}
	public void setWestOpen(boolean westOpen) {
		this.westOpen = westOpen;
	}
	public boolean isSouthOpen() {
		return southOpen;
	}
	public void setSouthOpen(boolean southOpen) {
		this.southOpen = southOpen;
	}
	public boolean isEastOpen() {
		return eastOpen;
	}
	public void setEastOpen(boolean eastOpen) {
		this.eastOpen = eastOpen;
	}
}
