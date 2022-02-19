import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*이항계수2*/
public class P_11051 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s= br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int N = Integer.parseInt(st.nextToken()); 
		int K = Integer.parseInt(st.nextToken());
		long[][] num = new long[1001][1001];
		
		if(N ==0) bw.write("0");
		else
		{
			for(int i = 1 ; i <= N ;i++) {
				for(int j = 0 ; j <=K;j++) {
					if(i == j || j ==0) {
						num[i][j] = 1;
					}
					else {
						num[i][j] = (num[i-1][j-1] + num[i-1][j])%10007;
					}
				}
			}
		}
		
		bw.write(num[N][K]+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
