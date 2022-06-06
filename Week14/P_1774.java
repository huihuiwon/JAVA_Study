import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*우주신과의 교감 */
public class P_1774 {
	static class Point{ //신들의 좌표와 순번 
        int num;
        double x,y;
        Point(int num,double x, double y){
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
	static class Edge implements Comparable<Edge>{ // 한 신에서 다른 신으로 갈때 Point와 그 가중치를 갖는 edge클래스 
        int start;
        int end;
        double weight;

        Edge(int start, int end, double weight){
            this.start = start;
            this.end =end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight < o.weight ? -1 : 1;
        }
    }
	
	static int[] parent;
	static ArrayList<Edge> edgeList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        parent = new int[n+1];
        for(int i =0;i<=n;i++) {
        	parent[i] = i;
        }
        Point[] points = new Point[n+1];
        //좌표를 넣고 그 순서를 넣는 for 문
        for(int i = 1;i<=n;i++) {
        	st = new StringTokenizer(br.readLine());
        	double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            points[i] = new Point(i,x,y);
        }
     // 이미 연결된 점들을 표현하기 위한 for문
        for(int i = 0; i<m;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            union(start,end);
        }
      //edgeList에 좌표의 순서와 가중치를 넣는다
        edgeList = new ArrayList<>();
        for(int i = 1;i<=n;i++){
            for(int j = i+1;j<=n;j++){
                double weight = distance(points[i],points[j]);

                edgeList.add(new Edge(points[i].num,points[j].num,weight));
            }
        }
        Collections.sort(edgeList);

        double ans = 0;

        for(int i = 0; i<edgeList.size();i++){
        	
            Edge edge = edgeList.get(i);
            if(find(edge.start) != find(edge.end)){
                ans += edge.weight;
                union(edge.start, edge.end);
            }
        }

        bw.write(String.format("%.2f",ans)+ "\n");
        bw.flush();
        bw.close();
        br.close();
        

	}
	private static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x-p2.x,2)+ Math.pow(p1.y-p2.y,2));
    }
	public static int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y){
            parent[y] = x;
        }
    }

}
