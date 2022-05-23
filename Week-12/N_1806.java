package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1806 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long answer=100000000;
		String[] str = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		int s = Integer.parseInt(str[1]);
		
		int[] arr =new int[n];
		str=br.readLine().split(" ");
		for(int i=0;i<n;i++)arr[i]=Integer.parseInt(str[i]);
		
		int start=0;int end=0;
		long sum=0;
		
		while(end<n) {
			sum+=arr[end];
			
			if(sum>=s) {
				if(end-start+1<answer)answer=end-start+1;
				end=++start;
				sum=0;
			}
			else end++;
			
		}
		
		if(answer==100000000)System.out.println(0);
		else System.out.println(answer);
	}

}
