package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Greedy_13305 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		long distance[] = new long[n-1];
		long price[] = new long[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n-1;i++) {
			distance[i]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			price[i]=Integer.parseInt(st.nextToken());
		}
		
		long cost=price[0]*distance[0];
		long now=price[0];
		
		for(int i=1;i<n-1;i++) {
			if(price[i]<now) {
				cost+=price[i]*distance[i];
				now=price[i];
			}
			else {
				cost+=now*distance[i];
			}
		}
		System.out.println(cost);
	}
	
}
