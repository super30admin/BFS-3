// APPROACH 1: DFS
// TC: O(n^n)  //n at level 0, n(n-1) for its child, n(n-1)(n-2), n(n-1)(n-2)(n-3) and so on
// SC: O(n)

// We need to explore all the paths by removing a character one by one from the string
// We do dfs on the children produced by removing a character for every permutation
// Base condition is to check first if the string is valid, if it is then check the length
// If the string is > MAX, we reset the result array and put the new valid string in result array.
// Also update the max variable.
// Basically we need the largest string with minimum removals
// It can also be the string is invalid in the base condition, but we still get its children
// and do the DFS, because removing a character from invalid string might make it valid
// Two parents can produce the exact same string(child) so we maintain a hashset
// That if we have NEVER seen this child before, then only do DFS on it 
// We shouldnt do dfs again on a repeat occuring child of some other parent


class Solution {
    int max;
    ArrayList<String>result;
    HashSet<String>set;
    public List<String> removeInvalidParentheses(String s) {
        //max=0;
        result=new ArrayList<>();
        set=new HashSet<>();
        dfs(s);
        return result;
    }
    public void dfs(String s){
        //base
        if(s.length()<max) return;
        if(isValid(s)){
            if(s.length()>max){
                result=new ArrayList<>();
            }
            result.add(s);
            max=s.length();
        }
        //logic
        for(int i=0;i<s.length();i++){
            String child=s.substring(0,i)+s.substring(i+1);
            if(!set.contains(child)){
                set.add(child);
                dfs(child);
            }
        }
    }
    public boolean isValid(String s){
        int count=0;
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            if(curr != '(' && curr!=')') continue;
            if(curr == '('){
                count++;
            } else {
                if(count==0) return false; //if closing brace came before opening brace
                count--;
            }

        }
        return count==0;
    }
}

// for extra count=0 check in isValid, ()())(, count will be 1,0,1,0,-1,0
// count is 0 but last brackets are )(, string is not valid



// APPROACH 2: BFS
// TC: O(n^n)  
// SC: O(n)



// In BFS approach, we process the children of all parents on the same level together in a queue
// Here instead of max, we use flag true or false
// If the string is valid, flag is true, meaning we dont need to process its children
// and we go to the next parent
// If flag is false, get all the children and add it to the queue
// Here also we use a hashset to check if a child is unique, if not skip and if yes,
// add it to the hashset

class Solution {
    public List<String> removeInvalidParentheses(String s) {

        ArrayList<String> result=new ArrayList<>();
        if(s == null || s.length() ==0) return result;
        if(isValid(s)){
            result.add(s);
            return result;
        }
        HashSet<String> set=new HashSet<>();
        Queue<String> q=new LinkedList<>();
        q.add(s); 
        //set.add(s); --not needed
        boolean flag=false;
        while(!q.isEmpty()){
            String curr=q.poll();
            if(isValid(curr)){ //if your string is valid, no need to go to the children
                result.add(curr);
                flag=true;
            }
            
            if(!flag){ //if parent was not valid, process the children
                for(int i=0;i<curr.length();i++){
                    char c=curr.charAt(i);
                    if(c !='(' && c!=')') continue; //if its a character, ignore it
                    String child=curr.substring(0,i)+curr.substring(i+1);
                    if(!set.contains(child)){ //only add and process a unique child
                        q.add(child);
                        set.add(child); //another parent can have the same exact child string so we use hashset
                    }
                }
            }
        }
        return result;
        
    }
    public boolean isValid(String s){
            int count=0;
            for(int i=0;i<s.length();i++){
                char c=s.charAt(i);
                if (c != '(' && c!=')') continue;
                if(c=='(') count++;
                else{
                    if(count==0) return false;
                    count--;
                }
            }
            return count==0;
        }
}