package kakao.week10;
import java.util.Arrays;


public class N_3 {
	public String[] data;
    public char[] name={'A','C','F','J','M','N','R','T'};
    public int answer=0;
    
    public int solution(int n, String[] data) {
        //조건을 만족하는 모든 경우의수. 

        this.data=data;
        permutation(new char[8],new boolean[8],0);
        
        return answer;
    }
    
    public void permutation(char[] out,boolean[] visited,int depth){
        if(depth==8){
            if(check(out))answer+=1;
            return;
        }
        
        for(int i=0;i<8;i++){
            if(!visited[i]){
                visited[i]=true;
                out[depth]=name[i];
                permutation(out,visited,depth+1);
                visited[i]=false;
            }
        }
        
    }
    
    public boolean check(char[] arr){
        String arr_str=String.valueOf(arr);
        int a1,a2,dis;
        char op;
        
        for(String da:data){
            a1=arr_str.indexOf(da.charAt(0));
            a2=arr_str.indexOf(da.charAt(2));
            op=da.charAt(3);
            
            dis=da.charAt(4)-'0';
            
            if(op=='='){
                if(Math.abs(a1-a2)-1!=dis)return false;
            }
            else if(op=='>'){
                if(Math.abs(a1-a2)-1<=dis)return false;
            }
            else{
                if(Math.abs(a1-a2)-1>=dis)return false;
            }
        }
        return true;
    }
}
