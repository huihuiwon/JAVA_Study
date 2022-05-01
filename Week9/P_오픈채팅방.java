import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] cmd = {"Enter","Leave", "Change"};
        List<String> result = new ArrayList<>();
        HashMap<String,String> map = new HashMap<>(); // key: 유저아이디, values : 닉네임
        
        for(int i = 0 ; i < record.length;i++){
            String[] str = record[i].split(" ");
            if(str[0].equals(cmd[0])){ //Enter인경우
                map.put(str[1],str[2]);    
                result.add(str[1]+"님이 들어왔습니다.");
            }
            else if(str[0].equals(cmd[1])){ //Leave인 경우
                result.add(str[1]+"님이 나갔습니다.");
            }
            else{ //Change인 경우
                map.replace(str[1],str[2])  ;
            }
        }
        
        String[] answer = new String[result.size()];
        for(int i = 0 ; i < result.size();i++){
            int idx = result.get(i).indexOf("님"); //id만 가져오기 위해
            String id = result.get(i).substring(0,idx);
            answer[i] = map.get(id) + result.get(i).substring(idx);
        }
        return answer;
    }
}
