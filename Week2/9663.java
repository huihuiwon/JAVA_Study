import java.util.*;
import java.io.*;

public class Main {	
	
	static int n;
	static int count=0;
	static boolean isused[];
	static boolean isused2[];
	static boolean isused3[];
	public static void solution(int k) {

		if(k==n) {
			count++;
			return;
		}
		for(int i=0; i<n; i++) {
			if(isused[i] || isused2[i+k] || isused3[i-k+n-1]) continue;
			isused[i]=true;
			isused2[i+k]=true;
			isused3[i-k+n-1]=true;
			solution(k+1);
			isused[i]=false;
			isused2[i+k]=false;
			isused3[i-k+n-1]=false;		
		}
	}
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		isused=new boolean[n*2];
		isused2=new boolean[n*2];
		isused3=new boolean[n*2];
		
		solution(0);
		System.out.println(count);
	}
}