// Time Complexity - Exponential
// Space Complexity - Exponential

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String>result = new ArrayList<>();
        Set<String> hash = new HashSet<>(); // Hashset to ensure no duplicate strings are processed in BFS
        Queue<String> q = new LinkedList<>(); // q for BFS
        q.add(s);
        boolean  flag= false; // flag to keep track of if first valid parentheses string has been found
        while(!q.isEmpty() && !flag)
        {
            int size =q.size();
            for(int i=0;i<size;i++)
            {
                String curr =q.poll();
                if(valid(curr)) // found a valid parentheses at this level of bfs. no more levels needed hence setting flag to true
                {
                    result.add(curr);
                    flag=true;
                }
                else
                {  
                    for( int k=0;k<curr.length();k++)
                    {   if(Character.isLetter(curr.charAt(k))) continue; // ignore if its not a parentheses as we could have letters too.
                        String newStr = curr.substring(0,k)+curr.substring(k+1);
                        if(!hash.contains(newStr))
                        {
                            hash.add(newStr);
                            q.add(newStr);
                        }
                        
                    }
                    
                }
                
            }
            
        }
        
        return result;
    }
    
  private boolean valid(String s)
  {
      int count =0;
      for(char c : s.toCharArray())
      {
          if(c=='(')
              count++;
          else if(c==')')
              count--;
          if(count==-1)
              return false;
      }
      return count==0;
  }
}