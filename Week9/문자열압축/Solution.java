import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int k=1; k<=s.length()/2; k++){
            int tmp=1; String tmp_s=""; int len=0;
            for(int i=k; i<s.length()-k+1; i+=k){
                if(s.substring(i, k+i).equals(s.substring(i-k, i))){
                    tmp++;
                }
                else{
                    if(tmp!=1)
                        len+=(k+(int)(Math.log10(tmp)+1));
                    else len+=k;
                    tmp=1;
                }
            }
            if(tmp!=1)
                len+=(k+(int)(Math.log10(tmp)+1));
            else
                len+=k;
            len+=s.length()%k;
            answer=Math.min(answer, len);
        }
        return answer;
    }
}