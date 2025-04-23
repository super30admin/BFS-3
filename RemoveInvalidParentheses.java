import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
//TC=O(N^N)
public class RemoveInvalidParentheses {
    private int max;
    List<String> result;
    public List<String> removeInvalidParentheses(String s) {
        result=new ArrayList<>();
        HashSet<String> set=new HashSet<>();
        dfs(s,set);
        return result;
    }

    private void dfs(String s,HashSet<String> set){

        //base
        if(s.length() < max) return;

        if(isvalid(s)){
            if(s.length()>max){
                max=s.length();
                result=new ArrayList<>();
            }
            result.add(s);
        }


        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isLetter(c))continue;
            String baby=s.substring(0,i)+s.substring(i+1);
            if(!set.contains(baby)){
                set.add(baby);
                dfs(baby,set);
            }
        }

    }

    private boolean isvalid(String s){
        int count=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isLetter(c)) continue;
            if(c=='('){
                count++;
            }else{
                if(count==0) return false;
                count--;
            }
        }
        return count==0;
    }
}
//bfs
/*
public List<String> removeInvalidParentheses(String s) {
    List<String> result=new ArrayList<>();
    HashSet<String> set=new HashSet<>();
    Queue<String> q=new LinkedList<>();
    q.add(s);
    set.add(s);
    boolean flag=false;
    while(!q.isEmpty() && !flag){
        int size=q.size();
        for(int i=0; i<size;i++){
            String curr=q.poll();
            if(isvalid(curr)){
                result.add(curr);
                flag=true;
            }
            if(!flag){
                for(int j=0; j<curr.length();j++){
                    String baby=curr.substring(0,j)+curr.substring(j+1);
                    if(!set.contains(baby)){
                        set.add(baby);
                        q.add(baby);
                    }
                }
            }
        }
    }
    return result;
}

private boolean isvalid(String s){
    int count=0;
    for(int i=0;i<s.length();i++){
        char c=s.charAt(i);
        if(Character.isLetter(c)) continue;
        if(c=='('){
            count++;
        }else{
            if(count==0) return false;
            count--;
        }
    }
    return count==0;
}*/
