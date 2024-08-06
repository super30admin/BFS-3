// Time Complexity : O(n ^ n)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();

        queue.add(s);
        set.add(s);
        boolean flag = false;

        while(!queue.isEmpty() && !flag) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String currStr = queue.poll();
                if(isValidString(currStr)) {
                    flag = true;
                    res.add(currStr);
                } else {
                    if(!flag) {
                        for(int j = 0; j < currStr.length(); j++) {
                            if (Character.isAlphabetic(currStr.charAt(j))) continue;
                            String str = currStr.substring(0,j)+currStr.substring(j+1);
                            if(!set.contains(str)) {
                                set.add(str);
                                queue.add(str);
                            }
                        }
                    }
                }
            }
            
        }
        return res;
    }
    private boolean isValidString(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                count++;
            } else {
                if (Character.isAlphabetic(s.charAt(i))) continue;
                if(count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }
}
