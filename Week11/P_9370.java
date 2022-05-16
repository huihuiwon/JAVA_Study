import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*미확인 도착지 */
public class P_9370 {
	static int n,m,t,s,g,h;
	static ArrayList<Node>[] list;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0 ; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			list = new ArrayList[n+1];
			for(int j = 1 ; j <= n;j++) {
				list[j] = new ArrayList<Node>();
			}
			
			st = new StringTokenizer(br.readLine());
			s= Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			for(int j = 0 ; j < m ; j++) { // 도로들 
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				list[a].add(new Node(b,d));
				list[b].add(new Node(a,d));
			}
			int[] dest = new int[t];
			for(int j = 0 ; j < t ;j++) { //목적지 후보들 
				dest[j] = Integer.parseInt(br.readLine());
			}
			
			// s-x 최단경로와 같은 s-g-h-x혹은 s-h-g-x최단경로 찾기 
			PriorityQueue<Integer> qi = new PriorityQueue<>();
			for(int x: dest) {
				long res1 = dijkstra(s,h) + dijkstra(h,g) + dijkstra(g,x);
				long res2 = dijkstra(s,g) + dijkstra(g,h) + dijkstra(h,x);
				long res3 = dijkstra(s,x);
				
				if(Math.min(res1,res2) == res3) {
					qi.offer(x);
				}
			}
			while(!qi.isEmpty()) {
				sb.append(qi.poll()+" ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		

	}
	static long dijkstra(int start, int end) {
		boolean[] check = new boolean[n+1];
		int[] dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(start,0));
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			Node curNode = q.poll();
			int curTo = curNode.end;
			if(check[curTo]) continue;
			check[curTo] = true;
			for(Node node: list[curTo]) {
				if(dist[node.end]> dist[curTo]+node.weight) {
					dist[node.end] = dist[curTo] + node.weight;
					q.offer(new Node(node.end,dist[node.end]));
				}
			}
		}
		return dist[end];
	}
	

}
class Node implements Comparable<Node>{
	int end,weight;
	public Node(int end,int weight) {
		this.end = end;
		this.weight=weight;
	}
	@Override
	public int compareTo(Node o) {
		return weight - o.weight;
	}
}
