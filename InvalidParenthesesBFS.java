import java.util.*;

//Time Complexity=O(2^n)
//Sapce Complexity=O(n)
public class InvalidParenthesesBFS {

    public List<String> removeInvalidParentheses(String s) {

        List<String> result=new ArrayList<String>();
        HashSet<String> set=new HashSet<>();
        boolean flag=false;
        Queue<String> q=new LinkedList<>();
        q.add(s);
        set.add(s);
        while(!q.isEmpty() && !flag){
            int size=q.size();

            for(int i=0;i<size;i++){
                String curr=q.poll();
                if(isValid(curr)){
                    result.add(curr);
                    flag=true;
                }else{
                    if(!flag){
                        for(int j=0;j<curr.length();j++){
                            if(Character.isLetter(curr.charAt(j))) continue;
                            String newStr=curr.substring(0,j)+curr.substring(j+1);
                            if(!set.contains(newStr)){
                                set.add(newStr);
                                q.add(newStr);
                            }

                        }
                    }

                }

            }
        }
        return result;
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
