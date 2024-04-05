class Solution {
    //TC: O(n^2)
    //SC: O(n)
    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        set.add(s);
        q.add(s);
        boolean flag = false;
        while(!q.isEmpty() && !flag){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String curr = q.poll();
                if(isValid(curr)){ 
                    flag = true;
                    result.add(curr);
                }
                if(!flag){
                //remove 1 char at a time
                    for(int j = 0; j < curr.length(); j++){
                        char c = curr.charAt(j);
                        if(!Character.isAlphabetic(c)){
                            String child = curr.substring(0,j) + curr.substring(j+1);
                            if(!set.contains(child)){
                                set.add(child);
                                q.add(child);
                            }
                        }
                    }
                }
            }
        } 
        return result;
    }

    private boolean isValid(String s){
        int count  = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isAlphabetic(c)) continue;
            if(c == ')'){
                if(count  == 0) return false;
                count--;
            }else count++;
        }
        if(count != 0) return false;
        return true;
    }
}
