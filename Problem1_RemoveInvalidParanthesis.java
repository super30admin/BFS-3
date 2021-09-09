// Time Complexity : o(n^n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    // BFS
    public List<String> removeInvalidParentheses(String s) {
        
        if(s.length()==0 ||s==null)
            return new ArrayList<>();
        
        List<String> result=new ArrayList<>();
        Queue<String> queue=new LinkedList<>();
        
        queue.add(s);
        
        Set<String> set=new HashSet<>();
        set.add(s);
        
        boolean found=false;
        
        while(!queue.isEmpty())
        {
            int size=queue.size();
            
            for(int i=0;i<size;i++)
            {
                String curr=queue.poll();
                
                 if(isValid(curr))
                 {
                     result.add(curr);
                     found=true;
                 }
                else
                {
                    if(!found)
                    {
                        for(int j=0;j<curr.length();j++)
                        {
                            if(Character.isLetter(curr.charAt(j)))
                                continue;
                            String child=curr.substring(0,j)+curr.substring(j+1);
                            
                            if(!set.contains(child))
                            {
                                queue.add(child);
                                set.add(child);
                               
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
    
    private boolean isValid(String str)
    {
        int count=0;
        
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)==')')
                count--;
            else if(str.charAt(i)=='(')
                count++;
            if(count<0)
                return false;
            
        }
        
        return count==0;
    }
    
    
}
