//Time Complexity - O(n^n) - exponential
//Space Complexity - 
// backtrack

class Solution {
    int max;
    List<String> result;
    HashSet<String> set;
    
    public List<String> removeInvalidParentheses(String s) {
        result = new ArrayList<>();
        if(s == null || s.length() == 0) {return result;}
        set  = new HashSet<>();
        backtrack(s);
        return result;
    }
  public void backtrack(String s) {
    //base
    if(set.contains(s) || s.length() < max) return;
    if(isValid(s)) {
      if(s.length() > max) {
        max = s.length();
        result = new ArrayList<>();
      }
      result.add(s);
    }
    //logic
    set.add(s);
    for(int i = 0; i< s.length();i++) {
      //action
      char c = s.charAt(i);
      if(Character.isLetter(c)) continue;
      //recurse
      String child = s.substring(0,i) + s.substring(i+1);
      backtrack(child);
      //backtrack
    }
    
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