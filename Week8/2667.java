
import java.io.*;
import java.util.*;
class Main {
	public static void main(String args[]) throws Exception	{		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		int map[][]=new int[n][n];
		boolean chk[][]=new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			String t=br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j]=t.charAt(j)-'0';
			}
		}
		
		int cnt=0;
		int dx[]= {0,1,0,-1};
		int dy[]= {1,0,-1,0};
		
		ArrayList<Integer> arr =new ArrayList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(chk[i][j]) continue;
				if(map[i][j]==0) continue;
				
				Queue<int[]> q = new LinkedList<>();
				q.add(new int[] {i, j});
				chk[i][j]=true;
				
				cnt++;
				
				int area=0;
				while(!q.isEmpty()){
					area++;
					int cur[]=q.poll();
					for(int dir=0; dir<4; dir++) {
						int nx=cur[0]+dx[dir];
						int ny=cur[1]+dy[dir];
						if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
						if(chk[nx][ny] || map[nx][ny]==0) continue;
						chk[nx][ny]=true;
						q.add(new int[] {nx, ny});
					}
				}
				arr.add(area);
			}
		}
		
		System.out.println(cnt);
		Collections.sort(arr);
		for(int i : arr)
			System.out.println(i);
	}	
}