//Time Complexity: O(n)
//Space Complexity: O(1)

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        //base case
        if(s == null)
            return result;
        //queue for bfs traversal
        //hashset- to avoiad duplicate strings
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        //if true, valid string is found; initialized by false
        boolean flag = false;
        //add first string to queue
        q.add(s);
        //add s to set initially
        set.add(s);
        //repeat till queue has elements
        while(!q.isEmpty()){
            //pull 1st element of the queue
            String curr = q.poll();
            //check if is a valid string before any operation
            if(isValid(curr)){
                flag =true;
                //add the to the resultant list
                result.add(curr);
            }
            //if string is a valid string
            //falg = true
            if(!flag){
                for(int i=0; i< curr.length(); i++){
                    //if character, continue
                    if(Character.isLetter(curr.charAt(i)))
                        continue;
                    //else for every character of the string, try removing each 
                    //character and check if is a valid string
                    String temp = curr.substring(0,i) + curr.substring(i+1);
                    //if not a duplicate string
                    //add to set and in queue
                    if(!set.contains(temp)){
                        set.add(temp);
                        q.add(temp);
                    }
                }
            }
        }
        return result;
    }
    
    //to check if a string is valid: 
    //'(' -> count+1
    //')' -> if 0 -> false :  count-1 
    private boolean isValid(String s){
        int count=0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') count++;
            else if(c == ')'){
                if(count == 0)
                    return false;
                else
                    count--;
            }
        }
        return count == 0;
    }
}