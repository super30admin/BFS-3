// Time Complexity :O(V+E)
// Space Complexity :O(n)

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result=new ArrayList<>();
        if(s==null) return result;
        HashSet<String> set=new HashSet<>();
        Queue<String> q=new LinkedList<>();
        boolean flag=false;
        q.add(s);set.add(s);
        while(!q.isEmpty())
        {
            //int size=q.size();
            //for(int j=0;j<size;j++)
            //{
                String curr=q.poll();
                if(valid(curr))
                {
                    flag=true;
                    result.add(curr);
                }
                if(!flag)
                {
                    for(int i=0;i<curr.length();i++)
                    {
                        if(Character.isLetter(curr.charAt(i))) continue;
                        String baby=curr.substring(0,i)+curr.substring(i+1);
                        if(!set.contains(baby))
                        {
                            set.add(baby); q.add(baby);
                        }
                    }
                }
           // }
        }
        return result;
    }
    private boolean valid(String s)
    {
        int count=0;
        for(int i=0;i<s.length();i++)
        {
             char c=s.charAt(i);
             if(c=='(') count++;
             else if(c==')')
                 
             {
                if(count==0) return false;
                 else count--;
              }
        }
       
        return count==0;
    }
}
