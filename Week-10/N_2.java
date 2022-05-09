package kakao.week10;
import java.util.LinkedList;
import java.util.Queue;

public class N_2 {
	public int numberOfArea=0;
    public boolean[][] check;
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        //dfs, bfs
        check=new boolean[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j]!=0&&!check[i][j]){
                    int a = bfs(picture,m,n,i,j);
                    numberOfArea+=1;
                    if(a>maxSizeOfOneArea)maxSizeOfOneArea=a;
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public int bfs(int[][] picture,int m,int n, int x,int y){
        int[] dir_x={-1,0,1,0};
        int[] dir_y={0,-1,0,1};
        int ans=1;
        Queue<int[]> q=new LinkedList<int[]>();
        
        q.add(new int[]{x,y});
        check[x][y]=true;
        
        while(!q.isEmpty()){
            int[] pos = q.poll();
            
            for(int i=0;i<4;i++){
                int n_x=pos[0]+dir_x[i];
                int n_y=pos[1]+dir_y[i];
                
                if(n_x>=0&&n_x<m&&n_y>=0&&n_y<n){
                    if(!check[n_x][n_y] && picture[n_x][n_y]==picture[x][y]){
                        q.add(new int[]{n_x,n_y});
                        check[n_x][n_y]=true;
                        ans+=1;
                    }
                }
            }
        }
        return ans;
    }
}
