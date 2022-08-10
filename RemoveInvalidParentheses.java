import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Time: O(n^2)
//Space: O(n)

//BFS Solution
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        //null case check
        if(s == null || s.length() == 0) return new ArrayList<>();
        //list where we will store the valid strings with minimum removals
        List<String> result = new ArrayList<>();
        
        //Queue for BFS and HashSet so that we do not process the exact substring twice if that occurs
        Queue<String> q = new LinkedList<>(); //O(k*n) space
        HashSet<String> set = new HashSet<>(); //O(k*n) space
        
        //initializing the queue and hashset with the original string and flag to denote a valid string
        q.add(s); set.add(s); boolean flag = false;
        
        //here we will process strings/substrings at each level of BFS and until we find a valid string
        while(!q.isEmpty() && !flag) {
            int size = q.size();
            //looping over the strings at each level of BFS
            for(int i = 0; i < size; i++) { //O(n)**************************
                //removing the frontmost element on the queue and storing it in curr
                String curr = q.poll();
                //if curr string is valid then we set the flag to true and adding it to the result
                if(isValid(curr)) {
                    flag = true;
                    result.add(curr);
                } else { //if curr string is not valid
                    if(!flag) { //we process it's babies only if we have not found a valid string yet
                        for(int j = 0; j < curr.length(); j++) { //O(k*n)**********************
                            //skipping the loop if we encounter a letter
                            if(Character.isLetter(curr.charAt(j))) continue;
                            //creating children of the curr string by removing a character one after another
                            //joining substrings while excluding the jth character 
                            String child = curr.substring(0, j) + curr.substring(j+1); 
                            //if that children does not already exist in the set then we add the unique string to queue and set
                            if(!set.contains(child)) {
                                q.add(child); set.add(child);
                            }
                        }
                    } 
                }
            }  
        }
        return result;
    }
    
    //helper functions to check if a string is valid
    private boolean isValid(String s) {
        //we will maintain a count variable which we will increment for '(' and decrement for ')'
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) { //O(n)***********************************
            if(Character.isLetter(s.charAt(i))) {
                continue;
            } else if(s.charAt(i) == '(') {
                count++;
            } else if(s.charAt(i) == ')') {
                //as soon as count becomes negative, it means this string can not be valid thus ending here to save time
                if(count == 0) return false;
                count--;
            }
        }
        //return true if count is '0' after all the iterations
        return count == 0;
    }
}