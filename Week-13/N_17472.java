package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class N_17472 {
	public static int[][] data;
	public static boolean[][] visited;
	public static int n, m;
	public static int[] parent;
	public static int[][] list;
	public static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		int answer=0;
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		
		data = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			str = br.readLine().split(" ");
			for(int j=0;j<m;j++) data[i][j]=Integer.parseInt(str[j]);
		}
		
		int cnt=1;
		
		//섬을 숫자로 변경
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(data[i][j]==1 && !visited[i][j])bfs(i,j,++cnt);
			}
		}
		
		map = new int[cnt+1][cnt+1];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(data[i][j]!=0 && visited[i][j])bfs_bridge(i,j);
			}
		}
		
		for(int i=0;i<n;i++)System.out.println(Arrays.toString(data[i]));
		
		list = new int[cnt*cnt][3];
		parent = new int[cnt+1];
		for(int i=1;i<=cnt;i++)parent[i]=i; //자기자신을 가리키게 초기화

		int c=0;	
		
		for(int i=2;i<=cnt;i++) 
			for(int j=2;j<=cnt;j++) {
				if(map[i][j]>=2) {
					list[c++]=new int[]{i,j,map[i][j]};
				}
			}
		
		boolean[] check= new boolean[cnt+1];
		list= Arrays.copyOfRange(list, 0, c);
		Arrays.sort(list, (o1,o2) -> Integer.compare(o1[2], o2[2]));
		
		for(int[] one : list) {
			if(find(one[0]) != find(one[1])){
				check[one[0]]=true;
				check[one[1]]=true;
				union(one[0],one[1]);
				answer+=one[2];
			}
		}

		int curr=find(2);
		for(int i=3;i<cnt+1;i++) {
			if(find(i)!=curr) {
				answer=0;
				break;
			}
		}
		
		
		if(answer==0)System.out.println(-1);
		else System.out.println(answer);
	}
	
	public static void bfs(int x,int y, int cnt) {
		Queue<int[]> queue = new LinkedList<int[]>();
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		
		queue.add(new int[] {x,y});
		data[x][y]=cnt;
		visited[x][y]=true;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();

			for(int i=0;i<4;i++) {
				int cx = now[0]+dx[i];
				int cy = now[1]+dy[i];
				if(cx>=0&&cx<n&&cy>=0&&cy<m) {
					if(!visited[cx][cy] && data[cx][cy]==1) {
						queue.add(new int[] {cx,cy});
						visited[cx][cy]=true;
						data[cx][cy]=cnt;
					}
				}
			}
		}	
	}
	
	public static void bfs_bridge(int x,int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};		
		
		for(int i=0;i<4;i++) { //한 방향으로만 나아가야함
			
			queue.add(new int[] {x,y,0});
			
			while(!queue.isEmpty()) {
				int[] now = queue.poll();
				
				int cx=now[0]+dx[i];
				int cy=now[1]+dy[i];
				
				if(cx>=0&&cx<n&&cy>=0&&cy<m) {
					if(data[cx][cy]==0) {
						queue.add(new int[] {cx,cy,now[2]+1});
					}
					else if(data[cx][cy] != data[x][y] && visited[cx][cy]) { //다른 곳에 도착하면
						if(now[2]<2) continue;
						
						if(map[data[x][y]][data[cx][cy]]==0) map[data[x][y]][data[cx][cy]] = now[2];
						else map[data[x][y]][data[cx][cy]]= Math.min(now[2], map[data[x][y]][data[cx][cy]]);
						break;
					}
				}
			}
		}
	
	}
	
	//부모를 제일 적은 수의 노드로 업데이트
	public static void union(int a,int b){
		a=find(a);
		b=find(b);
		
		if(a>b) {
			parent[a]=b;
		}
		else parent[b]=a;
	}
	
	public static int find(int x) {
		if(parent[x]==x) {
			return x;
		}
		else return find(parent[x]);
	}

}
