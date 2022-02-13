import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*쉬운 계단수 */

public class P_10844 {
	
	static long mod = 1000000000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine()); // N
		long[][] dp =  new long[N+1][10]; //경우의 수 세기 위해 
		
		for(int i = 1 ; i < 10;i++) {
			dp[1][i] = 1;
		}
		
		for(int i = 2; i<=N;i++) {
			for(int j = 0;j<10;j++) {
				if(j == 0)
					dp[i][j] = dp[i-1][1] % mod;
				else if( j ==9)
					dp[i][j] = dp[i-1][8]%mod ;
				else
					dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%mod;
			}
		}
		long result =0;
		for(int i =0;i<10;i++) {
			result += dp[N][i];
		}
		result= result %mod;
		bw.write(result+"\n");
		bw.flush();
		bw.close();
		br.close();
		
	}

}
