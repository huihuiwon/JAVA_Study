import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P_15652 {
	private static int N;
	private static int M;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[M+1];
		//1<=A(n-1)
		arr[0] = 1;
		
		marr(arr, 1);
		
		br.close();
		bw.flush();
		bw.close();
	}

	public static void marr(int[] arr, int cur) throws IOException {
		//arr: 순열 저장, cur: 현재 순서
		//순열의 수가 M과 같으면 출력
		//dfs로 1<=A(n-1)<=A(n)<=N
		
		int pre = arr[cur-1];
		
		for (int i=pre; i<=N; i++) {
			arr[cur] = i;
			
			if (cur == M) {
				for (int j=1; j<=cur; j++) {
					bw.write(arr[j] + " ");
				}
				bw.write("\n");
			}
			
			if (cur < M) {
				marr(arr, cur+1);
			}
		}
		
	}

}
