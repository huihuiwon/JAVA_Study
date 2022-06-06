import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge> {
    int s;
    int e;
    int v;
    
    public Edge(int s,int e,int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }
 
    @Override
    public int compareTo(Edge o) {
        return this.v-o.v;
    }
}

class Dot {
    int x;
    int y;
    
    public Dot(int x,int y) {
        this.x = x;
        this.y = y ;
    }
}

public class Main {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    static int island = 0;
    static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
    static int result = 0;    
    static int[] p;
    static int bridge_cnt = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        
        map = new int[n][m];
        visited = new boolean[n][m];
        
        for(int i=0; i<n; i++) {
            str = br.readLine().split(" ");
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        
        for(int i=0; i<n; i++) {
    		for(int j=0; j<m; j++) {
    			if(map[i][j]==1 && !visited[i][j]) {
    				island++;
    				bfs(new Dot(i, j));
    			}
    		}
    	}

		visited=new boolean[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]!=0) {
					make(new Dot(i, j), map[i][j]);
				}
			}
		}
        
		p=new int[island+1];
		for(int i=0; i<p.length; i++)
			p[i]=i;
		
		int size=pq.size();
		for(int i=0; i<size; i++) {
			Edge now=pq.poll();
			
			int a=find(now.s);
			int b=find(now.e);
			
			if(a==b) continue;
			union(now.s, now.e);
			result+=now.v;
			bridge_cnt++;
		}
    	if(result==0 || bridge_cnt != island-1) System.out.println(-1);
			else System.out.println(result);
    }
 
    static void bfs(Dot d) {
    	Queue<Dot> q = new LinkedList<>();
		visited[d.x][d.y]=true;
		map[d.x][d.y]=island;
		q.add(d);
		
		while(!q.isEmpty()) {
			Dot cur=q.poll();
			for(int dir=0; dir<4; dir++) {
				int nx=cur.x+dx[dir];
				int ny=cur.y+dy[dir];
				
				if(nx<0 || ny<0 || nx>=n || ny>=m || map[nx][ny]==0 || visited[nx][ny]) continue;
				q.add(new Dot (nx, ny));
				map[nx][ny]=island;
				visited[nx][ny]=true;
			}
		}
    }

    public static void make(Dot d, int num) {
    	int x=d.x; int y=d.y;
    	int len=0;
    	for(int dir=0; dir<4; dir++) {
    		while(true) {
    			x=x+dx[dir];
    			y=y+dy[dir];
    			
    			if(x>=0 && x<n && y>=0 && y<m) {
    				if(map[x][y] == num) {
    					len=0;
    					x=d.x; y=d.y;
    					break;
    				}
    				else if(map[x][y]==0)
    					len++;
    				else {
    					if(len>1)
    						pq.add(new Edge(num, map[x][y], len));
    					
    					len=0;
    					x=d.x;
    					y=d.y;
    					break;
    				}
    			}
    			else {
    				len=0;
    				x=d.x; y=d.y;
    				break;
    			}
    		}
    	}
    }
    public static int find(int a) {
        if(a == p[a]) return a;
        return p[a] = find(p[a]);
    }
    
    public static void union(int a,int b) {
        if(find(a) != find(b)) {
            p[find(a)] = b;
        }
        else 
            return;
        
    }
}
 
