TC -O(n^n)
SC -O(n)

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        q.add(s);
        set.add(s);
        boolean flag = false;
        while(!q.isEmpty() && !flag){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String curr = q.poll();
                if(isValid(curr)){
                    flag = true;
                    result.add(curr);
                }else{
                    if(!flag){
                        for(int j = 0; j < curr.length(); j++){
                            if(Character.isLetter(curr.charAt(j)))continue;
                                String child = curr.substring(0 , j) + curr.substring(j + 1);
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
        int count = 0 ;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isLetter(c)) continue;
            else if(c == '(') {count++;}
            else if(c == ')'){
                if(count == 0) return false;
                else{
                    count--;
                }
            }
        }
        return count == 0;
    }
}
