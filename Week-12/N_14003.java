package dp_easymean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N_14003 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		String[] str= br.readLine().split(" ");
		int[] data= new int[n];
		int[] dp= new int[n];
		
		for(int i=0;i<n;i++)data[i]=Integer.parseInt(str[i]);
		int[] da=new int[n];
		int len=0;
		dp[0]=data[0];
		da[0]=1;
		
		for(int i=1;i<n;i++) {
			if(data[i]>dp[len]) {
				dp[++len]=data[i];
				da[i]=len+1;
			}
			
			else {
				//이분탐색 실시
				int left=0;int right=len;
				while(left<right) {
					int mid=(left+right)/2;	
					
					if(dp[mid]<data[i]) {
						left=mid+1;
					}
					else { //dp[mid]가 더 크면.
						right=mid;
					}
				}
				dp[right]=data[i];
				da[i]=right+1;
			}			
			
		}
		
		int a=len+1;
		sb.append(a+"\n");
		Stack<Integer> stack = new Stack();
		
		for(int i=n-1;i>=0;i--) {
			if(a==da[i]) {
				stack.push(data[i]);
				a--;
			}
		}
		
		while(!stack.isEmpty())sb.append(stack.pop()+" ");
		/*for(int i=n-1;i>=0;i--) {
			if(a==da[i]) {
				sb.insert(0, data[i]+" ");
				a--;
			}
		}*/
		
		System.out.println(sb);
	}
	
}
