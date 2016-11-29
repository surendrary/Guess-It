package com;

import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class Score {
	private String playerName;
	private int turns;
	private int time;
	
	public String getGameName() {
		return gameName;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getTurns() {
		return turns;
	}
	public void setTurns(int turns) {
		this.turns = turns;
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
