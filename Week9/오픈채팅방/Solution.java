import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        HashMap<String, String> hm = new HashMap<>();
        for(String s : record){
            String tmp[]=s.split(" ");
            if(tmp[0].equals("Enter") || tmp[0].equals("Change"))
                hm.put(tmp[1], tmp[2]);
        }
        
        ArrayList<String> temp = new ArrayList<>();
        for(String s: record) {
            String tmp[]= s.split(" ");
            if(tmp[0].equals("Enter")){
                String t=hm.get(tmp[1])+"님이 들어왔습니다.";
                temp.add(t);
            }
            else if(tmp[0].equals("Leave")){
                String t=hm.get(tmp[1])+"님이 나갔습니다.";
                temp.add(t);
            }
        }
        answer=temp.toArray(answer);
        return answer;
    }
}