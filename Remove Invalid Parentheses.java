//Time Complexity-O(2^n)
//Space Complexity-O(n)
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String>output=new ArrayList();
        if(s==null)
        {
            return output;
        }
        HashSet<String>set=new HashSet();
        Queue<String>queue=new LinkedList();
        boolean found=false;
        queue.add(s);
        set.add(s);
        while(!queue.isEmpty())
        {
            String front=queue.poll();
            if(isValid(front))
            {
                output.add(front);
                found=true;
            }
            if(!found)
            {
                for(int i=0;i<front.length();i++)
                {
                    if(front.charAt(i)!='('&& front.charAt(i)!=')')
                    {
                        continue;
                    }
                    String newStr=front.substring(0,i)+front.substring(i+1,front.length());
                    if(!set.contains(newStr))
                    {
                        set.add(newStr);
                        queue.add(newStr);
                    }
                }
            }
        }
        return output;
    }
    
    boolean isValid(String s)
    {
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(count==-1)
            {
                return false;
            }
            if(s.charAt(i)=='(')
            {
                count++;
            }
            else if(s.charAt(i)==')')
            {
                count--;
            }
            
        }
        return count==0;
    }
}