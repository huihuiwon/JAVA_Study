import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_1018 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//보드 정보 배열에 저장
		char[][] board = new char[N][M];
		
		for (int i=0; i<N; i++) {
			String s = br.readLine();
			for (int j=0; j<M; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		
		//다시 칠해야 하는 최소 개수
		int min = 64;
		
		//[B/W]로 시작하는 경우 최소 개수 탐색
		//B: n개 -> W: 64-n개
		for (int i=0; i<N-7; i++) {
			for (int j=0; j<M-7; j++) {
				//B로 시작
				char color = 'B';
				int cnt = 0;
				for (int k=i; k<i+8; k++) {
					for (int l=j; l<j+8; l+=2) {
						if (board[k][l] != color) {
							cnt++;
						}
					}
					color = (color == 'B') ? 'W' : 'B';
					for (int l=j+1; l<j+8; l+=2) {
						if (board[k][l] != color) {
							cnt++;
						}
					}
				}
				min = Math.min(min, cnt);
				//W로 시작
				min = Math.min(min, 64-cnt);
			}
		}
		
		System.out.println(min);
		
		br.close();
	}

}
