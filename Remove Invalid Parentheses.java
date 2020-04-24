// Time Complexity :o(2^n)
// Space Complexity :o(2^n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res=new LinkedList<>();
        Set<String> set=new HashSet<>();
        Queue<String> q=new LinkedList<>();
        boolean gotonextlevel=true;
        q.offer(s);
       // set(s);
        
        while(!q.isEmpty()){
            int count=q.size();
          for(int i=0;i<count;i++){
              String test=q.poll();
              
              if(!set.contains(test)){
              if(isvalid(test)){
                  gotonextlevel=false;
                  res.add(test);
              }
                  set.add(test); 
                  if(gotonextlevel){
                  for(int k=0;k<test.length();k++){
                      if(Character.isLetter(test.charAt(k))) continue;
                      String child=test.substring(0,k)+test.substring(k+1);
                      
                      
                          q.add(child);
                      
                     
                  }
              }
              }
          }
            if(!gotonextlevel) break;
        }
        return res;
    }
    
    public boolean isvalid(String s){
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') count++;
            if(s.charAt(i)==')') count--;
            if(count <0)return false;
        }
        return count==0;
    }
}