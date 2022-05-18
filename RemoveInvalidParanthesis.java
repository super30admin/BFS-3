// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {

    //using BFS, we remove one char at a time to check validity, thus exploring all options

    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList();
        Queue<String> q = new LinkedList();
        //queue for running BFS
        Set<String> set = new HashSet();
        //use set because repeated subproblems may be created. We only want to process one of them.
        //so we add a child to queue only if it is not already present in the queue
        boolean flag = false;
        //flag tells us if a valid string has been found at this level

        q.add(s);
        set.add(s);

        while(!q.isEmpty() && !flag)
        {
            //we use size to govern level, so that using flag we can consider if we want to go to the next
            //level or not
            int size = q.size();
            for(int i=0; i<size; i++)
            {
                String current = q.poll();
                if(isValid(current))
                {
                    result.add(current);
                    flag = true; //valid string found at this level
                    //no need to create babies further, baby will have odd chars and even at next to next
                    //level even char valid baby is found, we only want the longest answers
                }
                //valid string not found at this level yet, we need to check next level
                if(!flag)
                {
                    //create babies for next level
                    for(int j=0; j<current.length(); j++)
                    {
                        char c = current.charAt(j);
                        if(Character.isLetter(c))
                            continue;
                        String child = current.substring(0,j) + current.substring(j+1);
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
        int count = 0;
        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if(Character.isLetter(c))
               continue;
            if(c=='(')
                count++;
            else if(c == ')')
                count--;
            if(count < 0)
                return false;
        }

        return count == 0;
    }
}
