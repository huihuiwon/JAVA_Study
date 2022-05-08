import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int Mcnt = 0 ; 
        int Zcnt = 0;
        
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        for(int lotto : lottos){
            if(Arrays.binarySearch(win_nums,lotto)>=0 )
                Mcnt++;
            if(lotto==0)
                Zcnt++;
        }
        answer[1] = Math.min(7-Mcnt,6);
        
        answer[0] = Math.min(7-(Mcnt+Zcnt),6);
        
        return answer;
    }
}
