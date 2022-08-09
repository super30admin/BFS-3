//****143.301.INVALID PARANTHESIS- BFS SOLUTION****
// Time Complexity :n factorial
// Space Complexity :n factorial
// Did this code successfully run on Leetcode :y
// Any problem you faced while coding this :n

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        if(s==null) return new ArrayList<>();
        //Set to make sure that only unique strings are added into the result
        HashSet<String> set=new HashSet<>();
        //List for storing the result and returning it
        List<String> result=new ArrayList<>();
        //Queue for performing the BFS
        Queue<String> q=new LinkedList<>();
        
        //Initally adding the given string in q
        q.add(s);
        boolean flag=false;
        
        while(!q.isEmpty() && !flag)
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                //Getting the string from the queue
                String curr=q.poll();
                //Checking if that is valid or not
                if(isvalid(curr))
                {
                    flag=true;
                    result.add(curr);
                }
                else   //if the string is not valid
                {
//If the flag is true than we are sure that at the level we are we have already found a valid string and hence we dont need to make any babies.
//so we will check if the flag is false, then only go and make the babies of the current string
                    if(!flag)
                    {
                        for(int j=0;j<curr.length();j++)
                        {
                            if(Character.isLetter(curr.charAt(j))) continue;
                            String child=curr.substring(0,j)+curr.substring(j+1);
                            if(!set.contains(child))
                            {
                                set.add(child);
                                q.add(child);
                            }
                        }
                    }
                }
                
            }
            
        }
        return result;
        
    }
    
    public boolean isvalid(String curr)
    {
        int count=0;
        for(int i=0;i<curr.length();i++)
        {
            char c=curr.charAt(i);
            
            if(Character.isLetter(c)) continue;
            else if(c=='(')
            {
                count++;
            }
            else if(c==')')
            {
                if(count==0) return false;
                else count--;
            }
        }
        
        return count==0;
        
    }
}

// Your code here along with comments explaining your approach
