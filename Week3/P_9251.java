import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*LCS*/

public class P_9251 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] word1 = br.readLine().toCharArray();
		char[] word2 = br.readLine().toCharArray();
		int[][] dp = new int[word1.length+1][word2.length+1];// 공집합 표현을 위해 +1 
		for(int i = 1 ; i <= word1.length;i++) {
			for(int j = 1;j <= word2.length;j++) {
				if(word1[i-1]== word2[j-1])
					dp[i][j] = dp[i-1][j-1]+1; //대각선 위의 dp에 +1
				else
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]); //이전 열과 이전 행의 값 중 큰거 
			}
		}
		bw.write(dp[word1.length][word2.length]+"\n");
		bw.flush();
		bw.close();
		br.close();

	}

}
