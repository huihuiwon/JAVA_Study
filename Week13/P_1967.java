import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P_1967 {
	static ArrayList<ArrayList<Node>> tree;
	
	static class Node {
		int data;
		int weight;
		
		public Node(int data, int weight) {
			this.data = data;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		tree = new ArrayList<>();
		
		for (int i=0; i<=n; i++) {
			tree.add(new ArrayList<>());
		}
		
		for (int i=0; i<n-1; i++) {
			String[] s = br.readLine().split(" ");
			int parent = Integer.parseInt(s[0]);
			int child = Integer.parseInt(s[1]);
			int weight = Integer.parseInt(s[2]);
			tree.get(parent).add(new Node(child, weight));
			tree.get(child).add(new Node(parent, weight));
		}
		
		//루트 노드(1)에서 가장 먼 노드 찾기
		int node = bfs(1)[0];
		
		//해당 노드(node)부터 가장 먼 노드까지 거리 찾기
		bw.write(String.valueOf(bfs(node)[1]));
		
		br.close();
		bw.flush();
		bw.close();
	}

	public static int[] bfs(int start) {
		int[] visited = new int[tree.size()];
		Arrays.fill(visited, -1);
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(start);
		visited[start] = 0;
		while (!q.isEmpty()) {
			int cur = q.remove();
			
			for (Node nxt : tree.get(cur)) {
				if (visited[nxt.data] == -1) {
					visited[nxt.data] = visited[cur] + nxt.weight;
					q.add(nxt.data);
				}
			}
		}
		
		int node = 0;
		int dist = 0;
		for (int i=1; i<tree.size(); i++) {
			if (visited[i] > dist) {
				node = i;
				dist = visited[i];
			}
		}
		
		return new int[]{node, dist};
	}
}
