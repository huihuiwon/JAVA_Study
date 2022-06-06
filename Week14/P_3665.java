import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_3665 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			
			int[] t = new int[n+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=1; i<=n; i++) {
				t[i] = Integer.parseInt(st.nextToken());
			}
			
			boolean[][] graph = new boolean[n+1][n+1];
			int[] in_degree = new int[n+1];
			//���� ����->���� ���� ���� ����
			for (int i=1; i<n; i++) {
				for (int j=i+1; j<=n; j++) {
					graph[t[i]][t[j]] = true;
					in_degree[t[j]]++;
				}
			}
			
			int m = Integer.parseInt(br.readLine());
			//������ ���� �ݿ�(���� ���� ���� ����, �ݴ� ���� ����)
			for (int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				if (graph[start][end]) {
					graph[start][end] = false;
					graph[end][start] = true;
					in_degree[end]--;
					in_degree[start]++;
				}
				else {
					graph[end][start] = false;
					graph[start][end] = true;
					in_degree[start]--;
					in_degree[end]++;
				}
			}
			
			sb.append(topologicalSort(graph, in_degree, n)).append("\n");
		}
		
		System.out.print(sb);
		
		br.close();
	}

	public static String topologicalSort(boolean[][] graph, int[] in_degree, int n){
		StringBuilder order = new StringBuilder();
		
		Queue<Integer> q = new LinkedList<>();
		
		//�������� 0�� ��� ť�� �߰�
		for (int i=1; i<=n; i++) {
			if (in_degree[i] == 0)
				q.add(i);
		}
		
		int cnt = 0;
		while (!q.isEmpty()) {
			//������ ���� ���� ������ ���(���� ���� 0�� ��尡 ���� ��)
			if (q.size() > 1) {
				return "?";
			}
			int cur = q.remove();
			order.append(cur).append(" ");
			cnt++;
			//���� ���� �� ���� ���� 0�� ��� ã��
			for (int i=1; i<=n; i++) {
				if (graph[cur][i]) {
					if (--in_degree[i] == 0) {
						q.add(i);
					}
				}
			}
		}
		
		//����Ŭ�� �ִ� ���(n�� ������ �������� ���� �����)
		if (cnt != n) {
			return "IMPOSSIBLE";
		}
		
		return order.toString();
	}
}
