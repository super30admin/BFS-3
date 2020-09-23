// Time Complexity :exponential (n ^ n)
// Space Complexity : size of the set
// Did this code successfully run on Leetcode : Yes
// https://leetcode.com/problems/remove-invalid-parentheses/

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> q=new LinkedList<>();
        HashSet<String> set=new HashSet<>();
        List<String> result=new ArrayList<>();
        q.add(s);
        boolean flag=false;
        while(!q.isEmpty() && !flag)
        {
            int size=q.size();
            for(int j=0;j<size;j++)
            {
                String r=q.poll();
                if(isValid(r))
                {
                    flag=true;
                    result.add(r);                  
                    
                }
                if(flag==false)
                {
                    for(int i=0;i<r.length();i++)
                    {
                        String p=r.substring(0,i)+r.substring(i+1);
                        if(!set.contains(p))
                        {
                            q.add(p);
                            set.add(p);
                            
                        }
                        
                    }
                }
            }
        }
        return result;
        
        
    }
    public boolean isValid(String s){
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
            {
              count++;   
            }else if(s.charAt(i)==')')
            {
                if(count==0) return false;
                
                count--;
            }
            
           
        }
         return count==0;
    }
}