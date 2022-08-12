import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//Time Complexity=O(n*n!)
//Sapce Complexity=O(n*n!)

public class InvalidParenthesisDFS {

    List<String> result;
    HashSet<String> set;
    int max;
    public List<String> removeInvalidParentheses(String s) {

        result=new ArrayList<String>();
        set=new HashSet<>();
        dfs(s);
        return result;
    }

    private void dfs(String s){
        //base
        if(set.contains(s)) return;
        set.add(s);
        if(s.length()<max) return;

        if(isValid(s)){
            if(s.length()!=max){
                result=new ArrayList<String>();
            }
            max=s.length();
            result.add(s);
        }

        for(int i=0;i<s.length();i++){
            String str=s.substring(0,i)+s.substring(i+1);
            dfs(str);
        }

    }
    public boolean isValid(String str){
        int n=str.length();
        int count=0;
        for(int i=0;i<n;i++){
            char c=str.charAt(i);
            if(Character.isLetter(c)) continue;
            if(c=='('){
                count++;
            }
            else if(c==')'){
                if(count==0) return false;
                count--;

            }

        }
        return count==0;
    }
}
