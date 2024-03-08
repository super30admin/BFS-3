//TC = O(n^n) as per sir
//SC = O(n)
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        List<String> result = new ArrayList<>();
        set.add(s);
        q.add(s);

        //BFS
        boolean flag = false;
        while(!q.isEmpty() && !flag)
        {
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                String cur = q.poll();
                if(isValid(cur))
                {
                    flag = true;
                    result.add(cur);
                }

                //adding the babies to the queue
                if(!flag)
                {
                    //remove one character at a time
                    for(int j = 0; j < cur.length(); j++)
                    {
                        char c = cur.charAt(j);
                        if(!Character.isAlphabetic(c))
                        {
                            String child = cur.substring(0,j) +  cur.substring(j+1,cur.length());
                            if(!set.contains(child))
                            {
                                set.add(child); q.add(child);
                            }
                        }
                    }
                }
            }

        }
        return result;
    }

    boolean isValid(String s)
    {
        int count = 0;
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(Character.isAlphabetic(c)) continue;
            if(c == ')')
            {
                if(count == 0) return false;
                else count--;
            }
            else count++;  
        }
        if(count !=0 ) return false;
        return true;
    }
}
