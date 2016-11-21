 

import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class Game {
 
	private String host;
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public UUID getGameId() {
		return gameId;
	}
	public void setGameId(UUID gameId) {
		this.gameId = gameId;
	}
	private String level;
	private String gameName;
	private UUID gameId;
}
