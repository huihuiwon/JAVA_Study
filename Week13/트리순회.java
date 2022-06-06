import java.util.*;
import java.io.*;

public class Main {
	static int lc[]=new int[30];
	static int rc[]=new int[30];
	static void preorder(int cur) {
		System.out.print((char)(cur+'A'-1));
		if(lc[cur]!=0) preorder(lc[cur]);
		if(rc[cur]!=0) preorder(rc[cur]);
	}
	static void inorder(int cur) {
		if(lc[cur]!=0) inorder(lc[cur]);
		System.out.print((char)(cur+'A'-1));
		if(rc[cur]!=0) inorder(rc[cur]);
	}
	static void postorder(int cur) {
		if(lc[cur]!=0) postorder(lc[cur]);
		if(rc[cur]!=0) postorder(rc[cur]);
		System.out.print((char)(cur+'A'-1));
	}
	public static void main(String[] args) throws IOException{
		
		
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		for(int i=0; i<n; i++) {
			char m=sc.next().charAt(0); char l=sc.next().charAt(0); char r=sc.next().charAt(0);
			if(l!='.') lc[m-'A'+1] = l-'A'+1;
			if(r!='.') rc[m-'A'+1] = r-'A'+1;
			
		}
		
		preorder(1);
		System.out.println("");
		inorder(1);
		System.out.println("");
		postorder(1);
		
	}
}