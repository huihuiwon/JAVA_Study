import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/* 가장 긴 증가하는 부분 수열 5 */
public class P_14003 {
	static int[] lis;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[n];
		for(int i = 0;i < n;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		lis = new int[n+1];
		lis[0] = Integer.MIN_VALUE;
		int[] dp = new int[n]; // 증가하는 부분 수열 크기 저장 
		int len =0; // 최대 길이 
		int idx =0;
		for(int i =0;i<n;i++) {
			if(num[i]>lis[len]) {
				dp[i] = ++len;
				lis[len] = num[i];
			}else {
				idx = binarySearch(0,len,num[i]);
				lis[idx] = num[i];
				dp[i] = idx;
			}
		}
		bw.write(len+"\n");
		Stack<Integer> s= new Stack<>();
		for(int i = n-1;i>= 0;i--) {
			if(dp[i]==len) {
				s.push(num[i]);
				len--;
			}
		}
		while(!s.isEmpty()) {
			bw.write(s.pop()+" ");
		}
		bw.flush();
		bw.close();
		br.close();

	}
	static int binarySearch(int left,int right,int key ) {
		int mid = 0;
		while(left<right) {
			mid = (left+right)/2;
			if(lis[mid]<key) {
				left = mid+1;
			}else {
				right = mid;
			}
		}
		return right;
	}

}
