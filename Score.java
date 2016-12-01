import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Score {
	private String name;
	private int moves;
	private int time;

	public String getGameName() {
		return gameName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoves() {
		return moves;
	}

	public void setMoves(int moves) {
		this.moves = moves;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	private String gameName;
}
