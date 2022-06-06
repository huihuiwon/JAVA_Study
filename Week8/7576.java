
import java.io.*;
import java.util.*;
class Main {
	public static void main(String args[]) throws Exception	{		
		Scanner sc =new Scanner(System.in);
		int m=sc.nextInt(); int n=sc.nextInt();
		int tomato[][]=new int[n][m];
		int dist[][]=new int[n][m];
		for(int i=0; i<n; i++) 
			for(int j=0; j<m; j++)
				dist[i][j]=-1;
		
		Queue<int[]> q = new LinkedList<>();
		
		int cant=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				tomato[i][j]=sc.nextInt();
				if(tomato[i][j]==0) cant++;
				if(tomato[i][j]==1) {
					q.add(new int[] {i, j});
					dist[i][j]=0;
				}
			}
		}
		
		if(cant==0) {
			System.out.println(0);
			return;
		}
		
		int dx[]= {0,1,0,-1};
		int dy[]= {1,0,-1,0};
		
		while(!q.isEmpty()) {
			int cur[]=q.poll();
			for(int dir=0; dir<4; dir++) {
				int nx=dx[dir]+cur[0];
				int ny=dy[dir]+cur[1];
				if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
				if(tomato[nx][ny]==-1 || tomato[nx][ny]==1) continue;
				if(dist[nx][ny]!=-1) continue;
				q.add(new int[] {nx, ny});
				dist[nx][ny]=dist[cur[0]][cur[1]]+1;
			}
		}
		
		int max=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(dist[i][j]==-1 && tomato[i][j]!=-1) {
					System.out.println(-1);
					return;
				}
				
				max=Math.max(max, dist[i][j]);
			}
		}
		System.out.println(max);
	}	
}