class Solution {
    
    public List<String> removeInvalidParentheses(String s) {
    
        List<String> ans = new ArrayList();
        if(s==null || s.length()==0) return ans;
        
        Queue<String> q = new LinkedList();
        Set<String> vis = new HashSet();
        
        
        q.add(s);
        vis.add(s);
        boolean found = false;
        
        while(!q.isEmpty()) {
            
            s = q.poll();
            
            
            if(isValid(s)) {
                ans.add(s);
                found=true;
            }
            
            if(found) continue;
            
            for(int i = 0;i<s.length();i++) {
                
                if(Character.isLetter(s.charAt(i))) continue;
                String sub = s.substring(0,i) + s.substring(i+1, s.length());
                if(!vis.contains(sub)) {
                    vis.add(sub);
                    q.add(sub);
                }
                
            }
            
        }
        
        return ans;
    }
    
    boolean isValid(String s) {
          int count = 0;

          for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') count++;
            if (c == ')' && count-- == 0) return false;
          }

          return count == 0;
    }
    
}
