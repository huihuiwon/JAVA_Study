import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        //Hash Map: 신고된id(String)->신고한id 목록(Set:중복 X)
        HashMap<String, HashSet<String>> reportmap = new HashMap<>();
        //유저가 받는 메일 수 저장
        HashMap<String, Integer> mailCnt = new HashMap<>();
        
        for (int i=0; i<id_list.length; i++) {
        	reportmap.put(id_list[i], new HashSet<String>());
        	mailCnt.put(id_list[i], 0);
        }
        
        //report에서 신고된 id, 신고한 id 분리
        //신고된 id(key)의 value에 신고한 id 추가
        for (int i=0; i<report.length; i++) {
        	String[] report_id = report[i].split(" ");
        	
        	reportmap.get(report_id[1]).add(report_id[0]);
        }
        
        //신고된 id를 신고한 id가 k개 이상이면 신고한 id의 메일 수+1
        for (HashSet<String> hs : reportmap.values()) {
        	if (hs.size() >= k) {
        		Iterator<String> iter = hs.iterator();
        		while (iter.hasNext()) {
        			String id = iter.next();
        			mailCnt.put(id, mailCnt.get(id)+1);
        		}
        	}
        }
        
        for (int i=0; i<id_list.length; i++) {
        	answer[i] = mailCnt.get(id_list[i]);
        }
        
        return answer;
    }
}