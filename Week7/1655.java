import java.util.*;
import java.io.*;


public class Main {	

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> plus = new PriorityQueue<>();
		PriorityQueue<Integer> minus = new PriorityQueue<>(Collections.reverseOrder());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			int num=Integer.parseInt(br.readLine());
			if(plus.size()>=minus.size()){
				minus.add(num);
			}
			else {
				plus.add(num);
			}
			
			if(plus.size()!=0 && minus.size()!=0 && plus.peek()<minus.peek()) {
				int tmp=plus.poll();
				plus.add(minus.poll());
				minus.add(tmp);
			}
			
			sb.append(minus.peek()+"\n");
		}
		System.out.println(sb);
	}
}