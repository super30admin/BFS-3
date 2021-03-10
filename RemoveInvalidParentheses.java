class Solution {
  
    /*
      Time :  O( n ^ 2 ) + O(n * n) | Tree + substring + isValid
      Space : O( n ) | queue + hashSet
     */
    public List<String> removeInvalidParentheses(String s) {
        if(s == null) return new ArrayList<>();
        
        int n = s.length();
        List<String> result = new ArrayList<>();
        Queue<String> que = new LinkedList<>();
        HashSet<String> existingsResultsSet = new HashSet<>();
        que.add(s);
        existingsResultsSet.add(s);
        boolean flag = true;
        
        while(!que.isEmpty()){
            int size = que.size();

            for(int j = 0; j < size; j++){
                String curr = que.poll();
                if(isValid(curr)) {
                    flag = false;
                    result.add(curr);
                }
                
                for(int i = 0; i < curr.length(); i++){
                    
                    if(flag && !Character.isLetter(curr.charAt(i))){
                        String sub = curr.substring(0,i) + curr.substring(i+1);
                        if(!existingsResultsSet.contains(sub)){
                            existingsResultsSet.add(sub);
                            que.add(sub);
                        }
                            
                    }
                }
            }
        }
        return result;
    }
    
    boolean isValid(String s){
        int count = 0;
        
        for(char c : s.toCharArray()){
            if(Character.isLetter(c)) continue;
            else if(c == '('){
                count++;
            }else if(c == ')'){
                if(count == 0) return false;
                count--;
            }
        }
        
        return count == 0;
    }
    
}
