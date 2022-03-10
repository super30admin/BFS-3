package bfs3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParanthesis {
	//BFS
	//Time Complexity : O(2^n), where n is the length of string s
	//Space Complexity : O(n)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        // null
        if(s == null || s.length() == 0)
            return res;
        
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.offer(s);
        set.add(s);
        boolean flag = false;
        
        while(!queue.isEmpty() && !flag) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                String curr = queue.poll();
                if(!isValid(curr)) {
                    if(!flag) {
                        for(int j=0; j<curr.length(); j++) {
                            if(Character.isLetter(curr.charAt(j)))
                                continue;
                            StringBuilder sb = new StringBuilder();
                            sb.append(curr.substring(0, j) + curr.substring(j + 1));
                            if(!set.contains(sb.toString())) {
                                set.add(sb.toString());
                                queue.offer(sb.toString());
                            }
                        }
                    }
                } else {
                    flag = true;
                    res.add(curr);
                }
            }
        }
        return res;
    }
    
    private boolean isValid(String curr) {
        int count = 0;
        for(int i=0; i<curr.length(); i++) {
            if(Character.isLetter(curr.charAt(i)))
                continue;
            if(curr.charAt(i) == '(')
                count++;
            else {
                if(count == 0)
                    return false;
                count--;
            }
        }
        return count == 0;
    }
    
    //DFS
  	//Time Complexity : O(2^n), where n is the length of string s
  	//Space Complexity : O(n)
  	//Did this code successfully run on Leetcode : Yes
  	//Any problem you faced while coding this : No
    int max = 0;
    List<String> res;
    public List<String> removeInvalidParentheses1(String s) {
        res = new ArrayList<>();
        // null
        if(s == null || s.length() == 0)
            return res;

        Set<String> set = new HashSet<>();
        dfs1(s, set);
        return res;
    }
    
    private void dfs1(String s, Set<String> set) {
        // base
        if(set.contains(s) || max > s.length())
            return;
        if(isValid(s)) {
            if(max < s.length()) {
                max = s.length();
                res = new ArrayList<>();
                res.add(s);
            } else if(s.length() == max) {
                res.add(s);
            }
        }
        
        // logic
        set.add(s);
        for(int i=0; i<s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(0, i) + s.substring(i + 1));
            dfs1(sb.toString(), set);
        }
    }
}
