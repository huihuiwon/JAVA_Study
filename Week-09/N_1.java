package kakao.week9;

import java.util.*;
import java.util.Map.Entry;

//신고결과 받기

public class N_1 {
	public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashMap<String,Integer> index=new HashMap<>();
        int[] answer = new int[id_list.length];
        
        for(int i=0;i<id_list.length;i++){
            map.put(id_list[i],new HashSet<>());
            index.put(id_list[i],i);
        }
        
        for(String s:report){
            String res[] = s.split(" ");
            map.get(res[1]).add(res[0]); //누구한테 신고받았는지
        }
        for(Entry<String,HashSet<String>> entry: map.entrySet()){
            HashSet<String> aa=entry.getValue();
            if(aa.size()>=k){
                for(String s:aa){
                    /*해당 문자열의 index를 알아내서(indexOf) answer 에 값 넣어주는게 빠를까, 
                    HashMap 에 index 미리 넣어놓고 get 해서 넣어주는게 빠를까
                    => HashMap 이 더 빠름*/ 
                    //answer[Arrays.asList(id_list).indexOf(s)] +=1; 
                    
                    answer[index.get(s)]+=1;
                }
            }
        }
        
        return answer;
    }
}
