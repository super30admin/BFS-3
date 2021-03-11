// Time Complexity : The time complexity is O(2^n * n^2) where n is the length of the string
// Space Complexity : The space complexity is O(2^n)  where n is the length of the string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public List<String> removeInvalidParentheses(String s) {

        List<String> output = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        q.offer(s);
        set.add(s);

        if(isValid(s)){
            output.add(s);
            return output;
        }

        while(!q.isEmpty()){

            int size = q.size();

            for(int i=0;i<size;i++){
                String cur = q.poll();

                // remove each character and check for validity
                for(int j=0;j<cur.length();j++){

                    char ch = cur.charAt(j);
                    if(Character.isLetter(ch)) continue;

                    String newStr = cur.substring(0,j) + cur.substring(j+1,cur.length());
                    // string is valid
                    if(isValid(newStr)){
                        if(!set.contains(newStr)){
                            set.add(newStr);
                            output.add(newStr);
                        }
                    }
                    //string is not valid
                    else{
                        if(output.size() == 0 && !set.contains(newStr)){
                            set.add(newStr);
                            q.offer(newStr);
                        }
                    }
                }
            }

            if(output.size() != 0){
                return output;
            }
        }

        return output;

    }

    public boolean isValid(String s){

        int count = 0;

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(') count++;
            else if(ch == ')'){
                if(count == 0){return false;}
                else count--;
            }
        }
        return count == 0;
    }
}