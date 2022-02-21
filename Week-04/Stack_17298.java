package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Stack_17298 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n=Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		Stack<Integer> stack = new Stack<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<n;i++) {
			while(!stack.empty()) {
				if(arr[stack.peek()]<arr[i]) {
					arr[stack.pop()]=arr[i];
				}
				else {
					stack.push(i);
					break;
				}
				
			}
			if(stack.empty())stack.push(i);
		}
		
		while(!stack.empty()) {
			arr[stack.pop()]=-1;
		}
		for(int a:arr) {
			sb.append(a+" ");
		}
		System.out.println(sb);
	}
}
