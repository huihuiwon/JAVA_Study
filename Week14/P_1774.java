import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P_1774 {
	static Pos[] node;
	static PriorityQueue<Channel> pq;
	static int[] parent;
	
	static class Pos {
		int x;
		int y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Channel implements Comparable<Channel> {
		int u;
		int v;
		double dist;
		
		public Channel(int u, int v, double dist) {
			this.u = u;
			this.v = v;
			this.dist = dist;
		}

		@Override
		public int compareTo(Channel o) {
			return Double.compare(this.dist, o.dist);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		node = new Pos[N+1];
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			node[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		parent = new int[N+1];
		for (int i=0; i<=N; i++) {
			parent[i] = i;
		}
		
		int cnt = N;
		//이미 연결된 통로 처리
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			if (find(n1) != find(n2))
				cnt--;
			union(n1, n2);
		}
		
		//연결 가능한 통로(무방향) 찾기
		findChannel();
		
		//모든 신들과 연결되는 통로 만들기
		System.out.printf("%.2f", Kruskal(cnt));
		
		br.close();
	}
	
	public static void findChannel() {
		pq = new PriorityQueue<>();
		
		for (int i=1; i<node.length; i++) {
			for (int j=i+1; j<node.length; j++) {
				if (find(i) != find(j)) {
					pq.add(new Channel(i, j, getDistance(i, j)));
				}
			}
		}
	}
	
	public static double getDistance(int n1, int n2) {
		return Math.sqrt(Math.pow(node[n1].x - node[n2].x, 2) + Math.pow(node[n1].y - node[n2].y, 2));
	}
	
	public static double Kruskal(int cnt) {
		double len = 0;
		
		while (!pq.isEmpty()) {
			Channel ch = pq.remove();
			if (find(ch.u) != find(ch.v)) {
				len += ch.dist;
				union(ch.u, ch.v);
				cnt--;
			}
			if (cnt == 1) 
				break;
		}
		
		return (cnt == 1) ? len : -1;
	}
	
	public static int find(int a) {
		if (parent[a] == a)
			return a;
		else 
			return parent[a] = find(parent[a]);
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) 
			parent[b] = a;
	}

}
