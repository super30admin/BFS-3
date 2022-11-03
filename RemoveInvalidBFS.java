class Solution {
    //tc-n^n sc = n^n
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if(s == null || s.length() == 0) return null;
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        q.add(s);
        set.add(s);
        boolean flag = false;
        while(!q.isEmpty() && !flag)//if at anu level the we find a valid string we will not
        //explore the next level as in the next level we will be removing char from valid strings
        //which leads to imbalanced string
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                String curr = q.poll();
                if(isValid(curr))
                {
                 result.add(curr);
                 flag = true;
                }
                if(!flag)// we explore all the strings in a level even after we find a valid string. If these strings are not valid we will not explore its babies as we need max length
                {
                    for(int j=0;j<curr.length();j++)
                    {
                        char c = curr.charAt(j);
                        if(Character.isLetter(c)) continue;
                        String child = curr.substring(0,j) + curr.substring(j+1);
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
        int count =0;
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(Character.isLetter(c)) continue;
            if(c == '(') count++;
            else if(c == ')') count--;
            if(count <0) return false;
        }
        return count ==0;
    }
}