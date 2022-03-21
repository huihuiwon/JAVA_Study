package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N_7576 {
	static int arr[][];
	static int visited[][];
	static int m;
	static int n;
	static Queue<int []> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited= new int [n][m];
		
		q = new LinkedList<int []>();  
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) q.add(new int[] {i,j});
			}
		}
		bfs();
		
		int max=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==0) {
					System.out.println(-1);
					System.exit(0);
				}
				max=Math.max(max, arr[i][j]);
			}
		}
		System.out.println(max-1);
		
	}
	
	static void bfs() {
		int dir_x[] = {-1,0,1,0};
		int dir_y[] = {0,-1,0,1};
		
		while(!q.isEmpty()) {
			int [] aa=q.poll();
			visited[aa[0]][aa[1]]=1;
			int now = arr[aa[0]][aa[1]]+1;
			
			for(int i=0;i<4;i++) {
				int n_x = aa[0]+dir_x[i];
				int n_y = aa[1]+dir_y[i];
				if(n_x>=0&&n_x<n&&n_y>=0&&n_y<m) {
					if(visited[n_x][n_y]==0 && arr[n_x][n_y]==0) {
						visited[n_x][n_y]=1;
						arr[n_x][n_y]=now;
						q.add(new int[]{n_x,n_y});
					}
				}
			}
		}
	}

}
