class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if(s==null || s.length()==0)
            return result;
        HashSet<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        boolean flag = false;
        q.add(s);
        set.add(s);
        while(!q.isEmpty() && flag == false){
            int size = q.size();
            for(int i=0;i< size;i++){
                String curr = q.poll();
                if(isValid(curr)){
                    flag = true;
                    set.add(curr);
                    result.add(curr);
                }
                else
                { if(!flag){ // only if the flag is false at that level, then only form the babies of the parent
                    for(int j=0;j<curr.length();j++){
                        String child = curr.substring(0,j)+curr.substring(j+1);
                        if(!set.contains(child)){
                        q.add(child);
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
        int count =0;
        for(int i=0;i< str.length();i++){
            char ch = str.charAt(i);
            if(ch=='(')
                count++;
            else if(ch ==')'){
                if(count ==0)
                    return false;
                count--;
            }
        }
        return count==0;
    }
}