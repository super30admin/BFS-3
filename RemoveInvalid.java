//Time - O(n^2 * 2^n)
//Space - O(n)
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        
        List<String> list = new ArrayList<>();
         if(s==null)
             return list;
        Set<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        
        boolean flag = false;
        set.add(s);
        q.add(s);
        
        while(!q.isEmpty()){
                String curr = q.poll();
                if(isValid(curr)){
                    list.add(curr);
                    flag = true;
                }
                
                if(!flag) {
                    for(int i=0;i<curr.length();i++){
                        if(Character.isLetter(curr.charAt(i)))
                            continue;
                        String str = curr.substring(0,i)+curr.substring(i+1);
                        if(!set.contains(str))
                       { 
                            q.add(str);
                            set.add(str);
                        }
                    }
                }
            
        }
        return list;
    }
    private boolean isValid(String s){
        int count = 0;
        for(int i=0; i<s.length(); i++){
            char  c = s.charAt(i);
            if(c == '(') count++;
            if(c == ')'){
                if(count==0)return false;
                count--;
            }
        }
        return count==0;
    }
}
