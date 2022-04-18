import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P_10844 {
	private static long[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		long result = 0;
		
		dp = new long[N+1][10];
		
		//N이 1인 경우
		for (int i=0; i<=9; i++) {
			dp[1][i] = 1;
		}
		
		//N번째 자리: 1-9
		for (int i=1; i<=9; i++) {
			//N-1자리까지 경우의 수
			result += stair(N, i);
		}
		
		bw.write(String.valueOf(result%1000000000));
		
		br.close();
		bw.flush();
		bw.close();
	}

	public static long stair(int n, int cur) {
		//n일 때 값이 없으면 n-1의 값을 찾아 계산
		//dp[n][0] = dp[n-1][1]
		//dp[n][9] = dp[n-1][8]
		//dp[n][1-8] = dp[n-1][(1-8)±1]
		if (dp[n][cur] == 0) {
			if (cur == 0) {
				dp[n][cur] = stair(n-1, 1) % 1000000000;
			}
			else if (cur == 9) {
				dp[n][cur] = stair(n-1, 8) % 1000000000;
			}
			else {
				dp[n][cur] = (stair(n-1, cur-1) + stair(n-1, cur+1)) % 1000000000;
			}
		}
		
		return dp[n][cur];
	}
}
