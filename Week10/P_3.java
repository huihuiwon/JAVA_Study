import java.util.HashMap;

class Solution {
    HashMap<Character, Integer> friends;
	int[] arr;
	boolean[] visited;
	int cnt;
	String[] condition;
	
	public int solution(int n, String[] data) {
        int answer = 0;
        
        friends = new HashMap<>();
        arr = new int[8];
        visited = new boolean[8];
        cnt = 0;
        condition = data;
        
        //프렌즈(char)->번호(int)
        friends.put('A', 0);
        friends.put('C', 1);
        friends.put('F', 2);
        friends.put('J', 3);
        friends.put('M', 4);
        friends.put('N', 5);
        friends.put('R', 6);
        friends.put('T', 7);
        
        dfs(0);
        
        answer = cnt;
        
        return answer;
    }
	
	public void dfs(int cur) {
		//순서가 다 정해지면 조건 만족 확인
		if (cur == 8) {
			if (check()) {
				cnt++;
			}
			return ;
		}
		
		//프렌즈 서는 순서 배치
		for (int i=0; i<8; i++) {
			//해당 위치가 비어있는지 확인
			if (visited[i]) {
				continue;
			}
			arr[cur] = i;
			visited[i] = true;
			dfs(cur+1);
			visited[i] = false;
		}
	}
	
	public boolean check() {
		for (String cond : condition) {
			int f1 = friends.get(cond.charAt(0));
			int f2 = friends.get(cond.charAt(2));
			char op = cond.charAt(3);
			int dist = cond.charAt(4)-'0';
            int cur_dist = Math.abs(arr[f1]-arr[f2])-1;
            
			//두 프렌즈 사이의 다른 프렌즈 수가 조건을 만족하는지 확인
			if (op == '=') {
				if (cur_dist != dist) {
					return false;
				}
			}
			else if (op == '<') {
				if (cur_dist >= dist) {
					return false;
				}
			}
			else {
				if (cur_dist <= dist) {
					return false;
				}
			}
		}
		
		return true;
	}
}
