// Time, Space -  O(2^N), O(N)

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        
        if(s == null) {
            return new ArrayList<>();
        }
        
        Queue<String> q = new LinkedList<>();
        
        List<String> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        q.add(s);
        set.add(s);
        
        Boolean flag = false;
        
        while(!q.isEmpty() && !flag) {
            int size = q.size();
            
            for(int i=0;i<size;i++) {
                String ele = q.poll();
            
                if(isValid(ele)) {
                    result.add(ele);
                    flag = true;
                }
                if(!flag) {
                    for(int j=0;j<ele.length();j++) {
                        if(Character.isLetter(ele.charAt(j))) {
                            continue;
                        }
                        String child = ele.substring(0,j) + ele.substring(j+1,ele.length());
                        if(!set.contains(child)) {
                            q.add(child);
                            set.add(child);
                        }
                        
                    }
                }
            }
        }
        
        return result;
    
    }
    
    private boolean isValid(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        
        int cnt = 0;
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(Character.isLetter(ch)) {
                continue;
            }
            if(ch == '(') {
                cnt++;
            }
            else {
                cnt--;
            }
            if(cnt == -1) {
                return false;
            }
        }
        
        
        return cnt==0;
        
    }
}
