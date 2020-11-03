//Time Complexity: 2^N
//Space Complexity: 2^N we might need to add all elements in queue
//Did it run on leetcode: yes

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        
        ArrayList<String> output = new ArrayList<>();
        
        if(s.length()==0){
            output.add("");
            return output;
        }
        
        LinkedList<String> queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        queue.add(s);
        boolean found = false;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                String front = queue.poll();
                if(!set.contains(front) && front!=null){
                    set.add(front);
                    if(isValid(front)){
                        found = true;
                        output.add(front);
                    }
                    for(int j=0; j<front.length(); j++){
                        if(front.charAt(j)!='(' && front.charAt(j)!=')')
                            continue;
                        else
                            queue.add(front.substring(0,j)+front.substring(j+1,front.length()));
                    }
                }
                
            }
            if(found==true)
                break;
        }
        
        return output;
    }
    
    private boolean isValid(String s){
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(')
                count += 1;
            else if(s.charAt(i)==')'){
                count -= 1;
                if(count<0)
                    return false;
            }
        }
        return count == 0;
    }
}
