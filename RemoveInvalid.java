import java.util.*;

public class RemoveInvalid {
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> q = new LinkedList<>();

        List<String> result = new ArrayList<>();
        if(s == null || s.length()==0)return result;
        Set<String> visited = new HashSet<>();
        boolean found=false;
        q.add(s);
        visited.add(s);
        while(!q.isEmpty()){
            String curr = q.poll();

            if(isValid(curr)){
                result.add(curr);
                found = true;
            }
            if(!found){
                for(int j=0;j<curr.length();j++){
                    char c = curr.charAt(j);
                    if(Character.isLetter(c))continue;
                    String newStr = curr.substring(0,j)+curr.substring(j+1);
                    if(!visited.contains(newStr)){
                        q.add(newStr);
                        visited.add(newStr);
                    }
                }
            }
        }
        return result;
    }

    private boolean isValid(String curr){
        int count=0;
        for(int i=0;i<curr.length();i++){
            char c = curr.charAt(i);
            if(Character.isLetter(c))continue;
            if(c=='(') count++;
            else if(c==')') count--;
            if(count<0)return false;
        }
        return count==0;
    }
}
