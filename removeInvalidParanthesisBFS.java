class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        set.add(s);
        Queue<String> q = new LinkedList<>();
        q.add(s);
        boolean flag = false;
        
        while(!q.isEmpty()) {
            String curr = q.poll();
            if(isValid(curr)){
                list.add(curr);
                flag=true;
            } else {
                if(!flag) {
                    for(int j = 0; j<curr.length(); j++) {
                        if(Character.isLetter(curr.charAt(j))) continue;
                        String spl = curr.substring(0,j) + curr.substring(j+1);
                        if(!set.contains(spl)) {
                            set.add(spl);
                            q.add(spl);
                        }
                    }
                }
            }
        }
        return list; 
    }
    
    public boolean isValid(String curr) {
        int count = 0;
        for(int i = 0; i< curr.length(); i++) {
            if(curr.charAt(i)=='(') count++;
            else if(curr.charAt(i)==')'){
                count--;
                if(count<0) return false;
            }
        }
        return count==0;
    }
}