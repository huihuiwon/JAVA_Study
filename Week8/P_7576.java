import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*토마토 */
public class P_7576 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dy = { -1, 1, 0, 0 };
        int[] dx = { 0, 0, -1, 1 };
        int M = sc.nextInt(), N = sc.nextInt();

        int[][] arr = new int[N][M];
        int cnt = 0, days = 0;
        Queue<int[]> que = new LinkedList<>();

        for (int n = 0; n < N; n++)
            for (int m = 0; m < M; m++) {
                arr[n][m] = sc.nextInt();
                if (arr[n][m] == 1)
                    que.add(new int[] { n, m });
                else if (arr[n][m] == 0)
                    cnt++;
            }

        while (cnt > 0 && !que.isEmpty()) {
            for (int s = que.size(); s > 0; s--) {
                int[] cur = que.poll();

                for (int k = 0; k < 4; k++) {
                    int ny = cur[0] + dy[k];
                    int nx = cur[1] + dx[k];

                    if (ny < 0 || nx < 0 || ny >= N || nx >= M || arr[ny][nx] != 0)
                        continue;

                    cnt--;
                    arr[ny][nx] = 1;
                    que.add(new int[] { ny, nx });
                }
            }
            days++;
        }
        System.out.println(cnt == 0 ? days : -1);

    }
}
 
