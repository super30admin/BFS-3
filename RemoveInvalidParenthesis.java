//BFS
//time o(2 pow n)
//space o(2 pow n)
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if(s == null)
            return res;
        
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        boolean flag = false;
        q.add(s);
        
        while(!q.isEmpty() && !flag) {
            int size = q.size();
            for(int k=0; k<size; k++) {
                String cur = q.poll();
                if(isValid(cur)) {
                    flag = true;
                    res.add(cur);
                }
                if(!flag) {
                    for(int i=0; i<cur.length(); i++) {
                        // if we encounter letters
                        if(Character.isLetter(cur.charAt(i)))
                            continue;
                        String child = cur.substring(0,i) + cur.substring(i+1);
                        if(!set.contains(child)) {
                            set.add(child);
                            q.add(child);
                        }
                    } 
                }
            }
        }
        return res;
    }
    
    private boolean isValid(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                count++;
            }
            else if(ch == ')') {
                if(count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }
}