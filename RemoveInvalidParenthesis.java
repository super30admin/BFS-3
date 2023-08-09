/* TC = O(n^n) as in the tree each node has n nodes and further every node has n-1 nodes and so on 
 * Approach == Go in a BFS manner and whenever we encounter a valid 
 * string at a particular level add it to the result array 
 * and if string is invalid remove a bracket again for the next level but before that after
 * every level check whether we found any valid strings in that level - if
 * yes then stop else continue to next level
*/

class Solution {
    public List<String> removeInvalidParentheses(String s) {
       HashSet<String> set = new HashSet<>();
       Queue<String> q = new LinkedList<>();
       ArrayList<String> result = new ArrayList<>();
       q.add(s); set.add(s);
       boolean flag = false;
       while(!q.isEmpty()){
           int size = q.size();
           for(int i=0;i<size;i++){
                String temp = q.poll();
                if(isValid(temp)){
                    flag = true;
                    result.add(temp);
                }else{
                    if(!flag){
                        
                            for(int j=0;j<temp.length();j++){
                                if(!Character.isAlphabetic(temp.charAt(j))){
                                String child = temp.substring(0,j) + temp.substring(j+1);
                                if(!set.contains(child)){
                                    q.add(child); set.add(child);
                                }
                                
                            }
                        }
                    }
                }
           }
       }
       return result;
    }
    private boolean isValid(String str){
        int count = 0;
        for(int i=0;i<str.length();i++){
            
            char c = str.charAt(i);
            if(c == '(') count++;
            else if(c == ')'){
                if(count==0) return false;
                count--;
            }
            
        }
        return count == 0;
    }
}