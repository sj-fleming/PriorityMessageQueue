import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @author Sarah Fleming
 * DE CS Assignment 7
 * Priority Message Queue
 * Last edited: 2/28/22
 */
public class MessagePriorityQueue {
	
	static ArrayList<Queue<Message>> queue;
	static final int NUM_MESSAGES = 10;
	static final int NUM_PRIORITIES = 5;
	static final int NUM_TESTS = 100;

	public static void main(String[] args) {
		queue = new ArrayList<Queue<Message>>(5);
		
		for(Queue q : queue) {
			q = new LinkedList<>();
		}
		
		//"pre-loading" the ArrayList
		for (int i = 0; i < NUM_MESSAGES; i++) {
			int priority = (int)(Math.random() * NUM_PRIORITIES);
			queue.get(i).add(new Message(priority, i));
		}
		
		//loading ArrayList with a test number of messages
		for(int i = 0; i < NUM_TESTS; i++) {
			int priority = (int)(Math.random() * NUM_PRIORITIES);
			queue.get(priority).add(new Message(priority, i));
			//remove and process
			if (i+1 % 4 == 0) {
				
			}
		}
		
		//another loop to finish processing what's left (done adding)
	}
}
