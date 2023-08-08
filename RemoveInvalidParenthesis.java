import java.util.*;

public class RemoveInvalidParenthesis {
    //Time complexity for both implementations is O(N^N)
    //Space complexity: unsure
    List<String> valid;
    HashSet<String> duplicate;
    int maxLen =0;
    public List<String> removeInvalidParenthesesBFS(String s) {
        // BFS
        // find valid after removing one char from the string
        valid = new ArrayList<>();
        duplicate = new HashSet<>();
         Queue<String> queue = new LinkedList<>();
         queue.offer(s);
         boolean flag = false;
         while(!queue.isEmpty()){
             String current = queue.poll();
             //if current is Valid we need not check the child as we want the minimum number of deletions
             if(isValid(current)){
                 flag = true;
                 valid.add(current);
             }
             if(!flag){
                 for(int i = 0; i< current.length(); i++){
                     if(Character.isAlphabetic(current.charAt(i))) continue;
                     String newStr = current.substring(0, i)+ current.substring(i+1);
                     if(!duplicate.contains(newStr)){
                         queue.offer(newStr);
                         duplicate.add(newStr);
                     }
                 }
             }

         }
        helper(s);
        return valid;
    }
    public List<String> removeInvalidParenthesesDFS(String s) {
        helper(s);
        return valid;
    }

    private void helper(String s){
        //base
        if(s.length() < maxLen) return;
        else{
            if(isValid(s)){
                if(s.length() > maxLen){
                    valid = new ArrayList<>();
                }
                maxLen = s.length();
                valid.add(s);
                return;
            }
        }

        //logic
        for(int i = 0; i< s.length(); i++){
            if(Character.isAlphabetic(s.charAt(i))) continue;
            String newStr = s.substring(0, i)+ s.substring(i+1);
            if(!duplicate.contains(newStr)){
                duplicate.add(newStr);
                helper(newStr);
            }
        }
    }


    private boolean isValid(String str){
        int count = 0;
        for(char ch:str.toCharArray()){
            if(Character.isAlphabetic(ch)) continue;

            if(ch == '(') count++;
            else if(ch == ')'){
                if(count == 0) return false;
                count--;
            }
        }

        return count == 0;
    }
}
