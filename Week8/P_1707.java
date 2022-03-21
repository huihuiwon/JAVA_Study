import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P_1707 {
	private static ArrayList<ArrayList<Integer>> graph;
	private static int[] visited; //그래프 방문 기록+집합 구분
	private static boolean check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int K = Integer.parseInt(br.readLine());
		
		for (int i=0; i<K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			//그래프 정보 저장
			graph = new ArrayList<ArrayList<Integer>>();
			
			for (int j=0; j<=V; j++) {
				graph.add(new ArrayList<>());
			}
			
			for (int j=0; j<E; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph.get(a).add(b);
				graph.get(b).add(a);
			}
			
			visited = new int[V+1];
			check = true;
			for (int v=1; v<=V; v++) {
				if (visited[v] == 0) {
					dfs(v, 1);
					if (check == false) {
						break;
					}
				}
			}
			
			bw.write(check ? "YES\n":"NO\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dfs(int i, int cur) {
		//정점이 속하는 집합 구분(1/-1)
		visited[i] = cur;
		
		for (int j=0; j<graph.get(i).size(); j++) {
			int k = graph.get(i).get(j);
			//인접 정점끼리 같은 값을 가지면(같은 집합에 속하면) 이분그래프X
			if (visited[k] == visited[i]) {
				check = false;
				return ;
			}
			//아직 방문하지 않은 경우
			if (visited[k] == 0) {
				dfs(k, cur*-1);
			}
		}
	}
}
