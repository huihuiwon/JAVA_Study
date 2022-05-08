class Solution {
     public boolean[] used;
    public char[] arr;
    public String[] data;
    public int answer;
    public int solution(int n, String[] data) {
        this.answer = 0;
        this.data = data;
        arr = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'}; 
        used = new boolean[arr.length];        
        dfs("", 0);
        return answer;
    }
    
    public void dfs(String str, int len){
        if(len == arr.length) {
            if(isPossible(str)) answer++;
            return;
        }
        for(int i = 0; i < arr.length; i++){
            if(used[i]) continue;
            used[i] = true;
            dfs(str+arr[i], len+1);
            used[i] = false;
        }
    }
    
    public boolean isPossible(String str){
        for(String rule : data){
            int idx1 = str.indexOf(String.valueOf(rule.charAt(0)));
            int idx2 = str.indexOf(String.valueOf(rule.charAt(2)));
            char oper = rule.charAt(3);
            int diff = Integer.parseInt(String.valueOf(rule.charAt(4)));
            int realDiff = Math.abs(idx1-idx2)-1;
            if ((oper == '<') && !(realDiff < diff)) return false;
            else if ((oper == '>') && !(realDiff > diff)) return false;
            else if ((oper == '=') && !(realDiff == diff)) return false;
        }
        return true;
    }
}
