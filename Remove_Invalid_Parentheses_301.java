//Time Complexity : Exponential
//Space Complexity : 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Remove_Invalid_Parentheses_301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if(s == null)
            return result;
        Queue<String> q = new LinkedList<>();
        boolean flag = false;
        HashSet<String> set = new HashSet<>();
        q.add(s);
        
        while(!q.isEmpty() && !flag)
        {
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                String currString = q.poll();
                if(isValid(currString))
                {
                    result.add(currString);
                    flag = true;
                }
                if(!flag)
                {
                    for(int j = 0; j < currString.length(); j++)
                    {
                        if(Character.isLetter(currString.charAt(j)))
                            continue;
                        String childString = currString.substring(0,j) + currString.substring(j+1);
                        if(!set.contains(childString))
                        {
                            q.add(childString);
                            set.add(childString);
                        }
                    }
                }
            }
        }
        return result;
    }
    private boolean isValid(String str)
    {
        int count = 0;
        for(int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if(ch == '(')
                count++;
            else if(ch == ')')
            {
                if(count == 0)
                    return false;
                else
                    count--;
            }
        }
        return count == 0;
    }
}
