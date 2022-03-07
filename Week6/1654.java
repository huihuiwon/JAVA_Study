import java.util.*;
import java.io.*;


public class Main {	

	static int k;
	static int n;
	static int line[];
	public static void cnt(int max) {
		long lt=1; long rt=max; long result=0;
		while(lt<=rt) {
			long mid=(lt+rt)/2;
			int count=0;
			for(int i=0; i<k; i++) {
				count+=line[i]/mid;
			}
			if(count<n) rt=mid-1;
			else if(count>=n) {
				lt=mid+1;
				result=Math.max(result, mid);
			}
		}
		System.out.println(result);
	}
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		k=sc.nextInt(); n=sc.nextInt();
		line=new int[k];
		for(int i=0; i<k; i++) {
			line[i]=sc.nextInt();
		}
		Arrays.sort(line);
		
		cnt(line[k-1]);
	}
}