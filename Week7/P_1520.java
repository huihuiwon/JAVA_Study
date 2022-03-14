import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*내리막길 */
public class P_1520 {
	static int N;
	static int M;
	static int[][] dp;
	static int[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		dp = new int[N+1][M+1];
		
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		bw.write(dfs(1,1)+"\n");
		bw.flush();
		br.close();
		bw.close();

	}
	private static int dfs(int x , int y) {
		if(x==N && y == M) { // 오른쪽 맨 아래에 도착했을 경우 
			return 1;
		}
		if(dp[x][y] != -1) { //이미 방문했을 경우 
			return dp[x][y];
		}else { // -1인 경우
			dp[x][y] =0;
			for(int i = 0 ; i < dx.length;i++) { // 인접한 4방향 좌표 구하기 
				int nx = x+dx[i];
				int ny = y + dy[i];
				
				if(nx<1||ny<1||nx>N||ny>M) {
					continue;
				}
				if(map[x][y]>map[nx][ny]) {
					dp[x][y] += dfs(nx,ny);
				}
			}
		}
		return dp[x][y];
	}

}
