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


//****143.301.INVALID PARANTHESIS- BFS SOLUTION****
// Time Complexity :n factorial
// Space Complexity :n factorial
// Did this code successfully run on Leetcode :y
// Any problem you faced while coding this :n

class Solution {
    HashSet<String> set;
    List<String> result;
    int max;
    
    public List<String> removeInvalidParentheses(String s) 
    {
        if(s==null) return new ArrayList<>();
        //Set to make sure that only unique strings are added into the result
        set=new HashSet<>();
        //List for storing the result and returning it
        result=new ArrayList<>();
        //Calling dfs
        dfs(s);
        
        return result;
        
    }
    
    private void dfs(String s)
    {
        //Base
        if(set.contains(s)) return;
        if(s.length()<max) return;
        
        //logic
        set.add(s);
        if(isvalid(s))
        {
            //Add to result
            if(max!=s.length())
            {
                result=new ArrayList<>();
            }
            //update the max
            max=s.length();
            result.add(s);
        }
        else
        {
            //if not valid then go to its children
            for(int i=0;i<s.length();i++)
            {
                if(Character.isLetter(s.charAt(i))) continue;
                String curr=s.substring(0,i)+s.substring(i+1);
                dfs(curr);
            }
        }
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
