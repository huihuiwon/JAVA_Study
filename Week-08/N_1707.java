package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class N_1707 {
	static LinkedList<Integer>[] list;
	static StringBuilder sb = new StringBuilder();
	static int color[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		
		for(int i=0;i<k;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			list = new LinkedList[v+1];
			
			for(int z=0;z<v+1;z++) {
				list[z]=new LinkedList();
			}
			color = new int[v+1];
			
			for(int j=0;j<e;j++) {
				//간선 입력 받기
				st = new StringTokenizer(br.readLine());
				
				int v1=Integer.parseInt(st.nextToken());
				int v2=Integer.parseInt(st.nextToken());
				list[v1].add(v2);
				list[v2].add(v1);
			}
			
			boolean res=bfs(v,1);
			if(res) {
				for(int c=1;c<color.length;c++) {
					if(color[c]==0) {
						boolean r = bfs(v,c);
						if(!r) {
							res=!res;
						}
					}
				}
			}
			if(res)sb.append("YES\n");
			else sb.append("NO\n");
			
		}
		System.out.println(sb);
		
	}
	
	static boolean bfs(int v,int start) {
		Queue<Integer> q = new LinkedList<>();
		
		
		q.add(start);
		color[start]=1;
		
		while(!q.isEmpty()) {
			int cur=q.poll();
			
			for(Integer i:list[cur]) {
				if(color[i]==0) {
					color[i]= -color[cur];
					q.add(i);
				}
				else if(color[i]==color[cur]){
					return false;
				}
			}
			
		}
				
		return true;
	}
	


}
