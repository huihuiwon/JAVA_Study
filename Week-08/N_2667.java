package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class N_2667 {
	static int arr[][];
	static int visited[][];
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visited = new int[n][n];
		for(int i=0;i<n;i++) {
			String[] aa=br.readLine().split("");
			for(int j=0;j<n;j++) {
				arr[i][j]=Integer.parseInt(aa[j]);
			}	
		}
		ArrayList<Integer> res = new ArrayList<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]==1 && visited[i][j]==0) {
					res.add(dfs(i,j));
				}
			}
		}
		Collections.sort(res);
		System.out.println(res.size());
		for(Integer i : res) {
			System.out.println(i);
		}
		
	}
	
	static int dfs(int x,int y) {
		
		if(visited[x][y]!=0) {
			return 0;
		}
		
		visited[x][y]=1;
		
		if(arr[x][y]==0) return 0;
		
		int cnt=1;
		
		if(x-1>=0 && arr[x-1][y]==1)cnt+=dfs(x-1,y);
		if(x+1<n && arr[x+1][y]==1)cnt+=dfs(x+1,y);
		if(y-1>=0 && arr[x][y-1]==1)cnt+=dfs(x,y-1);
		if(y+1<n && arr[x][y+1]==1)cnt+=dfs(x,y+1);
		return cnt;
	}
}
