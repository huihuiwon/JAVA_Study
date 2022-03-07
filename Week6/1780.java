import java.util.*;
import java.io.*;


public class Main {	

	static int n;
	static int map[][];
	static int zcnt=0;
	static int mcnt=0;
	static int pcnt=0;
	
	public static void count(int a, int c, int nsize) {
		int s=map[a][c]; boolean flag=false;
		for(int i=a; i<a+nsize; i++) {
			for(int j=c; j<c+nsize; j++) {
				if(s!=map[i][j]) {
					flag=true;
					break;
				}
			}
		}
		if(!flag) {
			if(s==0) zcnt++;
			else if(s==1) pcnt++;
			else mcnt++;
			return;
		}
		
		nsize=nsize/3;
		count(a, c, nsize);
		count(a, c+nsize, nsize);
		count(a, c+2*nsize, nsize);
		count(a+nsize, c, nsize);
		count(a+nsize, c+nsize, nsize);
		count(a+nsize, c+2*nsize, nsize);
		count(a+2*nsize, c, nsize);
		count(a+2*nsize, c+nsize, nsize);
		count(a+2*nsize, c+2*nsize, nsize);
	}
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		map=new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		count(0, 0, n);
		System.out.println(mcnt);
		System.out.println(zcnt);
		System.out.println(pcnt);
	}
}