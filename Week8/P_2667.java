import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class P_2667 {
	private static int[][] map;
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		//지도 정보 저장
		map = new int[N][N];
		for (int i=0; i<N; i++) {
			String input = br.readLine();
			for (int j=0; j<N; j++) {
				map[i][j] = input.charAt(j)-'0';
			}
		}

		bfs();

		br.close();
	}
	
	public static void bfs() {
		boolean[][] visited = new boolean[N][N];
		//mset: 결과 저장 (size=단지 수, 각 값=단지 내 집의 수)
		ArrayList<Integer> mset = new ArrayList<Integer>();
		Queue<int[]> q = new LinkedList<int[]>(); //{x,y}
		
		//상하좌우 이동
		int[] mx = new int[] {-1, 1, 0, 0};
		int[] my = new int[] {0, 0, -1, 1};
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) { 
				//새로운 단지 발견하면 단지 내 집의 수 기록 시작
				if (map[i][j] == 1 && visited[i][j] == false) {
					int cnt = 1;
					q.add(new int[]{i,j});
					visited[i][j] = true;
					while (!q.isEmpty()) {
						int[] index = q.remove();
						//상하좌우 집 새로 발견하면 단지 내 집의 수 +1
						for (int k=0; k<4; k++) {
							int x = index[0] + mx[k];
							int y= index[1] + my[k];
							if (x>=0 && y>=0 && x<N && y<N && map[x][y]==1 && visited[x][y]==false) {
								q.add(new int[]{x,y});
								visited[x][y] = true;
								cnt++;
							}
						}
					}
					mset.add(cnt);
				}
			}
		}
		
		//단지 수와 단지 내 집의 수 오름차순 출력
		Collections.sort(mset);
		System.out.println(mset.size());
		for (int i: mset) {
			System.out.println(i);
		}
	}

}
