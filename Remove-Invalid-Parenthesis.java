/*Time Complexity: O(N)

Space Complexity: O(2N)

Did this code successfully run on Leetcode : Yes

Approach: BFS - Add the string s in queue and set. Check if the string is valid, else remove one
char from the string and add to set and queue.

Prob: 301. Remove Invalid Parentheses
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        q.add(s);
        set.add(s);
        boolean flag = false;
        while(!q.isEmpty() && !flag){
            int size = q.size();
            for(int i = 0;i < size; i++){
                String curr = q.poll();
                if(isValid(curr)){
                    flag = true;
                    res.add(curr);
                }
                // if not valid, start removing char
                if(!flag){
                    for(int j = 0; j < curr.length(); j++){
                        char c = curr.charAt(j);
                        if(!Character.isAlphabetic(c)){
                            String child = curr.substring(0,j) + curr.substring(j+1);
                            if(!set.contains(child)){
                                set.add(child);
                                q.add(child);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
    private boolean isValid(String s){
        int count = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isAlphabetic(c)) continue;
            if(c == ')'){
                if(count == 0) return false;
                count--;
            }
            else{
                count++;            
            }
        }
        if(count != 0) return false;
        return true;
        }
    }
