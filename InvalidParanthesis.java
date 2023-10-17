//TC = O(n^n)
//SC = O(n^n) 
// Here we are using BFS.
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        q.add(s);
        set.add(s);
        boolean flag = false;
        while(!q.isEmpty() && !flag){
            int size = q.size();
            for(int i = 0; i<size;i++){
                String curr = q.poll();
                if(isValid(curr)){
                    flag = true;
                    res.add(curr);
                }else{
                    if(!flag){
                        for(int k = 0; k<curr.length(); k++){
                            char c = curr.charAt(k);
                            if(Character.isLetter(c)) continue;
                            String baby = curr.substring(0,k) + curr.substring(k+1);
                            if(!set.contains(baby)){
                                q.add(baby);
                                set.add(baby);
                            }
                        }
                    }
                }
            } 
        }
        return res;
    }
    private boolean isValid(String s){
        int count = 0;
        for(int i =0; i<s.length(); i++){
            char c = s.charAt(i);
            if(count<0) return false;
            if(Character.isLetter(c)) continue;
            if(c == '('){
                count++;
            }else{
                count --;
            }
        }
        return count==0;
    }
}