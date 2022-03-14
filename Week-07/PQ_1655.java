package priority_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class PQ_1655 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> min_heap = new PriorityQueue<>();
		

		for(int i=0;i<n;i++) {
			int a = Integer.parseInt(br.readLine());
			if(max_heap.size()>0 && max_heap.peek()<a) min_heap.add(a);
			else max_heap.add(a);
			
			if(max_heap.size()-1>min_heap.size()) {
				int d=max_heap.remove();
				min_heap.add(d);
			}
			else if(max_heap.size()<min_heap.size()) {
				int d = min_heap.remove();
				max_heap.add(d);
			}
			
			sb.append(max_heap.peek()+"\n");
		}
		System.out.println(sb);
	}

}
