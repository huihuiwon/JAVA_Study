import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P_9370 {
	static ArrayList<ArrayList<Node>> graph;
	static final int INF = Integer.MAX_VALUE;
	
	static class Node implements Comparable<Node>{
		int index;
		int weight;
		
		public Node(int index, int weight) {
			this.index = index;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//교차로, 도로, 목적지 후보 개수
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			//출발지, g-h 교차로 
			int s = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList<ArrayList<Node>>();
			for (int j=0; j<=n; j++) {
				graph.add(new ArrayList<Node>());
			}
			
			//a,b 사이 d 길이의 양방향 도로
			int ghCost = 0;
			for (int j=0; j<m; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				graph.get(a).add(new Node(b, d));
				graph.get(b).add(new Node(a, d));
				if ((a==g && b==h) || (a==h && b==g)) {
					ghCost = d;
				}
			}
			
			//목적지 후보
			int[] destV = new int[t];
			for (int j=0; j<t; j++) {
				destV[j] = Integer.parseInt(br.readLine());
			}
			
			int[] dist_s = dijkstra(s);
			int[] dist_g = dijkstra(g);
			int[] dist_h = dijkstra(h);
			
			Arrays.sort(destV);
			//s->dest 최소 비용이 s->(g-h)->dest 최소 비용과 같은지 확인
			//g-h를 지나가는 경우: 1. s->g-h->dest, 2. s->h-g->dest
			for (int dest : destV) {
				if (dist_s[dest] == dist_s[g]+ghCost+dist_h[dest] || 
						dist_s[dest] == dist_s[h]+ghCost+dist_g[dest]) {
					bw.write(String.valueOf(dest)+" ");
				}
			}
			bw.write("\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static int[] dijkstra(int start) {
		int n = graph.size();
		int[] dist = new int[n];
		Arrays.fill(dist, INF);

		boolean[] check = new boolean[n];
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			Node cur = pq.remove();
			
			if (check[cur.index]) {
				continue;
			}
			check[cur.index] = true;
			
			for (Node nxt : graph.get(cur.index)) {
				int cost = dist[cur.index] + nxt.weight;
				if (cost < dist[nxt.index]) {
					dist[nxt.index] = cost;
					pq.add(new Node(nxt.index, dist[nxt.index]));
				}
			}
		}
		
		return dist;
	}

}
