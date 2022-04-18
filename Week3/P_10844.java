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
		
		//N�� 1�� ���
		for (int i=0; i<=9; i++) {
			dp[1][i] = 1;
		}
		
		//N��° �ڸ�: 1-9
		for (int i=1; i<=9; i++) {
			//N-1�ڸ����� ����� ��
			result += stair(N, i);
		}
		
		bw.write(String.valueOf(result%1000000000));
		
		br.close();
		bw.flush();
		bw.close();
	}

	public static long stair(int n, int cur) {
		//n�� �� ���� ������ n-1�� ���� ã�� ���
		//dp[n][0] = dp[n-1][1]
		//dp[n][9] = dp[n-1][8]
		//dp[n][1-8] = dp[n-1][(1-8)��1]
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
