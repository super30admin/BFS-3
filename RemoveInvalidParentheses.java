// Time Complexity : O(2^n) n = no of combinations of brackets
// Space Complexity : O(n) n = no of combinations of brackets we have seen in the set
// Did this code successfully run on Leetcode : Yes 

// Your code here along with comments explaining your approach

// Put the string s in the queue. Maintain a set that keeps a track of combinations of brackets
// we have seen till now. For each of the strings, explore further by removing the bracket one by one 
// and check each of team as valid or invalid string. Maintain a count to check the no of brackets if the
// count < 0 or not 0 at the end, it means that it is invalid. If it is valid string make the flag as true 
// means we wont go to next level since we need this in min no of steps. But we would explore all the remaining
// strings in the queue so that we dont miss out on other valid strings if we have

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if(s == null || s.length() == 0) {
            result.add("");
            return result;
        }
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        q.add(s);
        boolean flag = false;
        while(!q.isEmpty() && !flag) {
            int size = q.size();
            for(int j=0;j<size;j++) {
                String curr = q.poll();
                if(isValid(curr)) {
                    flag = true;
                    result.add(curr);
                } else {
                    for(int k=0;k<curr.length();k++) {
                        if(Character.isLetter(curr.charAt(k))) continue;
                        String temp = curr.substring(0,k)+curr.substring(k+1);
                        if(!set.contains(temp)) {
                            q.add(temp);
                            set.add(temp);
                        }
                    }
                }
            }
        }
        return result;
    }
    
    private boolean isValid(String str) {
        if(str == null) return true;
        int count = 0;
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i) == '(') {
                count++;
            } else if(str.charAt(i) == ')') {
                count--;
                if(count < 0) return false;
            }
        }
        return count==0;
    }
}