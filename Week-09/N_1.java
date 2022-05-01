package kakao.week9;

import java.util.*;
import java.util.Map.Entry;

//�Ű��� �ޱ�
//hashSet : https://crazykim2.tistory.com/474#text6
//hashSet, hashMap ����  https://postitforhooney.tistory.com/entry/JavaHashSet%EA%B3%BC-HashMap

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
            map.get(res[1]).add(res[0]); //�������� �Ű�޾Ҵ���
        }
        for(Entry<String,HashSet<String>> entry: map.entrySet()){
            HashSet<String> aa=entry.getValue();
            if(aa.size()>=k){
                for(String s:aa){
                    /*�ش� ���ڿ��� index�� �˾Ƴ���(indexOf) answer �� �� �־��ִ°� ������, 
                    HashMap �� index �̸� �־���� get �ؼ� �־��ִ°� ������
                    => HashMap �� �� ����*/ 
                    //answer[Arrays.asList(id_list).indexOf(s)] +=1; 
                    
                    answer[index.get(s)]+=1;
                }
            }
        }
        
        return answer;
    }
}
