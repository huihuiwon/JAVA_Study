import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int len=id_list.length;
        int[] answer = new int[len];
        
        boolean[][] chk = new boolean[len][len];
        for(String str : report){
            String tmp[] =str.split(" ");
            chk[Arrays.asList(id_list).indexOf(tmp[0])][Arrays.asList(id_list).indexOf(tmp[1])]=true;
        }
        
        for(int i=0; i<len; i++){
            int cnt_tmp=0; HashSet<Integer> hs=new HashSet<>();
            for(int j=0; j<len; j++){
                if(chk[j][i]){
                    cnt_tmp++;
                    hs.add(i);
                }
            }
            
            if(cnt_tmp>=k){
                for(int j=0; j<len; j++){
                    int cnt=0;
                    for(int lt : hs){
                        if(chk[j][lt]) cnt++;
                    }
                    answer[j]+=cnt;
                }
            }
        }
        return answer;
    }
}