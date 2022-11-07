// Time Complexity : O(n^n)
// Space Complexity : O(n^n)
// n is the length of given string s
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

//Method 3 - DFS
// TC: O(n^n) (every string of length n can have (n-1) babies)
// SC: O(n^n)
// n is the length of given string s
class Solution {
    HashSet<String> set;
    List<String> result;
    int max;
    public List<String> removeInvalidParentheses(String s) {
        result = new ArrayList<>();
        set = new HashSet<>();
        if(s == null || s.length() == 0)
            return result;
        dfs(s);
        return result;
    }
    private void dfs(String s){
        //base case
        if(s.length() < max || set.contains(s))
            return;
        if(isValid(s)){
            if(s.length() > max){
                max = s.length();
                result = new ArrayList<>();
                result.add(s);
            }
            else if(s.length() == max){
                result.add(s);
            }
            set.add(s);
        }

        //logic
        set.add(s);
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            String child = s.substring(0,i) + s.substring(i+1);
            dfs(child);
        }
    }

    private boolean isValid(String s){
        int count =0;
        for(int i = 0; i < s.length() ; i++){
            char c = s.charAt(i);
            if(Character.isLetter(c)) continue;
            if(c == '(')
                count++;
            else if(c == ')')
                count --;
            if(count < 0)
                return false;
        }
        return count == 0;
    }
}

// Method 2 - BFS - without using size variable for queue
// TC: O(n^n) (every string of length n can have (n-1) babies)
// SC: O(n^n)
// n is the length of given string s
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        //null check
        if(s == null || s.length() == 0)
            return result;
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        q.add(s);
        set.add(s);
        boolean flag = false;
        while(!q.isEmpty()){
            String curr = q.poll();
            System.out.println(curr);
            if(isValid(curr)){
                result.add(curr);
                flag = true;
            }
            if(!flag){
                for(int j = 0; j < curr.length() ; j++){
                    char c = curr.charAt(j);
                    if(Character.isLetter(c)) continue;
                    String child = curr.substring(0,j) + curr.substring(j+1);
                    if(!set.contains(child)){
                        q.add(child);
                        set.add(child);
                    }
                }
            }
        }
        return result;
    }
    private boolean isValid(String s){
        int count = 0;
        for(int i = 0 ; i < s.length(); i++){
            char c  = s.charAt(i);
            if(Character.isLetter(c)) continue;
            if(c == '(')
                count++;
            else if (c == ')') count--;
            if(count < 0)
                return false;
        }
        return count == 0;
    }
}


// Method 1 - BFS - using size variable for queue
// TC: O(n^n) (every string of length n can have (n-1) babies)
// SC: O(n^n)
// n is the length of given string s
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        //null check
        if(s == null || s.length() == 0)
            return result;
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        q.add(s);
        set.add(s);
        boolean flag = false;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i <size ; i++){
                String curr = q.poll();
                if(isValid(curr)){
                    result.add(curr);
                    flag = true;
                }
                if(!flag){
                    for(int j = 0; j < curr.length() ; j++){
                        char c = curr.charAt(j);
                        if(Character.isLetter(c)) continue;
                        String child = curr.substring(0,j) + curr.substring(j+1);
                        if(!set.contains(child)){
                            q.add(child);
                            set.add(child);
                        }
                    }
                }
            }
        }
        return result;
    }
    private boolean isValid(String s){
        int count = 0;
        for(int i = 0 ; i < s.length(); i++){
            char c  = s.charAt(i);
            if(Character.isLetter(c)) continue;
            if(c == '(')
                count++;
            else if (c == ')') count--;
            if(count < 0)
                return false;
        }
        return count == 0;
    }
}
