package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Node1 implements Comparable<Node1>{
	int start;
	int end;
	double cost;
	
	Node1(int start,int end,double cost){
		this.start=start;
		this.end=end;
		this.cost=cost;
	}
	
	@Override
	public int compareTo(Node1 o) {
		return o.cost >= this.cost ? -1:1;
	}
}

public class N_1774 {
	public static double[][] map;
	public static ArrayList<int[]> list;
	public static int[][] graph;
	
	public static void main(String[] args) throws IOException {
		double answer=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		list = new ArrayList<int[]>();
		
		String[] str = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		map = new double[n][n];		
		
		for(int i=0;i<n;i++) {
			str= br.readLine().split(" ");
			list.add(new int[] {Integer.parseInt(str[0]),Integer.parseInt(str[1])});
		}
		
		cal_length(n);
		
		for(int i=0;i<m;i++) {
			str= br.readLine().split(" ");
			int d1=Integer.parseInt(str[0])-1;
			int d2=Integer.parseInt(str[1])-1;
			
			map[d1][d2]=0;
			map[d2][d1]=0;
		}
		
		answer=prim(n,0);
		System.out.println(String.format("%.2f",answer));
	}
	
	public static double prim(int n,int start) {
		double costs=0;
		boolean[] visited = new boolean[n];
		PriorityQueue<Node1> pq= new PriorityQueue<Node1>();
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(start);
		
		while(!q.isEmpty()) {
			int node =q.poll();
			visited[node]=true;
			
			for(int i=0;i<n;i++) {
				if(!visited[i]&&map[node][i]>=0) {
					pq.add(new Node1(node,i,map[node][i]));
				}
			}
			
			while(!pq.isEmpty()) {
				Node1 e=pq.poll();
				
				if(!visited[e.end]) {
					visited[e.end]=true;
					q.add(e.end);
					costs+=e.cost;
					break;
				}
			}
			
		}
		
		return costs;
	}
	
	public static void cal_length(int n) {
		long xd;long yd;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==j) {
					map[i][j]=-1;
					continue;
				}
				
				int[] a=list.get(i);
				int[] b=list.get(j);
				
				yd= (long)Math.pow((a[1]-b[1]), 2);
				xd= (long)Math.pow((a[0]-b[0]), 2);
				map[i][j]=Math.sqrt(yd+xd);
			}
		}
	}

}
