import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P_9663 {
	private static int N;
	private static int[] Qcol;
	private static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		Qcol = new int[N];
		nQueen(0);
		
		bw.write(String.valueOf(result));
		
		br.close();
		bw.flush();
		bw.close();
	}

	
	public static void nQueen(int cnt) {
		//퀸을 놓은 자리에서 상하좌우대각선 X
		//퀸은 한줄마다 하나만 가능 = 한 row에 하나의 퀸
		if (cnt == N) {
			result++;
			return ;
		}
		
		for (int col=0; col<N; col++) {
			if (check(cnt, col)) {
				Qcol[cnt] = col;
				nQueen(cnt+1);
			}
		}
	}
	
	public static boolean check(int row, int col) {
		for (int r=0; r<row; r++) {
			//상하 체크
			if (Qcol[r] == col) {
				return false;
			}
			
			//대각선 체크(=> 현재와 다른 퀸 위치의 가로/세로 간격이 같음)
			if ((row-r) == Math.abs(col-Qcol[r])) {
				return false;
			}
		}
		
		return true;
	}
	
}
