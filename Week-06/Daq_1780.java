package div_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Daq_1780 {
	static int arr[][];
	static int m_one,zero,one=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(br.readLine());
		arr=new int[n][n];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<n;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		paper_count(0,0,n);
		System.out.print(m_one+"\n"+zero+"\n"+one);
	}
	
	static void paper_count(int start_x,int start_y,int size) {
		int now=arr[start_x][start_y];
		int cnt=0;
		Loop1:
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(arr[start_x+i][start_y+j]==now) { cnt++;}
				else { break Loop1;}		
			}
		}
		if(cnt==size*size) {
			switch(now) {
			case -1:m_one++;break;
			case 0:zero++;break;
			case 1:one++;break;
			}
			return;
		}
		else {
			int n_size=size/3;
			for(int k=0;k<3;k++) {
				for(int z=0;z<3;z++) {
					paper_count(start_x+n_size*k,start_y+n_size*z,n_size);	
				}
				
			}
		}
	}

}
