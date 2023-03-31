// bfs
public class RemoveInvalidParantheses {
    public List<String> removeInvalidParentheses(String s) {
        int n = s.length();
        List<String> result = new ArrayList<>();
        // null case
        if(s==null || n<0) return result;
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        boolean flag = false;
        q.add(s);
        set.add(s);
        while(!q.isEmpty()){
                String curr = q.poll();
                if(isValid(curr)){
                    result.add(curr);
                    flag = true;
                }
                if(!flag){
                    for(int j=0;j<curr.length();j++){
                        char ch = curr.charAt(j);
                        if(Character.isLetter(ch)) continue;
                        String child = curr.substring(0,j) + curr.substring(j+1);
                        if(!set.contains(child)){
                            set.add(child);
                            q.add(child);
                        } 
                    }
                }
            }
        return result;
    }

    private boolean isValid(String s){
        int count = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isLetter(c)) continue;
            if(c=='(') count++;
            else if(c==')') count--;
            if(count<0) return false;
        }
        return count==0;
    }
}

// TC - n^n (worst case)
// SC - n^n

// dfs
public class RemoveInvalidParantheses {
    List<String> result;
    Set<String> set;
    int max;
    public List<String> removeInvalidParentheses(String s) {
        int n = s.length();
        result = new ArrayList<>();
        set = new HashSet<>();
        // null case
        if(s==null || n<0) return result;
        boolean flag = false;
        dfs(s);        
        return result;
    }
    private void dfs(String s){
        // base
        if(s.length()<max || set.contains(s)) return;
        if(isValid(s)){
            if(s.length()>max){
                max = s.length();
                result = new ArrayList<>();
                result.add(s);
            } else if(s.length()==max){
                result.add(s);
            }
            set.add(s);
        }

        // logic
        set.add(s);
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isLetter(c)) continue;
            String child = s.substring(0,i) + s.substring(i+1);
            dfs(child);
        }
    }

    private boolean isValid(String s){
        int count = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isLetter(c)) continue;
            if(c=='(') count++;
            else if(c==')') count--;
            if(count<0) return false;
        }
        return count==0;
    }
}

// TC - O(n^n)
// SC - O(n^n)