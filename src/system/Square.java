package system;
public class Square {
	private final static int EMPTY = 0;
	private final static int PAKKUMAN = 1;
	private final static int MONSTER = 2;
	private final static int CANDY = 3;
	private int content;
	private boolean northOpen, westOpen, southOpen, eastOpen;
	
	public Square () {
		setEmpty();
		setNorthClosed();
		setWestClosed();
		setSouthClosed();
		setEastClosed();
	}
	
	public void setEmpty() {
		this.content = EMPTY;
	}
	
	public void setPakkuman() {
		this.content = PAKKUMAN;
	}
	
	public void setMonster() {
		this.content = MONSTER;
	}
	
	public void setCandy() {
		this.content = CANDY;
	}
	
	public void setNorthOpen() {
		this.northOpen = true;
	}
	
	public void setWestOpen() {
		this.westOpen = true;
	}
	
	public void setSouthOpen() {
		this.southOpen = true;
	}
	
	public void setEastOpen() {
		this.eastOpen = true;
	}
	
	public void setNorthClosed() {
		this.northOpen = false;
	}
	
	public void setWestClosed() {
		this.westOpen = false;
	}
	
	public void setSouthClosed() {
		this.southOpen = false;
	}
	
	public void setEastClosed() {
		this.eastOpen = false;
	}
	
	public boolean isEmpty() {
		return content == EMPTY;
	}
	
	public boolean hasPakkuman() {
		return content == PAKKUMAN;
	}
	
	public boolean hasMonster() {
		return content == MONSTER;
	}
	
	public boolean hasCandy() {
		return content == CANDY;
	}
	
	public boolean isNorthOpen() {
		return northOpen;
	}

	public boolean isWestOpen() {
		return westOpen;
	}

	public boolean isSouthOpen() {
		return southOpen;
	}

	public boolean isEastOpen() {
		return eastOpen;
	}


}
