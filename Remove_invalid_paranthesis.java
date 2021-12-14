class Solution {
    
    public List<String> removeInvalidParentheses(String s) {
        List<String> result  = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.add(s);
        visited.add(s);
        boolean flag = false;
        while(!q.isEmpty()){
            String curr = q.poll();
            if(isValid(curr)){
                flag = true;
                result.add(curr);
            }
            if(!flag){
                for(int k = 0; k < curr.length(); k++){
                    if(Character.isLetter(curr.charAt(k))) continue;
                    String child = curr.substring(0, k) + curr.substring(k+1);
                    if(!visited.contains(child)){
                        q.add(child);
                        visited.add(child);
                    }
                }
            }
        }
        return result;
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

//TC: O(n)
//SC: O(n)
