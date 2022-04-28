import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> index = new HashMap<>();
        Map<String,List<Integer>> list = new HashMap<>();
        
        for(int i = 0 ; i < id_list.length ;i++){
            index.put(id_list[i],i);
        }
        for(int i = 0 ; i < report.length;i++){
            String[] id = report[i].split(" "); 
            if(!list.containsKey(id[1])){
                list.put(id[1],new ArrayList<>());
            }
            List<Integer> tmp = list.get(id[1]);
            
            if(!tmp.contains(index.get(id[0]))) {
                tmp.add(index.get(id[0]));
            }
        }
        for(int i = 0 ; i < id_list.length;i++){
            String id = id_list[i];
            if(list.containsKey(id) && list.get(id).size()>= k){
                for(int idx : list.get(id))
                    answer[idx]++;
            }
        }
        
        return answer;
    }
}
