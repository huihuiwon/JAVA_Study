import java.util.*;

class Solution {
    public int solution(String s) { 
        int length = s.length();
        int answer = length;
        
        for(int i=1;i<length/2+1;i++){ // i는 분할단위.
            int count =1;//문자열 반복 횟수 세아리기 위함.
            String prev = s.substring(0,i);
            String enc = "";
            String last = "";
            for(int j = i; j<length;j+=i){
                if(j+i > length){//남아있는 문자열이 분할단위보다 적게 남아있는 경우
                    last = s.substring(j);
                    break;
                }
                if(prev.equals(s.substring(j,j+i))){
                    count++;
                }else{
                    enc += prev;
                    if(count !=1){ //반복되는 문자열이 있는 경우 
                        enc = count +enc;
                    }
                    prev = s.substring(j,j+i);
                    count =1;
                }
            }
            enc += prev + last;
            if(count!=1){
                enc = count + enc;
            }
            answer = Math.min(answer,enc.length());
           
        }
	       
        return answer;
    }
}
