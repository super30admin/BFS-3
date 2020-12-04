class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        //Base case 
        if(s == null )
            return result;
        HashSet<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        boolean found = false;
        
       // set.add(s);
        queue.add(s);
        
        while(!queue.isEmpty()){
            //Length of queue
            int size = queue.size();
            while(size>0){
                s = queue.poll();
            
            if(isValid(s)){
                result.add(s);
                found = true;
            }
            if(!found){
                //backtracking choices
                for(int i = 0 ; i<s.length() ; i++){
                   //For char other than ( )
                    if(Character.isLetter(s.charAt(i)))
                        continue;
                    String t = s.substring(0,i) + s.substring(i+1);
                    if(!set.contains(t)){
                        set.add(t);
                        queue.add(t);
                    }
                }
            }
            size--;
            }
            if(found)return result;
            
        }
        return result;
     }
    public boolean isValid(String s){
        int count = 0;
        for(int i = 0; i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(') count++;
            else if(c == ')'){
                if(count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }
}