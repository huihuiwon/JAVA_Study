import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*종이의 개수 */
public class P_1780 {
	static int[] result = new int[3];
	static int n;
	static int[][] map;
	
	private static boolean check(int x,int y , int size) {
		for(int i = x ; i < size+x;i++) {
			for(int j = y; j < size+y;j++) {
				if(map[x][y] != map[i][j])
					return false;
			}
			
		}
		return true;
	}
	private static void Paper(int x,int y,int size) {
		if(check(x,y,size)) {
			result[map[x][y]+1]++;
			return;
		}
		int m = size/3; // 9개로 자름
		for(int i = 0 ; i < 3; i++) {
			for(int j = 0 ; j <3;j++) {
				Paper(x+i*m, y+j*m,m);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		StringTokenizer st;
		for(int i = 0 ; i < n ;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j <n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		Paper(0,0,n);
		
		for(int i = 0 ; i < 3 ; i++) bw.write(result[i]+"\n");
		bw.flush();
		bw.close();
		br.close();
	
	}

}
