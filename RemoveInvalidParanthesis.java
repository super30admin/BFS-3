//https://leetcode.com/problems/remove-invalid-parentheses/
// Time Complexity :O(nCr)  
// Space Complexity :O(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result=new ArrayList<>();
        if(s.length()==0||s==null) return result;
        Queue<String> q=new LinkedList<>();
        HashSet<String> set=new HashSet<>();//to check visited
        q.add(s);
        set.add(s); //no need to explore again
        boolean level=false;
        while(!q.isEmpty() && !level)
        {
            int size=q.size();
            for(int j=0;j<size;j++)
            {
                String curr=q.poll();
                if(isValid(curr))
                {
                    level=true;
                    result.add(curr);
                }
                else
                {
                    for(int i=0;i<curr.length();i++)
                    {
                        if(Character.isLetter(curr.charAt(i))) continue;
                        String child=curr.substring(0,i)+curr.substring(i+1);
                        if(!set.contains(child))
                        {
                            q.add(child);
                            set.add(child);
                        }
                    }
                }
            }
            
        }
        return result;
    }
    private boolean isValid(String s)
    {
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(c=='(') count++;
            if(c==')') count--;
            if(count<0)return false; //if ")"
        }
        return count==0;
    }
}