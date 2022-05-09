class Solution {
    char arr[];
    boolean chk[];
    char kakao[]={'A','C','F','J','M','N','R','T'};
    int answer=0;
    int cnt=0;
    public void sat(String str, String[] data, int n) {
        boolean flag=true;
        
        for(String d : data){
            int first=str.indexOf(d.charAt(0));
            int second=str.indexOf(d.charAt(2));
            int diff=d.charAt(4)-'0';
            diff+=1;
            if(d.charAt(3)=='<'){
                if(Math.abs(first-second)>=diff) {
                    flag=false;
                    break;
                }
            }
            else if(d.charAt(3)=='>'){
                if(Math.abs(first-second)<=diff) {
                    flag=false;
                    break;
                }
            }
            else if(d.charAt(3)=='='){
                if(Math.abs(first-second)!=diff) {
                    flag=false;
                    break;
                }
            }    
        }
        if(flag) {
            answer++;
        }
    }
    public void DFS(int L, int n, String[] data){
        if(L==8){
            
            String tmp="";
            for(int i=0; i<8; i++){
                tmp+=(arr[i]+"");
            }
            
            sat(tmp, data, n);
            return;
        }
        for(int i=0; i<8; i++){
            if(!chk[i]){
                chk[i]=true;
                arr[L]=kakao[i];
                DFS(L+1, n, data);
                chk[i]=false;
            }
        }
    }
    public int solution(int n, String[] data) {
        arr=new char[8];
        chk=new boolean[8];
        DFS(0, n, data);
        return answer;
    }
}