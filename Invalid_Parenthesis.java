//Time complexity: n^n
//space complexity: o(n)
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        
        List<String> result = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        
        q.add(s);
        set.add(s);
        boolean flag = false;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0;i<size;i++){
                String curr = q.poll();
                
                if(!isValid(curr)){
                    if(!flag){
                    for(int j = 0; j< curr.length();j++){
                        char ele = curr.charAt(j);
                        if(Character.isLetter(ele)){
                            continue;
                        }
                        String newCurr = curr.substring(0,j)+curr.substring(j+1);
                        if(!set.contains(newCurr)){
                            q.add(newCurr);
                            set.add(newCurr);
                        }
                    }
                    }
 
                }
                else{
                    result.add(curr);
                    flag = true;
                }
            }
        }

        return result;   
    }
    
    private boolean isValid(String s){
        int count = 0;
        for(int i = 0;i<s.length();i++){
            
        char ele = s.charAt(i);
        if(ele == '('){
            count++;
        }
        else if(ele == ')' && count == 0){
            return false;
        }
       else if(ele ==')' && count !=0){
                count--;
            } 
        }

        if(count == 0 ){
            return true;
        }
        
        return false;
    }
}