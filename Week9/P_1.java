import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        //Hash Map: �Ű��id(String)->�Ű���id ���(Set:�ߺ� X)
        HashMap<String, HashSet<String>> reportmap = new HashMap<>();
        //������ �޴� ���� �� ����
        HashMap<String, Integer> mailCnt = new HashMap<>();
        
        for (int i=0; i<id_list.length; i++) {
        	reportmap.put(id_list[i], new HashSet<String>());
        	mailCnt.put(id_list[i], 0);
        }
        
        //report���� �Ű�� id, �Ű��� id �и�
        //�Ű�� id(key)�� value�� �Ű��� id �߰�
        for (int i=0; i<report.length; i++) {
        	String[] report_id = report[i].split(" ");
        	
        	reportmap.get(report_id[1]).add(report_id[0]);
        }
        
        //�Ű�� id�� �Ű��� id�� k�� �̻��̸� �Ű��� id�� ���� ��+1
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