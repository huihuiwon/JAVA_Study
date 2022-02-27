package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Queue_5430 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0;i<t;i++) {
			String p = br.readLine();
			int n=Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine(),"[],");
			Deque<String> deque = new ArrayDeque<>();
			for(int j=0;j<n;j++) {
				deque.add(st.nextToken());
			}
			AC(p,deque);
		}
		
		System.out.println(sb);

	}
	public static void AC(String p,Deque<String> deque) {

		boolean forward=true;
		for(int i=0;i<p.length();i++) {
			if(p.charAt(i)=='R') {
				forward = !forward;
			}
			else{
				String d;
				if(forward==true) {
					d=deque.pollFirst();
				}
				else {
					d=deque.pollLast();
				}
				if(d==null) {
					sb.append("error\n");
					return;
				}
			}
		}
		sb.append("[");
		if(deque.size()>0) {
			if(forward==true) {
				while(!deque.isEmpty()) {
					sb.append(deque.removeFirst()+",");
				}
			}
			else {
				while(!deque.isEmpty()) {
					sb.append(deque.removeLast()+",");
				}
			}
			sb.delete(sb.length()-1, sb.length());	
		}
		
		sb.append("]\n");
		
	}

}
