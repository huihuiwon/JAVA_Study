import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

/*가운데를 말해요 - 우선순위 */
public class P_1655 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(); //최소힙 
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i = 0 ; i < N;i++) {
			int num = Integer.parseInt(br.readLine());
			if(minHeap.size() == maxHeap.size()) maxHeap.add(num);
			else minHeap.add(num);
			if(!minHeap.isEmpty() && !maxHeap.isEmpty() && maxHeap.peek()>minHeap.peek()) {
				int temp = minHeap.poll();
				minHeap.add(maxHeap.poll());
				maxHeap.add(temp);
			}
			bw.write(maxHeap.peek()+"\n");
			
		}
		
		bw.flush();
		br.close();
		bw.close();
	}

}
