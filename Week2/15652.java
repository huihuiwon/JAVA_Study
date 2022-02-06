import java.util.*;
import java.io.*;

public class Main {	
	
	static int n, m;
	static int arr[];
	static boolean isused[];
	public static void solution(int k) {
		if(k==m) {
			for(int i=0; i<m; i++)
				System.out.print(arr[i]+" ");
			System.out.println("");
			return;
		}
		
		int start=1;
		if(k!=0) start=arr[k-1];
		
		for(int i=start; i<=n; i++) {
			arr[k]=i;
			solution(k+1);
		}
	}
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		arr=new int[m];
		isused=new boolean[n+1];
		
		solution(0);
	}
}