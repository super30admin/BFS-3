// Time complexity: O(2^N)
// Space complexity: O(N)

import java.util.*;


class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if(s==null) return result;
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        boolean flag = false;
        q.add(s);
        
        while(!q.isEmpty())
        {
            String curr = q.poll();
            if(isValid(curr))
            {
                flag = true;
                result.add(curr);
            }
            
            if(!flag)
            {
                for(int i=0; i < curr.length(); i++)
                {
                    if(Character.isLetter(curr.charAt(i)))  continue;
                    String child = curr.substring(0, i) + curr.substring(i+1);
                    if(!set.contains(child))
                    {
                        set.add(child);
                        q.add(child);
                    }
                        
                    
                }
            }
        }
      return result;  
    }
    
    public boolean isValid(String s)
    {
        int count = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '(')
            {
                count += 1;
            }
            else if(s.charAt(i) == ')')
            {
               if(count==0) return false;
                else
                    count -= 1;
            }
                
        }
        return count==0;
    }
}