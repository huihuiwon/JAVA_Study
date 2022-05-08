import java.util.Arrays;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] rank = new int[] {6, 6, 5, 4, 3, 2, 1};
        
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        
        int cnt0 = 0;
        while (cnt0 < 6 && lottos[cnt0] == 0) {
        	cnt0++;
        }
        
        int i = cnt0;
        int j = 0;
        int match = 0;
        while (i<6 && j<6) {
        	if (lottos[i] == win_nums[j]) {
        		i++;
        		j++;
        		match++;
        	}
        	else if (lottos[i] < win_nums[j]){
        		i++;
        	}
        	else {
        		j++;
        	}
        }
        
        int[] answer = {rank[match+cnt0], rank[match]};
        
        return answer;
    }
}
