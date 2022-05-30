package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Node2{
	int n;
	int w;
	Node2(int n,int w) {
		this.n=n;
		this.w=w;
	}
}

public class N_1967 {
	public static ArrayList<Node2> list[];
	public static boolean visited[];
	public static int answer=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		list=new ArrayList[n+1];
		visited=new boolean[n+1];
		
		for(int i=1;i<=n;i++)list[i]=new ArrayList<>();
		
		for(int i=0;i<n-1;i++) {
			String[] str=br.readLine().split(" ");
			int p=Integer.parseInt(str[0]);
			int c=Integer.parseInt(str[1]);
			int w=Integer.parseInt(str[2]);
			
			list[p].add(new Node2(c,w));
		}
		
		visited[1]=true;
		dfs(1);
		System.out.println(answer);
	}
	public static int dfs(int now) {
		int max1=0;
		int max2=0;
		for(Node2 node:list[now]) {
			if(!visited[node.n]) {
				int value=dfs(node.n)+node.w;

				if(max1<value) {
					max2=max1;
					max1=value;					
				}
				else if(max2<value)max2=value;
				
				visited[node.n]=true;
			}
		}
		if(max1!=0&&max2!=0) {
			answer=Math.max(max1+max2, answer);
		}
		else {
			answer=Math.max(max1, answer);
		}
		return max1;
	}
}
