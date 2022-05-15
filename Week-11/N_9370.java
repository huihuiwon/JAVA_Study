package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;



public class N_9370 {
	static StringBuilder sb;
	
	static class Node implements Comparable<Node>{
		int idx, weight;
		public Node(int idx, int weight) {
			this.idx = idx;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node node) {
			return Integer.compare(this.weight, node.weight);
			
		}
	}

	static class Graph{
		private int n; 
		private ArrayList<Node> maps[];
		
		public Graph(int n) {
			this.n=n;
			maps=new ArrayList[n+1];
			for(int i=1;i<n+1;i++)maps[i]=new ArrayList<Node>();
		}
		
		public void input(int i,int j,int w) {
			maps[i].add(new Node(j,w));
			maps[j].add(new Node(i,w));
		}
		
		
		public int[] dijkstra(int v) {
			//����ġ�� ���� ������ �����ϱ� ���� �켱���� ť ���
			PriorityQueue<Node> queue = new PriorityQueue<>();
			
			int distance[]=new int[n+1];//�ִܰŸ� ����
			
			//distance �� �ʱ�ȭ
			for(int i=1;i<n+1;i++)distance[i]=Integer.MAX_VALUE;
			
			//���۳�尪 �ʱ�ȭ
			distance[v]=0;
			queue.add(new Node(v,0));
			
			
			while(!queue.isEmpty()) {
				//queue �� ������� ������
				
				int min = Integer.MAX_VALUE;
				int min_index=-1;
				
				Node node=queue.poll();
				min=node.weight;
				min_index=node.idx;
				
				
				//�ٸ� ��带 ���ļ� ���� ���� �� ����� ������ Ȯ���Ѵ�.
				for(Node node2:maps[min_index]) {
					if(distance[node2.idx]>distance[min_index]+node2.weight) {
						distance[node2.idx]=distance[min_index]+node2.weight;
						queue.add(new Node(node2.idx,node2.weight));
					}
				}
			}
		
			/*for(int i=1;i<n+1;i++) {
				System.out.print(distance[i]+" ");
			}
			System.out.println();*/		
			return distance;

		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		sb=new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test=Integer.parseInt(br.readLine());
		
		for(int i=0;i<test;i++){
			String[] str=br.readLine().split(" ");
			int n=Integer.parseInt(str[0]);
			int m=Integer.parseInt(str[1]);
			int t=Integer.parseInt(str[2]);
			int w=0;
			Graph ga = new Graph(n);
			str=br.readLine().split(" ");
			int s=Integer.parseInt(str[0]);
			int g=Integer.parseInt(str[1]);
			int h=Integer.parseInt(str[2]);
			
			for(int j=0;j<m;j++) {
				str=br.readLine().split(" ");
				int a =Integer.parseInt(str[0]);
				int b=Integer.parseInt(str[1]);
				int d=Integer.parseInt(str[2]);
				if( (a==g&&b==h)||(a==h&&b==g))w=d;
				ga.input(a,b,d);
			}
			
			int[] data1 = ga.dijkstra(s); //1��
			
			//g,h �� ������ ���� 0���� ������Ʈ.
			ga.input(g, h, 0);
			
			int[] data2 = ga.dijkstra(s); //2��
			
			//������ �ĺ� end�� �Է¹���
			int[] end=new int[t];
			for(int j=0;j<t;j++) {
				end[j]=Integer.parseInt(br.readLine());
			}
			Arrays.sort(end); //�������� ����
			
			// data1 == data2 + g-h ���� �̸� ���
			for(int j=0;j<t;j++) {
				if(data1[end[j]]==data2[end[j]]+w)sb.append(end[j]+" ");
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
	}

}
