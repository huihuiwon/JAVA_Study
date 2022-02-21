package numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NT_2981 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb= new StringBuffer();
		int n=Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		int gcd_num=0;
		
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		
		for(int i=1;i<n;i++) {
			if(i==1) gcd_num=Math.abs(arr[i]-arr[i-1]);
			else gcd_num=gcd(Math.abs(arr[i]-arr[i-1]),gcd_num);
		}
		
		
		for(int i=2;i<=gcd_num;i++) {
			if(gcd_num%i==0){
				sb.append(i+" ");
			}
		}
		
		System.out.println(sb);
		
	}
	static int gcd(int a, int b) {
		while(b!=0) {
			int r=a%b;
			a=b;
			b=r;
		}
		return a;
	}

}
