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
	
	public static void process(int i) {
		Message m;
		if(!queue.get(0).isEmpty()) {
			m = queue.get(0).remove();
			System.out.println("Message processed. Priority: " + m.getPriority() + "Time: " + i + "Arrival: " + m.getArrivalTime());
		}
		else if(!queue.get(1).isEmpty()) {
			m = queue.get(1).remove();
			System.out.println("Message processed. Priority: " + m.getPriority() + "Time: " + i + "Arrival: " + m.getArrivalTime());
		}
		else if(!queue.get(2).isEmpty()) {
			m = queue.get(2).remove();
			System.out.println("Message processed. Priority: " + m.getPriority() + "Time: " + i + "Arrival: " + m.getArrivalTime());
		}
		else if(!queue.get(3).isEmpty()) {
			m = queue.get(3).remove();
			System.out.println("Message processed. Priority: " + m.getPriority() + "Time: " + i + "Arrival: " + m.getArrivalTime());
		}
		else if(!queue.get(4).isEmpty()) {
			m = queue.get(4).remove();
			System.out.println("Message processed. Priority: " + m.getPriority() + "Time: " + i + "Arrival: " + m.getArrivalTime());
		}				
	}

	public static void main(String[] args) {
		queue = new ArrayList<Queue<Message>>(5);
		
		for(int i = 0; i < 5; i++) {
			System.out.println("instantiated");
			queue.add(new LinkedList<Message>());
		}
		System.out.println("test");
		
		//"pre-loading" the ArrayList
		for (int i = 0; i < NUM_MESSAGES; i++) {
			int priority = (int)(Math.random() * NUM_PRIORITIES);
			queue.get(priority).add(new Message(priority, i));
		}
		
		//loading ArrayList with a test number of messages
		for(int i = 0; i < NUM_TESTS; i++) {
			int priority = (int)(Math.random() * NUM_PRIORITIES);
			queue.get(priority).add(new Message(priority, i));
			//remove and process
			if (i+1 % 4 == 0) {
				process(i);
			}
		}
		
		//another loop to finish processing what's left (done adding)
		int time = NUM_TESTS;
		while(!queue.get(0).isEmpty() || !queue.get(1).isEmpty() || !queue.get(2).isEmpty() || !queue.get(3).isEmpty() || !queue.get(4).isEmpty()){
			process(time);
			time++;
		}
	}
}
