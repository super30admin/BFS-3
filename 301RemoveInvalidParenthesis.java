/*
Approach : 
Put the input into the queue .
Check if it is valid
    a) if valid stop 
    b) if not then put all the strings  babies into the queue.And so on .

We can do depth first ie keep processing the string in depth and then upon reaching the leaf go to the next child of the root. -DFS
BFS is better here because while visiting all the children of root if we find a valid case we stop going into that child's lineage depth.

Intuition:
If I can find potential solution at level 1 then I dont need to go to the lower level say level 2 because I need to find the minimum no of invalid parentheses



*/

class Solution {
    public List<String> removeInvalidParentheses(String s) {
       List<String> result = new ArrayList<>();
        System.out.println(s.length());
        if(s == null   ) return result;
        
       
        
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        q.add(s); set.add(s);
        
        boolean flag = false;
        
        while(!q.isEmpty()){
            String curr = q.poll(); // ()())()
            if(isValid(curr)){
                flag = true;
                result.add(curr);
            }
            
            if(!flag){
                for(int i = 0 ; i <curr.length() ;i++){
                   
                    if(Character.isLetter(curr.charAt(i))) continue;
                     String child = curr.substring(0,i) +curr.substring(i+1); //dropped ith value
                    if(!set.contains(child)){
                        set.add(child);
                        q.add(child);
                   } 
                }
            }
        }
        System.out.println("result "+result);
        return result;
    }
    
    private boolean isValid(String s){
        int count = 0 ;
        for( int i =0 ; i < s.length();i++){
            char c = s.charAt(i);
            if(c == '(') count++;
            else if(c == ')'){
                if(count == 0 ) return false;
                count--;
            } 
            
        }
        return count==0;
    }
}
/*
Time Complexity : 2^n (choosing and not choosing '('or ')'. There are  n elements to be validated.Substring takes O(2^n * n^2)  Exponential
Space Complexity: O(n) + O(n) = O(2n)

/*
Input: ""
0
result []
output [""]


*/