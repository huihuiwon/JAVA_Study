import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P_13305 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] dist = new long[N-1];
		long[] cost = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<N-1; i++) {
			dist[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		//ó�� ��������� ������ ���� �Ÿ���ŭ �����ؾ� ��
		//���� ������ ������ ���ݺ��� ������ ���� �Ÿ���ŭ �� ����
		//������ ���� �Ÿ��� ���� �����ҿ��� ����
		long minCost = cost[0]*dist[0];
		
		for (int i=1; i<N-1; i++) {
			int next = i;
			while (next < N-1) {
				if (cost[i-1] <= cost[next]) {
					minCost += cost[i-1]*dist[next];
					next++;
				}
				else {
					minCost += cost[next]*dist[next];
					break;
				}
			}
			i=next;
		}
		
		bw.write(String.valueOf(minCost));
		
		br.close();
		bw.flush();
		bw.close();
	}

}
