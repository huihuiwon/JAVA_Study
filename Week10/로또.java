import java.util.*;
class Solution {
    public int score(int wcnt){
        if(wcnt==6) return 1;
        else if(wcnt==5) return 2;
        else if(wcnt==4) return 3;
        else if(wcnt==3) return 4;
        else if(wcnt==2) return 5;
        else return 6;
    }
    
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        HashSet<Integer> hs = new HashSet<>();
        for(int i : win_nums)
            hs.add(i);
        
        int zcnt=0; int wcnt=0;
        for(int i : lottos) {
            if(i==0) zcnt++;
            if(hs.contains(i))
                wcnt++;
        }
        
        if(zcnt==0){
            answer[0]=answer[1]=score(wcnt);
        }
        else{
            answer[0]=score(wcnt+zcnt);
            answer[1]=score(wcnt);
        }
        return answer;
    }
}