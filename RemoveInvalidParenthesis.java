class Solution {

    // Time Complexity : 0(n^n)where n is the length of the string
// Space Complexity : 0(n^n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No

    HashSet<String> set;    //hashset to store all the possible combinations of parenthesis I have encountered
    List<String> result;    //to store the valid parenthesis after least removal of parenthesis and return
    public List<String> removeInvalidParentheses(String s) {
        if(s.length() == 0 || s == null){
            return new ArrayList<>();
        }
        set = new HashSet<>();
        result = new ArrayList<>();
        boolean found = false;  //found variable to state if a valid parenthesis has been found at that particular level or not
        Queue<String> q = new LinkedList<>();   //to store all the invalid parenthesis and get it's substring to check for valid ones
        q.add(s);   //adding the original string
        set.add(s); //also adding it to list of visited parenthesis
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String curr = q.poll();
                if(isValid(curr)){  //checking if the current parenethesis isvalid or no
                    result.add(curr);//if yes then adding it to the result
                    found = true;   //changing found to true so that I don't process another level as at this level I have found a valid parenthesis with minimum removals. I will process all the substrings at this particular level though to check if there are other valid parenthesis or not
                }
                else{   //if the parenthesis is invalid
                    if(found == false){ //and if the satus is false
                        for(int j = 0; j < curr.length(); j++){ //running a loop through the length of the string
                            if(Character.isLetter(curr.charAt(j))){ //checking if it is character, then continuing as I don't have to handle this case
                                continue;
                            }
                            String child = curr.substring(0, j) + curr.substring(j+1);  //generating substrings eliminating 1 character at a time or eliminating j
                            if(!set.contains(child)){   //if the substring is not present in hashset means I have not processed it and needs processing
                                set.add(child); //ence adding to the set
                                q.add(child);   //adding to the queue to process it
                            }
                        }
                    }
                }
            }
        }
        return result;  //returning result
    }
    public boolean isValid(String s){
        int count = 0;  //if count is 0 at the end, means that there is valid no of parenthesis
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){   //if I encounter an opening bracket, then i do count++
                count ++;
            }
            else if (c == ')'){ //if closing then decrease count
                count--;
            }
            if(count < 0){  //of count goes below 0, means there are more closing than opening or the parenthesis is not valid, hence returning false
                return false;
            }
        }
        return count == 0;  //if count is equal to 0 at the end, then there are equal no. of opening and closing brackets and are in correct order hence return true if so
    }
}

//DFS

class Solution {
    HashSet<String> set;
    List<String> result;
    int max;
    public List<String> removeInvalidParentheses(String s) {
        if(s.length() == 0 || s == null){
            return new ArrayList<>();
        }
        set = new HashSet<>();
        result = new ArrayList<>();
        // boolean found = false;
        // Queue<String> q = new LinkedList<>();
        // q.add(s);
        // set.add(s);
        // while(!q.isEmpty()){
        //     int size = q.size();
        //     for(int i = 0; i < size; i++){
        //         String curr = q.poll();
        //         if(isValid(curr)){
        //             set.add(curr);
        //             result.add(curr);
        //             found = true;
        //         }
        //         else{
        //             if(found == false){
        //                 for(int j = 0; j < curr.length(); j++){
        //                     if(Character.isLetter(curr.charAt(j))){
        //                         continue;
        //                     }
        //                     String child = curr.substring(0, j) + curr.substring(j+1);
        //                     if(!set.contains(child)){
        //                         set.add(child);
        //                         q.add(child);
        //                     }
        //                 }
        //             }
        //         }
        //     }
        // }
        dfs(s);
        return result;
    }
    public void dfs(String s){
        //base
        if(s.length() < max){
            return;
        }
        //logic
        if(isValid(s)){
            if(s.length() > max){
                max = s.length();
                result = new ArrayList<>();
                result.add(s);
            }
            else if(s.length() == max){
                result.add(s);
            }
        }
        else{
            for(int i = 0; i < s.length(); i++){
                if(Character.isLetter(s.charAt(i))){
                    continue;
                }
                String child = s.substring(0, i) + s.substring(i+1);
                if(!set.contains(child)){
                    set.add(child);
                    dfs(child);
                }
            }
        }
    }
    public boolean isValid(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                count ++;
            }
            else if (c == ')'){
                count--;
            }
            if(count < 0){
                return false;
            }
        }
        return count == 0;
    }
}