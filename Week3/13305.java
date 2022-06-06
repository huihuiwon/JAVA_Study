import java.util.*;
import java.io.*;


public class Main {	
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		long road[]=new long[n-1];
		long cost[]=new long[n];
		for(int i=0; i<n-1; i++)
			road[i]=sc.nextInt();
		for(int i=0; i<n; i++)
			cost[i]=sc.nextInt();
		
		long result=0;
		result+=road[0]*cost[0];
		long min=cost[0];
		for(int i=1; i<n-1; i++) {
			if(cost[i]<min) {
				result+=road[i]*cost[i];
				min=cost[i];
			}
			else {
				result+=road[i]*min;
			}
		}
		System.out.println(result);
	}
}