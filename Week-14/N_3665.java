package topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class N_3665 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int test = Integer.parseInt(br.readLine());
		
		for(int i=0;i<test;i++) {
			int n = Integer.parseInt(br.readLine());
			
			String[] str = br.readLine().split(" ");
			int[] arr = new int[n+1];
			int[] in_cnt=new int[n+1];
			for(int j=0;j<n;j++) {
				int c =Integer.parseInt(str[j]);
				arr[c]=j+1;
				in_cnt[c]=j;
			}
			int m = Integer.parseInt(br.readLine());
			
			for(int j=0;j<m;j++) {
				str=br.readLine().split(" ");
				int a=Integer.parseInt(str[0]);
				int b=Integer.parseInt(str[1]);
				if(arr[a]<arr[b]) {
					in_cnt[a]+=1;
					in_cnt[b]-=1;
				}
				else {
					in_cnt[a]-=1;
					in_cnt[b]+=1;
				}
				
			}		
			tp_sort(n,in_cnt);
		}
	}
	
	public static void tp_sort(int n,int[] in_cnt) {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i=1;i<n+1;i++) {
			if(in_cnt[i]==0)queue.add(i);
		}
		if(queue.size()>1) {
			System.out.println("?");
			return;
		}
		
		else {
			
			for(int i=0;i<n;i++) {
				
				if(queue.isEmpty()) {
					System.out.println("IMPOSSIBLE");
					return;
				}
				
				int a = queue.poll();
				sb.append(a+" ");
				for(int j=1;j<=n;j++) {
					if(in_cnt[j]>0) {
						in_cnt[j]--;
						if(in_cnt[j]==0)queue.add(j);
					}
				}
			}
			
			
		}
		
		System.out.println(sb);
	}
}
