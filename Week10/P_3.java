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
        
        //������(char)->��ȣ(int)
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
		//������ �� �������� ���� ���� Ȯ��
		if (cur == 8) {
			if (check()) {
				cnt++;
			}
			return ;
		}
		
		//������ ���� ���� ��ġ
		for (int i=0; i<8; i++) {
			//�ش� ��ġ�� ����ִ��� Ȯ��
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
            
			//�� ������ ������ �ٸ� ������ ���� ������ �����ϴ��� Ȯ��
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
