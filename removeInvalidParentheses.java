//TC : O(2^n)
//SC : O(2^n)
class Solution {

    public List<String> removeInvalidParentheses(String s) {
        if(s==null||s.length()==0) return new ArrayList();
        HashSet<String> hs = new HashSet();
        List<String> result = new ArrayList();
        Queue<String> q = new LinkedList();
        q.add(s);
        boolean flag = false;
        while(!q.isEmpty() || !flag)
        {
            int size = q.size();

            String qString = q.poll();
            if(!checkString(qString))
            {
                for(int j=0;j<qString.length();j++)
                {
                    if(Character.isLetter(qString.charAt(j))) continue;
                    String newString = qString.substring(0,j)+qString.substring(j+1);
                    if(!hs.contains(newString) && !flag)
                    {
                        q.add(newString);
                        hs.add(newString);
                    }
                }
            }
            else
            {
                flag = true;
                result.add(qString);
            }
        }
        return result;
    }

    public boolean checkString(String s){
        int count = 0;
        int n = s.length();
        for(int i=0;i<n;i++)
        {
            char c = s.charAt(i);
            if(c=='(')
            {
                count++;
            }
            else if(c==')')
            {
                count--;
                if(count<0)
                    return false;
            }
        }
        return count == 0;
    }

}