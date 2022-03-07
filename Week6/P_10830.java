import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/*행렬 곱*/
public class P_10830 {
	static int N;
	static int[][] matrix;
	static final int MOD = 1000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		matrix = new int[N][N];
		for(int i = 0 ; i < N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j< N ; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken())%MOD;
			}
		}
		
		int[][] res = mul(B);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
							bw.write(res[i][j] + " ");
						}
						bw.write("\n");
					}
					bw.flush();
				
		bw.close();
		br.close();
	}
	public static int[][] mul(long cnt){
		if(cnt ==1) return matrix;
		
		int[][] res = mul(cnt/2); //지수를 절반으로 분할 
		
		if(cnt %2 ==0) { 
			return cal(res,res);
		}
		else { //홀수일 때 
			int[][] res2 = cal(res,matrix);
			return cal(res,res2);
		}
		
		
	}
	public static int[][] cal(int[][] A,int[][] B){
		int[][]tmp= new int[N][N];
		for(int i = 0 ; i < N;i++) {
			for(int j = 0 ; j < N;j++) {
				for(int k = 0 ; k < N;k++) {
					tmp[i][j] += (A[i][k] * B[k][j])%MOD;
				}
				tmp[i][j] %= MOD;
			}
			
		}
		return tmp;
	}
}
