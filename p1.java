// Time Complexity : O(n^n)
// Space Complexity :O(n^n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        set.add(s);
        q.add(s);
        boolean flag = true;
//BFS
        while(flag && !q.isEmpty()){
            int size = q.size();
            //Go through all the string sin queue
            for(int i=0; i<size; i++){
                String st = q.poll();
                //If string is valid, we won't process the next level
                if(isValid(st)){
                    result.add(st);
                    flag = false;
                }//If string is not valid, get it's child and put it in queue
                else if(flag){
                    for(int k=0; k<st.length(); k++){
                        char c = st.charAt(k);
                        if(Character.isAlphabetic(c)) continue;
                        else{
                            String baby = st.substring(0,k) + st.substring(k+1, st.length());
                            if(!set.contains(baby)){
                                set.add(baby);
                                q.add(baby);
                            }
                        }
                    }
                }
            }
        }

        return result;
    }
//using count varaibale to check if the string is valid
    private boolean isValid(String s){
        int count = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isAlphabetic(c)) continue;
            else{
                if(c == '('){
                    count++;
                }
                else{
                    if(count == 0) return false;
                    count--;
                }
            }
        }

        return count ==0;
    }
}