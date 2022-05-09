import java.util.*;
class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean dist[][]=new boolean[m][n];
        int dx[]={0,1,0,-1};
        int dy[]={1,0,-1,0};
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
               if(dist[i][j] || picture[i][j]==0) continue;
                Queue<int[] > q = new LinkedList<>();
                q.add(new int[] {i, j});
                dist[i][j]=true;
                numberOfArea++;
                int max=0;
                while(!q.isEmpty()){
                    int cur[]=q.poll();
                    max++;
                    for(int dir=0; dir<4; dir++){
                        int nx=dx[dir]+cur[0];
                        int ny=dy[dir]+cur[1];
                        if(nx<0 || ny<0|| nx>=m || ny>=n) continue;
                        if(dist[nx][ny] || picture[nx][ny]!=picture[cur[0]][cur[1]]) continue;
                        if(picture[nx][ny]==0) continue;
                        q.add(new int[] {nx, ny});
                        dist[nx][ny]=true;
                    }
                }
                maxSizeOfOneArea=Math.max(maxSizeOfOneArea, max);
                
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}