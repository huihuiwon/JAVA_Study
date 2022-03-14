package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_2293 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int arr[]= new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		int dp[]=new int[k+1];

		for(int i=0;i<n;i++) {
			for(int j=1;j<k+1;j++) {
				if(j-arr[i]>0) {
					dp[j]+=dp[j-arr[i]];
				}
				else if(j-arr[i]==0) {
					dp[j]+=1;
				}
			}
		}
		System.out.println(dp[k]);
		
	}

}
