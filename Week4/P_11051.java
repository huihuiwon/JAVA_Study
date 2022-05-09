import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P_11051 {
	static int[][] C;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		C = new int[N+1][K+1];
		
		bw.write(String.valueOf(binom(N, K)));
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static int binom(int N, int K) {
		if (K==0 || K==N) {
			return 1;
		}
		if (C[N][K] == 0) {
			C[N][K] = (binom(N-1, K-1) + binom(N-1, K)) % 10007;
		}
		return C[N][K];
	}

}
