/*
 *  Approach: We try to generate children for every string and check if each is invalid or not. 
 * When we find first valid string, we stop searching for next children.
 */

import java.util.*;
public class RemoveInvalidParanthesis
{
    public static HashSet<String> set;
    public static List<String> result;
    public static List<String> removeInvalidParantheses(String s)
    {
        if(s == null || s.length() == 0) return new ArrayList<>();

        set = new HashSet<>();
        result = new ArrayList<>();

        set.add(s);
        Queue<String> q = new LinkedList<>();
        q.add(s);
        boolean found = false;

        while(!q.isEmpty())
        {
            String curr = q.poll();

            if(isValid(curr))
            {
                found = true;
                result.add(curr);
            }else{
                if(found == false)
                {
                    for(int j =0;j<curr.length();j++)
                    {
                        if(Character.isLetter(curr.charAt(j))) continue;

                        String child = curr.substring(0,j)+curr.substring(j+1);

                        if(!set.contains(child))
                        {
                            set.add(child);
                            q.add(child);
                        }
                    }
                }
            }
        }

        return result;

    }

    private static boolean isValid(String s)
    {
        int count = 0;
        for(int i =0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                count++;
            }
            else if(s.charAt(i)==')'){
                count--;
                if(count<0)
                {
                    return false;
                }
            }
        }

        return count == 0;
        
    }
    
    public static void main(String args[])
    {
        List<String> ans = removeInvalidParantheses("()())()");
        System.out.println(ans);
    }
}