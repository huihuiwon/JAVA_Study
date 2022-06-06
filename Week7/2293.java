import java.util.*;
import java.io.*;


public class Main {	

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp[]=br.readLine().split(" ");
		int n=Integer.parseInt(tmp[0]);
		int k=Integer.parseInt(tmp[1]);
		int coin[]=new int[n+1];
		int dp[]=new int[k+1];
		for(int i=1; i<=n; i++) {
			coin[i]=Integer.parseInt(br.readLine());
		}
		
		dp[0]=1;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=k; j++) {
				if(j-coin[i]>=0)
					dp[j]+=dp[j-coin[i]];
			}
		}
		
		System.out.println(dp[k]);
	}
}