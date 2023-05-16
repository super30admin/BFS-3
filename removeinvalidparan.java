class Solution {
    //TC-O(2^N)
    //SC-O(2^N)
    // if string is already valid, then return it,else add it in a queue and do bsf,
    // at each level , pop out all the elements one by one, check if its valid, then set flag is true and need not process its children,but its siblings are to be processed which are already in the queue, while processing children, check if its already in set and add to both set and queue
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if(s==null || s.length()==0) return result;
        if(isvalid(s)){
            result.add(s);
            return result;
        }
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        boolean flag = false;
        q.add(s);
        set.add(s);
        while(!q.isEmpty() && !flag){
            int size = q.size();
            for (int k=0;k<size;k++){
                String curr = q.poll();
                if(isvalid(curr)){
                    flag=true;
                    result.add(curr);
                }
                if(!flag){
                    for(int i=0;i<curr.length();i++){
                        String child = curr.substring(0,i)+curr.substring(i+1);
                        if(!set.contains(child)){
                            set.add(child);
                            q.add(child);
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
            char c = s.charAt(i);
            if(c=='('){
                count++;
            }
            else if(c==')'){
                if(count==0)return false;
                else count--;
            }
        }
        return count==0;
    }
}