import java.util.*;
import java.io.*;


public class Main {	
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		String a= sc.next();
		String b= sc.next();
		
		int len1=a.length();
		int len2=b.length();
		
		int dp[][]=new int[len1+1][len2+1];
		for(int i=1; i<=len1; i++) {
			for(int j=1; j<=len2; j++) {
				if(a.charAt(i-1)==b.charAt(j-1))
					dp[i][j]=dp[i-1][j-1]+1;
				else
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		System.out.println(dp[len1][len2]);
	}
}