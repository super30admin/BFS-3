// Time Complexity : O(2^n)
// Space Complexity : O(2^n)

class Solution {
  public List<String> removeInvalidParentheses(String s) {
    List<String> result = new ArrayList<>();
    Queue<String> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    queue.add(s);
    visited.add(s);
    boolean flag = false;
    while(!queue.isEmpty()) {
      String current = queue.poll();
      if(isValid(current)) {
        result.add(current);
        flag = true;
      } else if(flag == false) {
        for(int i = 0; i<current.length(); i++) {
          char skip = current.charAt(i);
          if(skip >= 'a' && skip <= 'z') continue;
          String newCurrent = current.substring(0,i) + current.substring(i+1, current.length());
          if(!visited.contains(newCurrent)) {
            queue.add(newCurrent);
            visited.add(newCurrent);
          }
        }
      }
    }
    return result;
  }

  boolean isValid(String s) {
    int count = 0;
    for(int i = 0; i<s.length(); i++) {
      if(s.charAt(i) == '(') count++;
      else if(s.charAt(i) == ')') {
        count--;
        if(count<0) return false;
      }
    }
    return count == 0;
  }
}