import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int n=Integer.parseInt(br.readLine());
    	int arr[]=new int[n];
    	int dp[]=new int[n];
    	int record[]=new int[n];
    	
    	StringTokenizer stz = new StringTokenizer(br.readLine());
    	for(int i=0; i<n; i++) {
    		arr[i]=Integer.parseInt(stz.nextToken());
    	}

    	Arrays.fill(record, -1);
    	dp[0]=1; int max_value=1; int start=0;
    	for(int i=1; i<n; i++) {
    		for(int j=i-1; j>=0; j--) {
    			if(arr[i]>arr[j] && dp[i]<(dp[j]+1)) {
    				dp[i]=dp[j]+1;
    				record[i]=j;
    				if(max_value<dp[i]) {
    					max_value=dp[i];
    					start=i;
    				}
    			}
    		}
    	}


    	StringBuilder sb = new StringBuilder();
    	sb.append(max_value+"\n");

    	Stack<Integer> st = new Stack<>();
    	st.push(arr[start]);
    	while(start!=-1) {
    		start=record[start];
    		if(start!=-1)
    			st.push(arr[start]);
    	}

    	while(!st.isEmpty())
    		sb.append(st.pop()+" ");
    	
    	bw.write(sb+"\n");
    	bw.flush();
    }
 

 
}