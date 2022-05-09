package kakao.week10;
import java.util.stream.IntStream;


public class N_1 {
	public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        for(int i=0;i<lottos.length;i++){
            if(lottos[i]==0){
                answer[0]++;continue;
            }
            final int a= lottos[i];
            
            if (IntStream.of(win_nums).anyMatch(x -> x == a)){
                answer[1]++;
            }
        }
        
        answer[0]+=answer[1];
        
        if(answer[0]<=1)answer[0]=6;
        else answer[0]=7-answer[0];
        
        if(answer[1]<=1)answer[1]=6;
        else answer[1]=7-answer[1];
        
        
        return answer;
    }
}
