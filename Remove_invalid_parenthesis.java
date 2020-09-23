import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
	//Approach: Here we keep an queue and iterate through BFS, by removing one parenthesis at a time and then we will check if we have got any valid ones, even if we got a validn string we will still be iterating at the same level.
	//incase if we havent got any valid ones in a level then we go to the next level by removing one more extra paranthesis and checking if they are valid.
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        
        if(s == null)
            return result;
        
        Queue<String> queue = new LinkedList<>();
        queue.add(s);set.add(s);
        boolean flag = false;
        while(!queue.isEmpty() && !flag)
        {
            int size = queue.size();
            for(int i=0;i<size;i++)
            {
                String str = queue.poll();
                if(isValid(str))
                {
                    flag = true;
                    result.add(str);
                }
                if(!flag)
                {
                    for(int j=0;j<str.length();j++)
                    {
                        String child = str.substring(0, j)+ str.substring(j+1);
                        if(!set.contains(child))
                        {
                            set.add(child);
                            queue.add(child);
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
        for(int i=0; i<s.length();i++)
        {
            if(Character.isLetter(s.charAt(i)))
                continue;
            if(s.charAt(i) == '(')
            {
                count++;
            }else if(s.charAt(i) == ')')
            {
                if(count == 0)return false;
                count--;
            }
        }
        return count == 0;
    }
}
//Time Complexity : O(n ^ n )at worst case
//Space Complexity : O(n) where n is the length of the string
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this :