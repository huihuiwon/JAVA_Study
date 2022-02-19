import java.util.*;
import java.io.*;



public class Main {	

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String tmp[]=br.readLine().split(" ");
		
		Stack<Integer> st = new Stack<>();
		int num[]=new int[n];
		for(int i=0; i<n; i++) {
			int x=Integer.parseInt(tmp[n-1-i]);
			while(true) {
				if(st.isEmpty()) {
					num[i]=-1;
					st.push(x);
					break;
				}
				if(st.peek()<=x) {
					st.pop();
				}
				else {
					num[i]=st.peek();
					st.push(x);
					break;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=n-1; i>=0 ; i--)
			sb.append(num[i] +" ");
		System.out.println(sb);
	}
}