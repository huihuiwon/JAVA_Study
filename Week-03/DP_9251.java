package dp;

import java.util.Scanner;

public class DP_9251 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String a = sc.nextLine();
		String b = sc.nextLine();
		int arr[][] = new int[a.length()][b.length()];
		
		for(int i=0;i<a.length();i++) {
			if(a.charAt(i)==b.charAt(0)) arr[i][0]=1;
			else if(i>0) arr[i][0]=arr[i-1][0];
		}
		for(int i=0;i<b.length();i++) {
			if(a.charAt(0)==b.charAt(i))arr[0][i]=1;
			else if(i>0) arr[0][i]=arr[0][i-1];
		}
		
		for(int i=1;i<a.length();i++) {
			for(int j=1;j<b.length();j++) {
				if(a.charAt(i)==b.charAt(j))arr[i][j]=arr[i-1][j-1]+1;
				else arr[i][j]=(arr[i][j-1]>arr[i-1][j])?arr[i][j-1]:arr[i-1][j];
			}
		}
		System.out.println(arr[a.length()-1][b.length()-1]);
	}
}
