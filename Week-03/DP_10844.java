package dp;

import java.util.Scanner;

public class DP_10844 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n =sc.nextInt();
		
		System.out.println(floor(n));
	}
	
	static long floor(int n) {
		long arr[][] = new long[n][10];//0으로 초기화됨
		
		//0 초기화
		for(int i=1;i<10;i++) {
			arr[0][i]=1;
		}
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<10;j++) {
				//감소
				if(j<9)arr[i][j]+=arr[i-1][j+1]%1000000000;
				//증가
				if(j>0)arr[i][j]+=arr[i-1][j-1]%1000000000;
			}
		}
		
		long cnt=0;
		for(int i=0;i<10;i++) {
			cnt+=(arr[n-1][i]%1000000000);
		}
		
		return cnt%1000000000;
	}

}
