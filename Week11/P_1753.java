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
		
		//���� ���� ��ȣ K
		int K = Integer.parseInt(br.readLine());
		
		//�׷��� ���� ����
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(u).add(new Node(v, w));
		}
		
		//���ͽ�Ʈ�� �˰���
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
		//���� �������� �� �������� �ּ� ��� ������ �迭
		int[] dist = new int[V];
		Arrays.fill(dist, INF);

		boolean[] check = new boolean[V];

		PriorityQueue<Node> pq = new PriorityQueue<>();

		//���� ������ ���� ť�� �߰�, K->K ���=0
		pq.add(new Node(K, 0));
		dist[K] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.remove();

			//�̹� Ž���� �����̸� �Ѿ
			if (check[cur.index]) {
				continue;
			}
			check[cur.index] = true;
			
			for (Node nxt : graph.get(cur.index)) {
				//���� ������ ���� ���� �������� ���� ����� ���� ��뺸�� ������ �� ����
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
