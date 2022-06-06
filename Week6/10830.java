import java.util.*;
import java.io.*;


public class Main {	

	static int n;
	static int map[][];

	public static int[][] matrix(int t[][], int t2[][]) {
		int result[][]=new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					result[i][j]+=t[i][k]*t2[k][j];
					result[i][j]%=1000;
				}
			}
		}
		return result;
	}
	
	public static int[][] ab(long b) {
		if(b==1) {
			return map;
		}

		int[][] tmp=ab(b/2);
		tmp=matrix(tmp, tmp);
		
		if(b%2==1)
			tmp=matrix(tmp, map);
		
		return tmp;
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp[]=br.readLine().split(" ");
		n=Integer.parseInt(tmp[0]);
		long b=Long.parseLong(tmp[1]);
		map=new int[n][n];
		for(int i=0; i<n; i++) {
			tmp=br.readLine().split(" ");
			for(int j=0; j<n; j++) {
				map[i][j]=Integer.parseInt(tmp[j])%1000;
			}
		}
		
		int result[][]=ab(b);
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}
}