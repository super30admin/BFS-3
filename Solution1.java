class Solution1 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if( isValid(s) ) {
            result.add(s);
            return result;
        }
        HashSet<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        set.add(s);
        boolean flag = false;
        while( !q.isEmpty() && !flag) {
            int size = q.size();
            for(int k = 0; k < size; k++) {
                String str = q.poll();
                if( isValid(str) ) {
                    flag = true;
                    result.add(str);
                    set.add(str);
                }
                if( !flag ) {
                    int l = str.length();
                    for(int i = 0; i < l; i++) {
                        String sub = str.substring(0,i) + str.substring(i+1);
                        if( !set.contains(sub) ) {
                            q.add(sub);
                            set.add(sub);
                        }
                    }
                }
            }
        }
        return result;
    }

    private boolean isValid(String s) {
        int count = 0;
        int l = s.length();
        for(int i = 0; i < l; i++) {
            char ch = s.charAt(i);
            if( ch == '(' ) {
                count++;
            } else if( ch == ')' ) {
                if( count == 0 ) {
                    return false;
                }
                count--;
            }
        }
        return (count==0);
    }
}
