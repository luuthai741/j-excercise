import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriotyQ {
	public static void main(String arg[]) 
	{		
		Customer customer1 = new Customer("LQT", 123);
		Customer customer2 = new Customer("ABC", 1);
		Customer customer3 = new Customer("98asdasd",99);
		Customer customer4 = new Customer("Muda", 1443);
		Customer customer5 = new Customer("Hello guys", 7822);
		Customer customer6 = new Customer("Dark Burh Lmao", 1233);
		
		Queue<Customer> queue = new PriorityQueue<>(new Comparator<Customer>() {
			@Override
			public int compare(Customer o1, Customer o2) {
				return o2.shoppingPoint - o1.shoppingPoint;
			}
		});
		
		queue.add(customer1);
		queue.add(customer2);
		queue.add(customer3);
		queue.add(customer4);
		queue.add(customer5);
		queue.add(customer6);
		
		queue.forEach(s->System.out.println(s.toString()));
	}
	
	public enum CustomerType{
		VIP, NORMAL
	}
	public static class Customer{
		private String name;
		private int shoppingPoint;
		private CustomerType type;
		
		public Customer(String name, int shoppingPoint) {
			this.name = name;
			this.shoppingPoint = shoppingPoint;
			if(shoppingPoint > 1000) {
				this.type = CustomerType.VIP;
			}else {
				this.type = CustomerType.NORMAL;
			}
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("Name : " + this.name);
			sb.append(", type: " + this.type.toString() + ";");
			return sb.toString();
		}
		
	}
}
