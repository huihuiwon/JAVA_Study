package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_1520 {
	public static int arr[][];
	public static int dp[][];
	public static int m,n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[m][n];
		dp=new int[m][n];
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				dp[i][j]=-1;
			}
		}
		
		System.out.println(count(0,0));
		//System.out.println(res);
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[i].length;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
	}
	//어차피 왔던 길은 못간다. (계단이 더 높으니까)
	public static int count(int x,int y) {
		if(dp[x][y]!=-1) {
			return dp[x][y];
		}
		if(x==m-1&&y==n-1) {
			return 1;
		}
		
		dp[x][y]=0;
		if(x-1>=0&&arr[x-1][y]<arr[x][y])dp[x][y]+=count(x-1,y);
		if(x+1<m&&arr[x+1][y]<arr[x][y])dp[x][y]+=count(x+1,y);
		if(y-1>=0&&arr[x][y-1]<arr[x][y])dp[x][y]+=count(x,y-1);
		if(y+1<n&&arr[x][y+1]<arr[x][y])dp[x][y]+=count(x,y+1);
		
		return dp[x][y];
	}
}
