// Time Complexity: O(2 ^ n)
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        if(s == null) {
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        q.offer(s);
        boolean flag = false;

        while(!q.isEmpty()) {
            String cur = q.poll();
            if(isValid(cur)) {
                if(!flag) {
                    flag = true;
                }
                list.add(cur);
            }
            if(!flag) {
                for(int i = 0; i < cur.length(); i++) {
                    if(Character.isLetter(cur.charAt(i))) {
                        continue;
                    }
                    String child = cur.substring(0, i) + cur.substring(i + 1);
                    if(!set.contains(child)) {
                        set.add(child);
                        q.offer(child);
                    }
                }
            }
        }
        return list;
    }

    private boolean isValid(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                count++;
            } else if(s.charAt(i) ==')') {
                if(count < 1) {
                    return false;
                }
                count--;
            }
        }
        return count == 0;
    }
}