// Time Complexity : O(N pow N)
// Space Complexity : O(N pow N) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
* 1. it is BFS approach to solve the problem.
* 2. do BFS level by level and stop by using boolean flag when valid string found.
* 3. at each level for each string find all possible combinations and check is valid or not.
*/
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        
        List<String> result = new ArrayList<>();
        Queue<String> queue=new LinkedList<>();
        Set<String> set=new HashSet<>();
        boolean found=false;
        
        queue.add(s);
        set.add(s);
        
        while(!found && !queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                String str= queue.poll();
                if(isvalid(str)){
                    found=true;
                    result.add(str);
                    set.add(str);
                }else if(!found){
                    for(int j=0;j<str.length();j++){
                        if(Character.isLetter(str.charAt(j))) continue;
                        String child= str.substring(0,j)+str.substring(j+1);
                        
                        if(!set.contains(child)){
                            queue.add(child);
                            set.add(child);
                        }
                    
                    }
                }
            }
        }
        return result;
    }
    
    private boolean isvalid(String s){
        int count=0;
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ')'){
                if(count==0) return false;
                count--;
            }else if(s.charAt(i) == '('){
                count++;
            }
        }
        return count==0;
    }
}