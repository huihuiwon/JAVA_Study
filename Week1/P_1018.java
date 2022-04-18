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
		
		//���� ���� �迭�� ����
		char[][] board = new char[N][M];
		
		for (int i=0; i<N; i++) {
			String s = br.readLine();
			for (int j=0; j<M; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		
		//�ٽ� ĥ�ؾ� �ϴ� �ּ� ����
		int min = 64;
		
		//[B/W]�� �����ϴ� ��� �ּ� ���� Ž��
		//B: n�� -> W: 64-n��
		for (int i=0; i<N-7; i++) {
			for (int j=0; j<M-7; j++) {
				//B�� ����
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
				//W�� ����
				min = Math.min(min, 64-cnt);
			}
		}
		
		System.out.println(min);
		
		br.close();
	}

}
