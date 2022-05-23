import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class P_13913 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] parent = null;
		if (N != K) {
			parent = bfs(N, K);
		}
		
		Stack<Integer> s = new Stack<>();
		s.push(K);
		int p = K;
		int time = 0;
		while (p != N) {
			p = parent[p];
			s.push(p);
			time++;
		}
		
		bw.write(String.valueOf(time)+"\n");
		while (!s.isEmpty()) {
			bw.write(String.valueOf(s.pop())+" ");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static int[] bfs(int N, int K) {
		int[] parent = new int[100001];
		Arrays.fill(parent, -1);
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(N);
		parent[N] = N;
		while (!q.isEmpty()) {
			int curN = q.remove();
			int nxtN;
			//현재 위치에서 -1, +1, *2로 이동
			for (int i=0; i<3; i++) {
				if (i == 0) {
					nxtN = curN - 1;
				}
				else if (i == 1) {
					nxtN = curN + 1;
				}
				else {
					nxtN = curN * 2;
				}
				
				if (nxtN < 0 || nxtN > 100000)
					continue;
				//이동한 위치가 도달한 적 없는 곳이면 parent를 현재 위치로 기록
				if (parent[nxtN] == -1) {
					parent[nxtN] = curN;
					q.add(nxtN);
				}
				//이동한 위치가 K가 되면 종료
				if (nxtN == K) {
					return parent;
				}
			}
		}
		
		return parent;
	}
	
}
