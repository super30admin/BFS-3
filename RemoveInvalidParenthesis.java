class RemoveInvalidParenthesis {
    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> set = new HashSet<>();
        List<String> res= new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        boolean flag = false;
        while(!q.isEmpty() && !flag)
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                String cur =q.poll();
                if(isValid(cur))
                {
                    res.add(cur);
                    flag = true;
                }
                if(!flag)
                {
                    for(int j=0;j<cur.length();j++)
                    {
                        char c = cur.charAt(j);
                        if(Character.isAlphabetic(c))
                        continue;
                        String baby = cur.substring(0,j) + cur.substring(j+1);
                        if(!set.contains(baby))
                        {
                            q.add(baby);
                            set.add(baby);
                        }
                    }
                }
            }
        }
    return res;
    }

    private boolean isValid(String s)
    {
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            char c =s.charAt(i);
            if(Character.isAlphabetic(c))
            continue;
            if(c=='(')
            count++;
            else
            {
                if(count==0)
                return false;
                count--;
            } 
           
        }
        if(count==0)
        return true;
        return false;
    }
}

/*Time Complexity: O(2^n * n)

Space Complexity: O(2^n * n) */