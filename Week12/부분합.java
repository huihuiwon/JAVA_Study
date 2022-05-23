import java.util.*;
import java.io.*;


public class Main {	

	static int n;
	static int m;
	static int a[];
	static int result=0;
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		a=new int[n];
		for(int i=0; i<n; i++)
			a[i]=sc.nextInt();
		
		int lt=0; int sum=0;
		int result=200000;
		for(int rt=0; rt<n; rt++) {
			sum+=a[rt];
			if(sum>=m) {
				result=Math.min(result, rt-lt+1);
			}
			while(sum>=m && lt<rt) {
				sum-=a[lt++];
				if(sum>=m) result=Math.min(result, rt-lt+1);
			}
		}
		
		if(result==200000) System.out.println(0);
		else System.out.println(result);
	}
}