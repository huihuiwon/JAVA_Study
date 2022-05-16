import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_11657 {
	static ArrayList<ArrayList<Node>> graph;
	static long[] dist;
	static final long INF = Long.MAX_VALUE;
	
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
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<ArrayList<Node>>();
		for (int i=0; i<=N; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		//�׷��� ���� ����
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			graph.get(A).add(new Node(B, C));
		}
		
		//bellmanFord(): ���� ����Ŭ ������ true, ������ false
		if (bellmanFord(1)) {
			bw.write("-1");
		}
		else {
			for (int i=2; i<dist.length; i++) {
				//���� ���ÿ��� ���� ��ΰ� ������ dist ���� INF
				if (dist[i] == INF) {
					bw.write("-1\n");
				}
				else {
					bw.write(String.valueOf(dist[i])+"\n");
				}
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

	public static boolean bellmanFord(int start) {
		int N = graph.size()-1;
		dist = new long[N+1];
		Arrays.fill(dist, INF);
		
		dist[start] = 0;
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				if (dist[j] == INF) {
					continue;
				}
				for (Node nxt : graph.get(j)) {
					long nCost = dist[j]+nxt.weight;
					if (nCost < dist[nxt.index]) {
						dist[nxt.index] = nCost;
						//���� ����Ŭ �ִ��� üũ
						if (i == N) {
							return true;
						}
					}
				}
			}
		}
		
		return false;
	}
}
