package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

class Node2{
	int v, weight;
	public Node2(int v,int weight) {
		this.v=v;
		this.weight=weight;
	}
}

class Graph{
	private int n; //������ ��
	//private int maps[][]; //���鰣�� ����ġ ������ ����
	private ArrayList<Node2> maps[]; 
	
	public Graph(int n) {
		this.n=n;
		maps =new ArrayList[n+1];
		for(int i=1;i<n+1;i++)maps[i]=new ArrayList<Node2>();
	}
	
	public void input(int i,int j,int w) {
		//�� ���� ���̿� ���� ���� ������ ������ �� ����. �ּҰ� �־�����.
		
		maps[i].add(new Node2(j,w));
		maps[j].add(new Node2(i,w));
	}
	
	public void dijkstra(int v) {
		int distance[]=new int[n+1];//�ִܰŸ� ����
		boolean[] check=new boolean[n+1]; //�ش� ��带 �湮�ߴ��� üũ
		
		//distance �� �ʱ�ȭ
		for(int i=1;i<n+1;i++)distance[i]=Integer.MAX_VALUE;
		
		//���۳�尪 �ʱ�ȭ
		distance[v]=0;
		check[v]=true;
		
		//������ distance ����
		for(Node2 Node2:maps[v]) {
			if(!check[Node2.v]) {
				distance[Node2.v]=Math.min(Node2.weight,distance[Node2.v]);
			}
		}	
			
		//n-1 �� �ݺ�. ��尡 n�� ���� �� ���ͽ�Ʈ�� ���ؼ� �ݺ��ϴ� Ƚ���� n-1���̸� �ȴ�.
		for(int a=0;a<n-1;a++) {
			int min=Integer.MAX_VALUE;
			int min_index=-1;
			
			//�ּҰ� ã��
			for(int i=1;i<n+1;i++) {
				if(!check[i]&&distance[i]!=Integer.MAX_VALUE) {
					if(distance[i]<min) {
						min=distance[i];
						min_index=i;
					}
				}
			}
			if(min_index==-1)continue;
			
			check[min_index]=true;
			
			
			for(Node2 Node2:maps[min_index]) {
				if(!check[Node2.v]&&distance[Node2.v]>distance[min_index]+Node2.weight) {
					distance[Node2.v]=distance[min_index]+Node2.weight;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<n+1;i++) {
			if(distance[i]==Integer.MAX_VALUE)sb.append("INF\n");
			else sb.append(distance[i]+"\n");
		}
		System.out.print(sb);
	}	
}

public class N_1753 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] a=br.readLine().split(" ");
		int v = Integer.parseInt(a[0]);
		int e = Integer.parseInt(a[1]);
		int k=Integer.parseInt(br.readLine());
		Graph g = new Graph(v);
		for(int i=0;i<e;i++) {
			a= br.readLine().split(" ");
			g.input(Integer.parseInt(a[0]),Integer.parseInt(a[1]),Integer.parseInt(a[2]));
		}
		g.dijkstra(k);
	}

}
