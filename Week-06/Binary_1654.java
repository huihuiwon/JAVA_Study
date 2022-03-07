package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Binary_1654 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a[]=br.readLine().split(" ");
		int K=Integer.parseInt(a[0]);
		long N=Long.parseLong(a[1]);
		int lan[] = new int[K];
		
		long low=1;
		long high=0;
		for(int i=0;i<K;i++) {
			lan[i]=Integer.parseInt(br.readLine());
			high+=lan[i];
		}
		long res=0;
		high/=N;
		
		while(low<=high) {
			long mid=(low+high)/2;
			long cnt=0;
			for(int i=0;i<K;i++) {
				cnt+=lan[i]/mid;
			}
			if(cnt<N) {
				high=mid-1;
			}
			else {
				low=mid+1;
				res=mid;
			}
		}
		System.out.println(res);
	}

}
