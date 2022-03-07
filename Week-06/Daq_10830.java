package div_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Daq_10830 {
	static int n;
	static int[][] origin;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String ar[]=br.readLine().split(" ");
		n=Integer.parseInt(ar[0]);
		Long b=Long.parseLong(ar[1]);
		
		origin=new int[n][n];
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<n;j++) {
				origin[i][j]=Integer.parseInt(st.nextToken())%1000;		
			}
		}
		
		int[][] res=power(origin,b);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				sb.append(res[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static int[][] power(int[][] arr,long b){
		if(b==1) {
			return arr;
		}
		int[][] res = power(arr,b/2);
		
		res=multiply(res,res);
		
		if(b%2==1) {
			res=multiply(res,origin);
		}
		
		return res;
	}
	
	static int[][] multiply(int[][] arr1,int[][] arr2){
		int[][] res = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					res[i][j]+=arr1[i][k]*arr2[k][j];
					res[i][j]%=1000;
				}
			}
		}
		return res;
	}
}
