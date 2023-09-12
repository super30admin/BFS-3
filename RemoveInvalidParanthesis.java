import java.util.*;

// Time Complexity : O(n^n)
// Space Complexity : O(n^n)
// Did this code successfully run on Leetcode : Yes

// without using size of the queue
public class RemoveInvalidParanthesis {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if(s== null || s.length() == 0) return result;
        HashSet<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        boolean flag = false;
        q.add(s);
        set.add(s);

        while(!q.isEmpty())
        {
            String currStr = q.poll();
            if(isValid(currStr))
            {
                flag = true;
                result.add(currStr);
            }
            else
            {
                if(!flag)
                {
                    for(int i=0; i<currStr.length(); i++)
                    {
                        if(Character.isAlphabetic(currStr.charAt(i))) continue;
                        String babyStr = currStr.substring(0,i)+currStr.substring(i+1);
                        if(!set.contains(babyStr))
                        {
                            set.add(babyStr);
                            q.add(babyStr);
                        }
                    }
                }
            }

        }
        return result;
    }

    private boolean isValid(String s){
        int count = 0;
        for(char c: s.toCharArray()){
            if(Character.isAlphabetic(c)) continue;
            else if(c == '('){
                if(count < 0) return false;
                count++;
            }
            else if(c == ')') {
                count--;
            }
        }

        return count == 0;
    }
}

