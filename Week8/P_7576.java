import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*단지번호 붙이기 */
public class P_2667 {
	private static int[][] map;
	private static boolean[][] visited;
	private static int aptNum = 0; //총 단지수 
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	static int n;
	static ArrayList al = new ArrayList();
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = sc.nextInt();
		map = new int[n][n];
		visited = new boolean[n][n];
		for(int i = 0 ; i < n ; i++) {
			String input = sc.next();
			for(int j = 0 ; j < n ; j++) {
				map[i][j] = input.charAt(j)-'0';
			}
		}
		for(int i = 0 ; i < n ;i++) {
			for(int j = 0 ; j < n ; j++) {
				if(map[i][j] ==1 && !visited[i][j]) {
					aptNum=1;
					dfs(i,j);
					al.add(aptNum);
				}
			}
		}
		Collections.sort(al);
		bw.write(al.size()+"\n");
		for(int i = 0 ; i < al.size();i++) {
			bw.write(al.get(i)+"\n");
		}
		bw.flush();
		bw.close();

	}
	private static int dfs(int x,int y) {
		visited[x][y] = true;
		int ny,nx;
		for(int i = 0 ; i < 4 ; i++) {
			nx = x +dy[i];
			ny = y+ dx[i];
			if(ny>=0 && ny<n && nx>=0 && nx<n) {
				if(!visited[nx][ny] && map[nx][ny]==1) {
					dfs(nx,ny);
					aptNum++;
				}
			}
			
		}
		return aptNum;
	}
}
