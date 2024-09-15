class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String>result = new ArrayList<>();
        
        if(s==null) return result;
        HashSet<String>set1 = new HashSet<>();
        Queue<String>queue = new LinkedList<>();
        boolean found = false;
        
        set1.add(s); queue.add(s);
        while(!queue.isEmpty())
        {
            s=queue.poll();
            if(isValid(s))
            {
                result.add(s);
                found=true;
            }
            if(!found)
            {
                for(int i=0;i<s.length();i++)
                {
                    if(Character.isLetter(s.charAt(i))) continue;
                    String t = s.substring(0,i)+s.substring(i+1);
                    if(!set1.contains(t))
                    {
                        set1.add(t);
                        queue.add(t);
                    }
                }
            }
        }
        
        return result;
    }
    
    public boolean isValid(String s)
    {
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(c=='(') count++;
            if(c==')') 
            {   if(count==0) return false; // V imp condition to check invalid eg -> ))((.
                count--;
            }
        }
        
        if(count==0) return true;
        else return false;
    }
}
