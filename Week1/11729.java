import java.util.*;
import java.io.*;

public class Main {	
	
	static int cnt=0;
	static StringBuilder sb=new StringBuilder();
	public static void hanoi(int n, int a, int b){
		if(n>1)
			hanoi(n-1, a, 6-a-b);
		cnt++;
		sb.append(a+" "+b+"\n");
		if(n>1)
			hanoi(n-1, 6-a-b, b);
	}
	public static void main(String[] args) throws IOException{
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		hanoi(n, 1, 3);
		System.out.println(cnt);
		System.out.println(sb);
	}
}