package topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class N_2252 {
	public static int n;
	public static int m;
	public static ArrayList<ArrayList<Integer>> graph;
	public static int[] in_cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str =br.readLine().split(" ");
		
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		
		in_cnt = new int[n+1];
		graph = new ArrayList<>();
		for(int i=0;i<n+1;i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<m;i++) {
			str = br.readLine().split(" ");
			int a=Integer.parseInt(str[0]);
			int b=Integer.parseInt(str[1]);
			graph.get(a).add(b);
			in_cnt[b]+=1; //�������� +1 ����
		}
		
		tp_sort();
	}
	
	public static void tp_sort() {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		//���������� 0�� ��带 ť�� ����
		for(int i=1;i<n+1;i++) {
			if(in_cnt[i]==0)queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			sb.append(now+" ");
			
			//���� ���� ����� �ٸ� ���� Ž��
			for(int node:graph.get(now)) {
				//���� ����
				in_cnt[node]-=1;
				
				//���������� 0 �̸� queue �� ����
				if(in_cnt[node]==0)queue.add(node);
			}
			
		}
		System.out.println(sb);
	}

}
