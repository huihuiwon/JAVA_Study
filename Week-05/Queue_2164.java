package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Queue_2164 {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			queue.add(i);
		}
		int i=0;
		while(queue.size()>1) {
			if(i%2==0) {
				queue.poll();
			}
			else {
				int a = queue.poll();
				queue.add(a);
			}
			i++;
		}
		System.out.println(queue.poll());
	}
}
