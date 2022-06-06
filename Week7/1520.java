import java.util.*;
import java.io.*;


public class Main {	

	static int n;
	static int m;
	static long result=0;
	static int dp[][];
	public static int DFS(int s, int e, int map[][]) {
		int dx[]= {-1,0,1,0};
		int dy[]= {0,1,0,-1};
		
		if(s==n-1 && e==m-1) return 1;
		if(dp[s][e]!=-1) return dp[s][e];
		else {
			dp[s][e]=0;
			for(int dir=0; dir<4; dir++) {
				int nx=s+dx[dir];
				int ny=e+dy[dir];
				if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
				if(map[nx][ny]<map[s][e])
					dp[s][e] += DFS(nx, ny, map);
			}
		}
		return dp[s][e];
	}
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String tmp[]=br.readLine().split(" ");
		n=Integer.parseInt(tmp[0]);
		m=Integer.parseInt(tmp[1]);
		
		int map[][]=new int[n][m];
		for(int i=0; i<n; i++) {
			tmp=br.readLine().split(" ");
			for(int j=0; j<m; j++) {
				map[i][j]=Integer.parseInt(tmp[j]);
			}
		}
		
		
		dp=new int[n][m];
		for(int i=0; i<n; i++)
			for(int j=0; j<m; j++)
				dp[i][j]=-1;
		
		
		bw.write(DFS(0, 0, map)+"\n");
		bw.flush();
		bw.close();
		
	}
}