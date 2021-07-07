


class Solution {
    public List<String> removeInvalidParentheses(String s) {
        
        List<String> returnList = new ArrayList<>();
        
        if(s==null) return returnList;
        
        Set<String> hashset = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        
        queue.add(s);
        hashset.add(s);
        
        boolean found = false;
        //bfs
        while(!queue.isEmpty()){
            
            String str = queue.poll();
            
            if(isValid(str)){
                returnList.add(str);
                found =true;
            }
            
            if(!found){
                // add all possible elements to queue
                for(int x=0; x<str.length();x++){
                    if(!Character.isLetter(str.charAt(x))){
                        
                    String str1 = str.substring(0,x)+str.substring(x+1,str.length());// delete one iterm
                       
                        if(!hashset.contains(str1)){ // duplicate elements
                            hashset.add(str1);
                            queue.add(str1);
                        }
                    }
                }
            }
        }
        return returnList;
    }
    private boolean isValid(String str){
        int count=0;
        for(char c: str.toCharArray()){
            if(c == '('){
                count++;
            }else if (c ==')'){
                if( count<=0){
                return false;
            }
               count--; 
            }
            }
        return count==0;
        }
}
