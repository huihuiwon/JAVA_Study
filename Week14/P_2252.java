import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_2252 {
	static ArrayList<ArrayList<Integer>> graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for (int i=0; i<=N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		//�� ����� ��������
		int[] in_degree = new int[N+1];
		//Ű�� ���� ����(A->B: ���� �׷���)
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			in_degree[to]++;
			graph.get(from).add(to);
		}
		
		//��������
		topologicalSort(in_degree);
		
		br.close();
	}

	public static void topologicalSort(int[] in_degree){
		StringBuilder order = new StringBuilder();
		
		Queue<Integer> q = new LinkedList<>();
		
		//�������� 0�� ��带 ť�� �߰�
		for (int i=1; i<in_degree.length; i++) {
			if (in_degree[i] == 0)
				q.add(i);
		}
		
		while (!q.isEmpty()) {
			int cur = q.remove();
			order.append(cur).append(" ");
			//���� ��忡�� ����� ���� ���� �� ���� ���� 0�� �� ��� ã��
			for (int nxt : graph.get(cur)) {
				if (--in_degree[nxt] == 0)
					q.add(nxt);
			}
		}
		
		System.out.println(order);
	}
}
