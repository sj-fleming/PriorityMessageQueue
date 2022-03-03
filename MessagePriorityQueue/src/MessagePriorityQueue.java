import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @author Sarah Fleming
 * DE CS Assignment 7
 * Priority Message Queue
 * Last edited: 3/3/22
 */
public class MessagePriorityQueue {
	
	/*
	 * an ArrayList of Queues that has one queue at each index based on priority
	 */
	static ArrayList<Queue<Message>> queue;
	/*
	 * number of messages that are pre-loaded into the priority queue
	 */
	static final int NUM_MESSAGES = 10;
	/*
	 * number of priorities that the ArrayList can hold (size of ArrayList)
	 */
	static final int NUM_PRIORITIES = 5;
	/*
	 * number of test messages with random priorities that are added to the priority queue
	 */
	static final int NUM_TESTS = 100;
	/*
	 * the time from the computer when the program starts adding and processing messages
	 */
	static long startTime;
	/*
	 * the time from the computer when all the messages have been processed
	 */
	static long endTime;
	
	/**
	 * processes a message by removing the message with the top priority and printing the priority, time processed, iteration processed, and arrival time
	 * @param i the iteration when the method is called
	 */
	public static void process(int i) {
		Message m;
		long currentTime = System.currentTimeMillis();
		if(!queue.get(0).isEmpty()) {
			m = queue.get(0).remove();
			System.out.println("Message processed. Priority: " + m.getPriority() + " Time: " + (currentTime - startTime) + " Iteration: " + i + " Arrival: " + m.getArrivalTime());
		}
		else if(!queue.get(1).isEmpty()) {
			m = queue.get(1).remove();
			System.out.println("Message processed. Priority: " + m.getPriority() + " Time: " + (currentTime - startTime) + " Iteration: " + i + " Arrival: " + m.getArrivalTime());
		}
		else if(!queue.get(2).isEmpty()) {
			m = queue.get(2).remove();
			System.out.println("Message processed. Priority: " + m.getPriority() + " Time: " + (currentTime - startTime) + " Iteration: " + i + " Arrival: " + m.getArrivalTime());
		}
		else if(!queue.get(3).isEmpty()) {
			m = queue.get(3).remove();
			System.out.println("Message processed. Priority: " + m.getPriority() + " Time: " + (currentTime - startTime) + " Iteration: " + i + " Arrival: " + m.getArrivalTime());
		}
		else if(!queue.get(4).isEmpty()) {
			m = queue.get(4).remove();
			System.out.println("Message processed. Priority: " + m.getPriority() + " Time: " + (currentTime - startTime) + " Iteration: " + i + " Arrival: " + m.getArrivalTime());
		}				
	}

	public static void main(String[] args) {
		queue = new ArrayList<Queue<Message>>(5);
		
		for(int i = 0; i < 5; i++) {
			queue.add(new LinkedList<Message>());
		}
		
		//"pre-loading" the ArrayList
		for (int i = 0; i < NUM_MESSAGES; i++) {
			int priority = (int)(Math.random() * NUM_PRIORITIES);
			queue.get(priority).add(new Message(priority, i));
		}
		
		//loading ArrayList with a test number of messages
		startTime = System.currentTimeMillis();
		for(int i = 0; i < NUM_TESTS; i++) {
			int priority = (int)(Math.random() * NUM_PRIORITIES);
			queue.get(priority).add(new Message(priority, i + NUM_MESSAGES));
			//remove and process every four "messages" (iterations)
			if ((i+1) % 4 == 0) {
				process(i);
			}
		}
		
		//another loop to finish processing what's left (done adding)
		int time = NUM_TESTS;
		while(!queue.get(0).isEmpty() || !queue.get(1).isEmpty() || !queue.get(2).isEmpty() || !queue.get(3).isEmpty() || !queue.get(4).isEmpty()){
			//4 seconds to process each message
			process(time*4);
			time++;
		}
		
		//calculates the total run time
		endTime = System.currentTimeMillis();
		System.out.println("Total run time: " + (endTime - startTime));
	}
}
