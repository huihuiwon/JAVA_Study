import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*이분 그래프 */
public class P_1707 {
    public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        for (int tc = 0; tc < K; tc++) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            LinkedList<Integer>[] graph = new LinkedList[V];
            for (int i = 0; i < V; i++) {
                graph[i] = new LinkedList<>();
            }
            for (int i = 0; i < E; i++) {
                int s = sc.nextInt() - 1;
                int e = sc.nextInt() - 1;
                graph[s].add(e);
                graph[e].add(s);
            }

            boolean flag = true;
            int[] visit = new int[V];
            Queue<Integer> q = new LinkedList<>();

            for (int i = 0; i < V; i++) {
                if (visit[i] == 0) {
                    q.offer(i);
                    visit[i] = 1;

                    while (!q.isEmpty() && flag) {
                        int cur = q.poll();
                        for (Integer next : graph[cur]) {
                            if (visit[next] == 0) {
                                q.offer(next);
                                visit[next] = visit[cur] * -1;
                            } else if (visit[next] == visit[cur]) {
                                flag = false;
                                break;
                            }
                        }
                    }

                }
            }
            if (flag)
                bw.write("YES\n");
            else
                bw.write("NO\n");
        }
        bw.flush();
        bw.close();
    }
}
