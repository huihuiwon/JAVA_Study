import java.util.*;
import java.io.*;


public class Main {	


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp[]=br.readLine().split(" ");
		int n=Integer.parseInt(tmp[0]);
		int m=Integer.parseInt(tmp[1]);
		
		if(n==m) {
			System.out.println(0);
			System.out.println(n);
			return;
		}
		
		int dx[]= {0, -1, 1};
		int dist[]=new int[200002];
		
		Queue<Integer> q = new LinkedList<>();
		Arrays.fill(dist, -1);
		q.offer(n);
		dist[n]=0;
		
		int visited[]=new int[200002];
		Arrays.fill(visited, -1);
		visited[n]=0;
		
		while(!q.isEmpty()) {
			int cur=q.poll();
			dx[0]=cur;
			
			for(int dir=0; dir<3; dir++) {
				int nx=cur+dx[dir];
				if(nx==m) {
					visited[m]=cur;
					StringBuilder sb = new StringBuilder();
					sb.append(dist[cur]+1+"\n");

					ArrayList<Integer> arr = new ArrayList<>();
					arr.add(m);
					
					while(true) {
						arr.add(visited[m]);
						m=visited[m];
						if(visited[m]==0) break;
					}
					if(arr.size()!=dist[cur]+2) arr.add(0);
					Collections.reverse(arr);
					for(int i : arr)
						sb.append(i+" ");
					System.out.println(sb);
					return;
				}
				if(nx<0 || nx>=200002) continue;
				if(dist[nx]!=-1) continue;
				q.offer(nx);
				dist[nx]=dist[cur]+1;
				visited[nx]=cur;
			}
		}

        
	}
}