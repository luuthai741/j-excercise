import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Ex2<T> {

	@SuppressWarnings("hiding")
	public <T extends Comparable<T>> T findMaxIndex(List<T> list) {
		int maxIndex = 0;
		for (int index = 1; index <= list.size() - 1; index++) {
			if (list.get(index).compareTo(list.get(maxIndex)) > 0) {
				maxIndex = index;
			}
		}
		return list.get(maxIndex);
	}

	public List<T> reverse(List<T> list) {
		for (int i = 0, j = list.size() - 1; i < j; i++) {
			T value = list.remove(j);
			list.add(i, value);
		}
		return list;
	}

	public boolean checkElementOccurs(List<T> list, T t) {
		return list.contains(t);
	}

	public List<Integer> oddPositions(List<Integer> list) {
		List<Integer> positions = new LinkedList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) % 2 != 0) {
				positions.add(i);
			}
		}
		return positions;
	}

	public List<Integer> runningTotal(List<Integer> list) {
		List<Integer> total = new LinkedList<>();
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
			total.add(sum);
		}
		return total;
	}

	public boolean palindrome(String s) {
		int head = 0, tail = s.length() - 1;
		while (head < tail) {
			if (s.charAt(tail) != s.charAt(head))
				return false;
			if (s.charAt(tail) == s.charAt(head)) {
				head++;
				tail--;
			}
		}
		return true;
	}

	public int sumForLoop(List<Integer> list) {
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		return sum;
	}
	public int sumWhileLoop(List<Integer> list) {
		int sum = 0;
		int i=0;
		while(i<list.size()) {
			sum+=list.get(i);
			i++;
		}
		return sum;
	}
	
	public int sumRecursion(List<Integer> list) {
		if(list.size() ==1) return list.get(0);
		if(list.size() ==0) return 0;
		if(list.size() ==2) return list.get(0) + list.get(1);
		else {
			int mid = list.size()/2;
			List<Integer> list1 = new ArrayList<>(list.subList(0,mid+1));
			List<Integer> list2 = new ArrayList<>(list.subList(mid+1, list.size()));
			return sumRecursion(list1) + sumRecursion(list2);
		}
	}
	
	public List<Integer> perfectSquare(int limit){
		List<Integer> list = new ArrayList<Integer>();
		for(int i=1;i<=Math.sqrt(limit);i++) {
			list.add(i*i);
		}
		return list;
	}
	
	public List<Object> concat(List<String> list1, List<Integer> list2){
		List<Object> list = new ArrayList<Object>();
		list.addAll(list1);
		list.addAll(list2);
		return list;
	}
}
