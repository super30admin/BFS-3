//Time : exponential
//Space : exponential

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() == 0 || s == null)
            return result;
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        q.add(s);
        set.add(s);
        boolean flag = false;
        while (!q.isEmpty() & !flag) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (isValid(curr)) {
                    flag = true;
                    result.add(curr);
                } else {
                    if (!flag) {
                        for (int j = 0; j < curr.length(); j++) {
                            if (Character.isLetter(curr.charAt(j)))
                                continue;
                            String child = curr.substring(0, j) + curr.substring(j + 1, curr.length());
                            if (!set.contains(child)) {
                                q.add(child);
                                set.add(child);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c))
                continue;
            if (c == '(')
                count++;
            else if (c == ')')
                count--;
            if (count < 0)
                return false;
        }
        return count == 0;
    }
}