
import java.io.*;
import java.util.*;
class Main {
	public static void main(String args[]) throws Exception	{		
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		
		while(t-->0) {
			int v=sc.nextInt(); int e=sc.nextInt();
			
			ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
			for(int i=0; i<=v; i++)
				graph.add(new ArrayList<Integer>());
			
			for(int i=0; i<e; i++) {
				int a=sc.nextInt();
				int b=sc.nextInt();
				graph.get(a).add(b);
				graph.get(b).add(a);
			}
			
			int visited[]=new int[v+1];
			
			
			Queue<Integer> q = new LinkedList<>();
			boolean flag=true;
			for(int i=1; i<=v; i++) {
				if(visited[i]==0) {
					q.add(i);
					visited[i]=1;
				}
				
				while(!q.isEmpty() && flag) {
					int cur=q.poll();
					for(int nxt : graph.get(cur)) {
						if(visited[nxt]==0) {
							if(visited[cur]==1)
								visited[nxt]=2;
							else if(visited[cur]==2)
								visited[nxt]=1;
							q.add(nxt);
						}
						if(visited[nxt]==visited[cur]) {
							sb.append("NO\n");
							flag=false;
							break;
						}
					}
					
				}
			}
			if(flag)
				sb.append("YES\n");
		}
		System.out.println(sb);
	}	
}