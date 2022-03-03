/**
 * @author Sarah Fleming
 * DE CS Assignment 7
 * Priority Message Queue
 * Last edited: 3/3/22
 */
public class Message {

	/**
	 * the priority (0-4) with which the message should be processed
	 */
	private int priority;
	/**
	 * the "time" (iteration) when the message is instantiated
	 */
	private int arrival;
	
	/**
	 * @param p sets the priority
	 * @param a sets the arrival time
	 * creates a message with a set priority and arrival time
	 */
	Message(int p, int a) {
		priority = p;
		arrival = a;
	}
	
	/**
	 * gets the priority of the message
	 * @return the priority of the message
	 */
	public int getPriority() {
		return priority;
	}
	
	/**
	 * gets the arrival time of the message
	 * @return the arrival time of the message
	 */
	public int getArrivalTime() {
		return arrival;
	}
}
