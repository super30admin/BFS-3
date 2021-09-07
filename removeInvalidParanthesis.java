
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result=new ArrayList<>();
        if(s==null || s.length()==0)
            return result;
        Queue<String> queue=new LinkedList<>();
        queue.add(s);
        Set<String> set=new HashSet<>();
        set.add(s);
        boolean found=false;
        
        while(!queue.isEmpty() && found!=true){
            int sz=queue.size();
            
            for(int i=0;i<sz;i++){
                String curr=queue.poll();
                
                if(isValid(curr)){
                    result.add(curr);
                    found = true;
                }else{
                    if(!found){
                        for(int j=0;j<curr.length();j++){
                            if(Character.isLetter(curr.charAt(j))) continue;
                            String child = curr.substring(0,j)+curr.substring(j+1);
                            if(!set.contains(child)){
                                queue.add(child);
                                set.add(child);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
    
    private boolean isValid(String str){
        if(str==null)
            return true;
        int count=0;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c=='(')
                count++;
            else if(c==')')
                count--;
            if(count<0)
                return false;
        }
        return count==0;
    }
    
    
}