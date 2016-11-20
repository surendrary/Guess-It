/**
 * Write a description of class Command here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public interface Command {
 
	public abstract void execute();
	public abstract void setReceiver(Receiver target);
}
 
