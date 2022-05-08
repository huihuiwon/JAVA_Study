import java.util.LinkedList;
import java.util.Queue;

class Solution {
    boolean[][] visited;
    
    int[] dx = new int[] {0, 0, -1, 1};
	int[] dy = new int[] {-1, 1, 0, 0};
        
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        visited = new boolean[m][n];
		
        for (int i=0; i<m; i++) {
        	for (int j=0; j<n; j++) {
        		if (picture[i][j] != 0 && !visited[i][j]) {
        			numberOfArea++;
                    int size = bfs(i, j, picture);
                    if (size > maxSizeOfOneArea){
                        maxSizeOfOneArea = size;
                    }
        		}
        	}
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public int bfs(int i, int j, int[][] picture) {
        Queue<int[]> q = new LinkedList<int[]>();
        
        int size = 1;
        visited[i][j] = true;
        q.add(new int[] {j, i});
        while (!q.isEmpty()) {
        	int[] index = q.remove();
        	
        	for (int k=0; k<4; k++) {
        		int x = index[0] + dx[k];
        		int y = index[1] + dy[k];
    			
        		if (x>=0 && x<picture[0].length && y>=0 && y<picture.length && !visited[y][x] && picture[y][x]==picture[index[1]][index[0]]) {
                    size++;
					visited[y][x] = true;
					q.add(new int[] {x, y});
				}
        	}
        }
        
        return size;
    }
}
