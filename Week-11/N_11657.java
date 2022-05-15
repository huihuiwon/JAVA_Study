package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_11657 {
	
	static class Node{
		int u,v,weight;
		public Node(int u,int v,int weight) {
			this.u=u;
			this.v=v;
			this.weight=weight;
		}
	}
	
	static class Graph{
		private int n;
		private Node[] maps;
		private int idx;
		
		public Graph(int n,int m) {
			this.n=n;
			idx=0;
			maps=new Node[m];
		}
		
		public void input(int i,int j, int w) {
			maps[idx++]=new Node(i,j,w);
		}
		
		public boolean bellmanford(int start) {
			StringBuilder sb =new StringBuilder();
			long[] distance = new long[n+1];
			
			for(int i=1;i<n+1;i++)distance[i]=Integer.MAX_VALUE;
			
			distance[start]=0;
			
			//cycle 체크를 위해 n번 반복. 
			for(int i=0;i<n;i++) {
				for(int j=0;j<maps.length;j++) {
					Node a=maps[j];
					
					//distance가 Integer.MAX_VALUE 를 넘어가는 경우가 있을 수 있다..
					if(distance[a.u]==Long.MAX_VALUE)continue;
			
					if(distance[a.v]>distance[a.u]+a.weight) {
						if(i==n-1) { //n번째 반복했다면, 음수 순환이 존재한다는 뜻.
							System.out.println(-1);
							return false;
						}
						
						distance[a.v]=distance[a.u]+a.weight;
					}
				}
			}
			for(int i=2;i<n+1;i++) {
				if(distance[i]==Integer.MAX_VALUE)sb.append(-1+"\n");
				else sb.append(distance[i]+"\n");
			}
			System.out.print(sb);
			return true;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		Graph g = new Graph(n,m);
		
		for(int i=0;i<m;i++) {
			str=br.readLine().split(" ");
			g.input(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]));
		}
		g.bellmanford(1);
		
	}

}
