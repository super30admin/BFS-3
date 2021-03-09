/*
here we have to try all possible combinatoins of brackets by doing a BFS approach.
if you find that at any level if the string is valid then no need to proceed to deeper level. 
If not, then remove on char at time and from string and add it queue if not seen before and process it.
TC: O(2^n)
SC :O(2^n), in worst case might end up adding all to visited

*/
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        
        List<String> result = new ArrayList<>();
        
        if(s == null)return result;
        
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        visited.add(s);
        
        boolean flag = false;
        
        while(!queue.isEmpty()){
            String curr = queue.poll();
            if(isValidString(curr)){
                flag = true;
                result.add(curr);
            }
            
            if(!flag){
                for(int i = 0; i < curr.length();i++){
                    if(Character.isLetter(curr.charAt(i)))continue;
                    String nextStr = curr.substring(0,i) + curr.substring(i+1);
                    
                    if(!visited.contains(nextStr)){
                        queue.add(nextStr);
                        visited.add(nextStr);
                    }
                }
            }
        }
        return result;
    }
    
    private boolean isValidString(String s){
        int count= 0;
        for(int i = 0;i < s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(')count++;
            else if(ch == ')'){
                if(count == 0)return false;
                count--;
            }
                
        }
        return count == 0;
    }
}