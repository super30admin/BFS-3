public class BalanceParenthesis {
    // TC is O(n*n!)
    // SC is n!
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        boolean flag = false;
        while(!q.isEmpty() && !flag){
            int size = q.size();
            for(int i=0; i<size;i++){
                String curr = q.poll();
                if(!isValid(curr)){
                    if(!flag){
                        for(int j=0;j<curr.length();j++){
                        String subString = curr.substring(0,j)+curr.substring(j+1);
                        if(!set.contains(subString)){
                        set.add(subString);
                        q.add(subString);
                        }

                    }
                    }

                }else{
                    result.add(curr);
                    flag = true;
                }
            }
        }
        return result;
    }

    private boolean isValid(String s){
        // base
        // if(s == null || s.length() == 0) return true;
        int count = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                count++;
            }else if(c == ')'){
                count--;
            }
            if(count < 0) return false;
        }
        return count == 0;
    }
} 