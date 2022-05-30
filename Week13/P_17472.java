import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_17472 {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	static int[][] map;
	static PriorityQueue<Bridge> pq;
	static int[] parent;

	static class Pos {
		int x;
		int y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Bridge implements Comparable<Bridge> {
		int from;
		int to;
		int weight;
		
		public Bridge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Bridge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//������ ��ȣ �ο�, ���� ���� ����
		int landCnt = getLandCnt();
		
		//������ ���� ������ �ٸ� ã�� - �켱���� ť�� ����
		findBridge();
		
		//�ּ� ���� Ʈ�� ����� - ũ�罺Į �˰���
		int len = Kruskal(landCnt);
		if (len == 0) {
			bw.write("-1");
		}
		else {
			bw.write(String.valueOf(len));
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static int getLandCnt() {
		int cnt = 0;
		
		boolean[][] visited = new boolean[map.length][map[0].length];
		
		Queue<Pos> q = new LinkedList<>();
		
		for (int i=0; i<map.length; i++) {
			for (int j=0; j<map[0].length; j++) {
				if (map[i][j]==1 && !visited[i][j]) {
					cnt++;
					map[i][j] = cnt;
					visited[i][j] = true;
					q.add(new Pos(j, i));
					while (!q.isEmpty()) {
						Pos p = q.remove();
						for (int k=0; k<4; k++) {
							int x = p.x + dx[k];
							int y = p.y + dy[k];
							if (x < 0 || x >= map[0].length || y < 0 || y >= map.length)
								continue;
							if (map[y][x]==1 && !visited[y][x]) {
								map[y][x] = cnt;
								visited[y][x] = true;
								q.add(new Pos(x, y));
							}
						}
					}
				}
			}
		}
		
		return cnt;
	}

	public static void findBridge() {
		pq = new PriorityQueue<>();
		
		for (int i=0; i<map.length; i++) {
			for (int j=0; j<map[0].length; j++) {
				if (map[i][j] != 0) {
					//������ ���μ���(�����¿�)�� �ٸ� ���� ����Ǵ��� Ȯ��
					for (int k=0; k<4; k++) {
						int x = j;
						int y = i;
						int dist = -1;
						while (true) {
							x += dx[k];
							y += dy[k];
							dist++;
							//�� ������ ����ų� ���� ���̸� X
							if (x < 0 || x >= map[0].length || y < 0 || y >= map.length || map[y][x] == map[i][j])
								break;
							//�ٸ� ���� ����Ǵ� ���� 2�̻��� �ٸ� ����
							if (map[y][x] != 0) {
								if (dist >= 2)
									pq.add(new Bridge(map[i][j], map[y][x], dist));
								break;
							}
						}
					}
				}
			}
		}
	}
	
	public static int Kruskal(int landCnt) {
		int len = 0;
		
		parent = new int[landCnt+1];
		for (int i=0; i<=landCnt; i++) {
			parent[i] = i;
		}
		
		//(���� ����-1)�� �ٸ� �����
		while (!pq.isEmpty()) {
			Bridge n = pq.remove();
			if (find(n.from) != find(n.to)) {
				len += n.weight;
				union(n.from, n.to);
				landCnt--;
			}
			if (landCnt == 1) 
				break;
		}
		
		return (landCnt == 1) ? len : 0;
	}
	
	public static int find(int a) {
		if (parent[a] == a)
			return a;
		else 
			return parent[a] = find(parent[a]);
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			if (a < b)
				parent[b] = a;
			else 
				parent[a] = b;
		}
	}
}
