import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_7576 {
	private static int M;
	private static int N;
	private static int[][] box;
	private static Queue<int[]> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		//상자 토마토 정보 저장
		//토마토 상태가 1인 위치를 큐에 저장
		box = new int[N][M];
		q = new LinkedList<int[]>();
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j=0; j<M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) {
					q.add(new int[] {i,j});
				}
			}
		}
		
		System.out.println(bfs());
		
		br.close();
	}
	
	public static int bfs() {
		//상하좌우 이동
		int[] mx = new int[] {-1, 1, 0, 0};
		int[] my = new int[] {0, 0, -1, 1};
		//마지막 토마토가 익은 날 기록
		int day = 0;
		
		while (!q.isEmpty()) {
			int[] index = q.remove();
			//익은 토마토 날짜의 최댓값 저장
			day = Math.max(day, box[index[0]][index[1]]);
			//상하좌우 안 익은 토마토 찾으면 일수+1로 변경
			for (int k=0; k<4; k++) {
				int x = index[0] + mx[k];
				int y= index[1] + my[k];
				if (x>=0 && y>=0 && x<N && y<M && box[x][y]==0) {
					q.add(new int[]{x,y});
					box[x][y] = box[index[0]][index[1]] + 1;
				}
			}
		}
		//안 익은 토마토 있는지 확인
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (box[i][j] == 0) {
					return -1;
				}
			}
		}
		
		return day-1;
	}
	
}
