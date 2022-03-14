import java.util.ArrayDeque;
import java.util.Deque;

public class DQueue {
	public static void main (String args[]) {
		Deque<Integer> deque = new ArrayDeque<Integer>();
		deque.remove();
		deque.add(1000);
		deque.addFirst(900);
		deque.addLast(800);
		deque.forEach(System.out::println);
		
		
		deque.remove();
		deque.removeFirst();
		deque.removeLast();
		
		deque.getFirst();
		deque.getLast();
		
		deque.add(123);
		deque.addFirst(123);
		deque.addLast(123);
		
		deque.removeFirstOccurrence(123);
		deque.removeFirstOccurrence(123);
		
	}
}
