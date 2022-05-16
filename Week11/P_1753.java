import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P_1753 {
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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<ArrayList<Node>>();
		for (int i=0; i<=V; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		//시작 정점 번호 K
		int K = Integer.parseInt(br.readLine());
		
		//그래프 정보 저장
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(u).add(new Node(v, w));
		}
		
		//다익스트라 알고리즘
		int[] dist = dijkstra(K);
		
		for (int i=1; i<=V; i++) {
			if (dist[i] == INF) {
				bw.write("INF");
			}
			else {
				bw.write(String.valueOf(dist[i]));
			}
			bw.write("\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static int[] dijkstra(int K) {
		int V = graph.size();
		//시작 정점부터 각 정점까지 최소 비용 저장할 배열
		int[] dist = new int[V];
		Arrays.fill(dist, INF);

		boolean[] check = new boolean[V];

		PriorityQueue<Node> pq = new PriorityQueue<>();

		//시작 정점을 먼저 큐에 추가, K->K 비용=0
		pq.add(new Node(K, 0));
		dist[K] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.remove();

			//이미 탐색한 정점이면 넘어감
			if (check[cur.index]) {
				continue;
			}
			check[cur.index] = true;
			
			for (Node nxt : graph.get(cur.index)) {
				//현재 정점을 거쳐 다음 정점으로 가는 비용이 기존 비용보다 작으면 값 갱신
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
