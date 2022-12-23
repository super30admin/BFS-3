// Time Complexity :O(L)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
 * 1 - Approach 1 - BFS
 * a) Idea is to keep making babies of the parent until we find a valid string at that particular level.
 * -Add original string to the queue and HashSet
 * -Perform BFS until queue is not empty and flag is not true
 * -Poll the string and check if it is a valid string
 * -If it is, make flag true and add it to the result
 * -If it is not, make the babies out of it if flag is not true and add it to the queue.
 * ******
 * Can also be done without the size var and flag but this solution is better since not all babies get processed.
 * ******
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InvalidParanthesis {
    List<String> result;
    public List<String> removeInvalidParentheses(String s) {
        result = new ArrayList<>();
        
        if(s == null)
            return result;
        
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        q.add(s);
        set.add(s);
        boolean flag = false;
        
        while(!q.isEmpty() && !flag)
        {
            int size = q.size();
            for(int i=0; i<size; i++)
            {
                String curr = q.poll();
                if(isValid(curr))
                {
                    flag = true;
                    result.add(curr);
                }
                else
                {
                    if(!flag)
                    {
                        for(int j=0; j<curr.length(); j++)
                        {
                            if(Character.isLetter(curr.charAt(j)))
                                continue;
                            String child = curr.substring(0,j) + curr.substring(j+1);
                            if(!set.contains(child))
                            {
                                set.add(child);
                                q.add(child);
                            }
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
        for(int i = 0; i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(Character.isLetter(ch))
                continue;
            else if(ch == '(')
                count++;
            else if(ch == ')'){
                if(count == 0)
                    return false;
                else
                    count--;
            }
        }
        return count == 0;
    }
}
