// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        Queue<String> q =  new LinkedList<>();
        boolean flag = false;
        q.add(s);
        while(!q.isEmpty() && !flag)
        {
            int size = q.size();
            for(int i = 0 ; i <size;i++)
            {
                String currString = q.poll();
                if(isValid(currString))
                {
                    result.add(currString);
                    flag = true;
                    
                }
                if(!flag)
                {
                    for(int x = 0 ; x < currString.length();x++)
                    {
                        if(Character.isLetter(currString.charAt(x))) continue; 
                        String child = currString.substring(0,x) + currString.substring(x+1);
                        if(!set.contains(child))
                        {
                            set.add(child);
                            q.add(child);
                        }
                
                   } 
                }

                
            }
        }
        return result;
    }
    private boolean isValid(String s)
    {
        int count =0;
        for(Character c:s.toCharArray())
        {
            if(c == '(')
            {
                count++;
            }
            else if (c==')')
            {
                if(count==0) return false;
                count--;
            }
        }
        return count==0;
    }
}