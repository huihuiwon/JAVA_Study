import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*동전1 - 동적계획법2*/
public class P_2293 {
	static int K;
	static int[] coin;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		coin = new int[N];
		int[] dp = new int[K+1];
		for(int i = 0 ; i < N ;i ++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = 1;
		for(int i = 0;i<N;i++) {
			for(int j = coin[i]; j <= K;j++) {
				dp[j] += dp[j-coin[i]];
			}
		}
		bw.write(dp[K]+"\n");
		bw.flush();
		br.close();
		bw.close();

	}

}
