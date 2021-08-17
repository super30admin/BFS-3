//Time Complexity - 
//Space Complexity - 
// BFS
/** Process the string level by level. 
** Remove the character and check if its valid
** If its valid just add it to the result and continue the process but no need to add string children ** to the queue.
** If its invalid then add it to the set and its children to the queue and continue the process
**/
class Solution {
 
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if(s == null || s.length() == 0) {return result;}
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        q.add(s); // add original string 
        set.add(s);
        boolean flag = false;
        
        while(!q.isEmpty() && !flag) { 
          int size = q.size(); //process the entire level
          for(int i = 0; i<size;i++) {
            String curr = q.poll();
            if(isValid(curr)) {
              flag = true;
              result.add(curr);
            } else {
              if(!flag){
                 for(int j = 0; j< curr.length();j++) {
                   if(Character.isLetter(curr.charAt(j))) {
                     continue;
                   } else {
                     String child = curr.substring(0,j) + curr.substring(j+1);
                     if(!set.contains(child)) {
                       set.add(child);
                       q.add(child);
                     }
                   }
                 }
              }
            }
          }
        }
      return result;
    }
  
  public boolean isValid(String s) {
    int count = 0;
    for(int i = 0; i< s.length();i++) {
      char c = s.charAt(i);
      if(c == '(') {
        count ++;
      } else if(c == ')'){
        if(count == 0) {
          return false;
        }
        count --;
      }
    }
    return count == 0;
  }
}