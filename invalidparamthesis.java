// TC =O(mn)
// SC= O(n)

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        q.add(s); set.add(s);
         boolean flag = false;
        while(!q.isEmpty() && !flag){
            int size = q.size();           
            for(int k = 0; k < size; k++){
                String curr = q.poll();
                if(isValid(curr)){
                    flag = true;
                    result.add(curr);
                }
                if(!flag){
                    for(int i = 0; i < curr.length(); i++){
                        char c = curr.charAt(i);
                        if(Character.isAlphabetic(c)) continue;
                        String baby = curr.substring(0,i) + curr.substring(i+1);
                        if(!set.contains(baby)){
                            q.add(baby); set.add(baby);
                        }
                    }
                }
            }
        }
        return result;
    }
    private boolean isValid(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isAlphabetic(c)) continue;
            if(c == '('){
                count++;
            } else {
                if(count == 0){
                    return false;
                }else{
                    count--;
                }
            }
        }
        return count == 0;
    }
}