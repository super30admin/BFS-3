//TC - Exponential
//SC - O(n)
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        if(s == null || s.length() == 0){
            return new ArrayList<>();
        }
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();

        q.add(s);
        set.add(s);
        boolean flag = false;
        while(!q.isEmpty()){
            // int size = q.size();
            // for(int i = 0; i < size; i++){
                String curr = q.poll();
                if(isValid(curr)){
                    flag = true;
                    result.add(curr);
                }
                else if(flag == false){
                    for(int j = 0; j < curr.length(); j++){
                        char c = curr.charAt(j);
                        if(c >= 'a' && c <= 'z'){
                            continue;
                        }
                        String newStr = curr.substring(0,j) + curr.substring(j+1);
                        if(!set.contains(newStr)){
                            q.add(newStr);
                            set.add(newStr);
                        }
                    }
                }
            // }


        }
        return result;
    }
    private boolean isValid(String str){
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == '('){
                count++;
            }
            else if(c == ')'){
                count--;
                if(count < 0){
                return false;
            }
        }
            

    }
    return count == 0;
    }
}