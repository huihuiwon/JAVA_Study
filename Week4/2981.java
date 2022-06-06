import java.util.*;
import java.io.*;


public class Main {	

	static int gcd(int x, int y) {
		if(y==0) return x;
		else
			return gcd(y, x%y);
	}
	public static void main(String[] args) throws IOException{

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int num[]=new int[n];
		for(int i=0; i<n; i++) {
			num[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(num);
		int tmp=num[1]-num[0];
		for(int i=2; i<n; i++) {
			tmp=gcd(tmp, num[i]-num[i-1]);
		}

		for(int i=2; i<=tmp; i++) {
			if(tmp%i==0)
				System.out.print(i+" ");
		}
	}
	
}