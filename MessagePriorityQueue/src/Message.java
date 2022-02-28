/*
 * @author Sarah Fleming
 * DE CS Assignment 7
 * Priority Message Queue
 * Last edited: 2/28/22
 */
public class Message {

	private int priority;
	private int arrival;
	
	Message(int p, int a) {
		priority = p;
		arrival = a;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public int getArrivalTime() {
		return arrival;
	}
}
