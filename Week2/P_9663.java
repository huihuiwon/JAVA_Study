import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P_9663 {
/*N-Queen*/
	
	public static BufferedReader br;
	public static BufferedWriter bw; 
	public static int N;
	public static int[] chess;
	public static int count = 0;
	
	private static boolean check(int col) {
		for(int i =0;i<col;i++) { // 해당 열전까지만 탐 
			if(chess[col] == chess[i]) { // 같은 행에 존재하는 지 
				return false;
			}
			else if(Math.abs(col-i) == Math.abs(chess[col]-chess[i])) { //대각선에 놓인 경우 
				return false;
			}
		}
		return true;
		
	}
	
	static void nqueen(int col) {
		if(col == N) {//행을 다 채운 경우 
			count ++;
			return;
		}
		for(int i = 0 ; i<N;i++) {
			chess[col] = i;
			if(check(col)){
				nqueen(col+1);
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine()); //퀸 개수 
		chess = new int[N]; //체스판 index열을 가르킨다.
		nqueen(0);
		
		bw.write(count+"\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
