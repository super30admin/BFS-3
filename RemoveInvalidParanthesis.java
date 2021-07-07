// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(n) since in worst case scenario we might have to reach all levels 
//Space Complexity: O(n) or O(L) where L is number of levels since we are using additional queue
 class Solution {
    public List<String> removeInvalidParentheses(String s) {
        ArrayList<String> result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.add(s); visited.add(s);
        boolean isValid = false;
        while(!q.isEmpty() && !isValid){
            int size = q.size();
            for(int i = 0; i < size; i++){
              String curr = q.poll();
              if(isValid(curr)){
                  result.add(curr);
                  isValid = true;
              }
              
              if(!isValid){
                  for(int k = 0; k < curr.length(); k++){
                      if(Character.isLetter(curr.charAt(k))) continue; // remove unnecessary alphabets or letters
                      String child = curr.substring(0, k) + curr.substring(k+1); // remove the paranthesis
                      if(!visited.contains(child)){
                        q.add(child);
                        visited.add(child);
                      }
                  }
              }
                
            }
        }
        return result;
    }
    
    private boolean isValid(String str){
        int count = 0;
        for(int i = 0; i < str.length(); i++){
           char c = str.charAt(i);
           if(c == '('){
               count++;
           }
           else if (c == ')'){
               if(count == 0) return false; // since if the beginning itself is )
               count--;
           }        
        }
        return count == 0;
    }    
}