class Solution {
    List<String> result;
    HashSet<String> set;
    int max;
    public List<String> removeInvalidParentheses(String s) {
        if(s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        // BFS Solution
        // Queue<String> q = new LinkedList<>();
        // HashSet<String> set = new HashSet<>();
        // List<String> result = new ArrayList<>();
        // boolean flag = false;
        // q.add(s);
        // set.add(s);
        // // while(!q.isEmpty() && !flag) {
        // while(!q.isEmpty()) {
        //     // int size = q.size();
        //     // for(int i = 0; i < size; i++) {
        //         String curr = q.poll();
        //         if(isValid(curr)) {
        //             flag = true;
        //             result.add(curr);
        //         } else if(flag == false) {
        //             for(int j = 0; j < curr.length(); j++) {
        //                 char c = curr.charAt(j);
        //                 if(c >= 'a' && c <= 'z') {
        //                     continue;
        //                 }
        //                 String child = curr.substring(0, j) + curr.substring(j + 1); // first one is till j - 1 and second one is till end if second param is not specified
        //                 if(!set.contains(child)) {
        //                     q.add(child);
        //                     set.add(child);
        //                 }
        //             }
        //         }
        //     // }
        // }
        // return result;

        // DFS Solution
        set = new HashSet<>();
        result = new ArrayList<>();
        dfs(s);
        return result;
    }

    private void dfs(String s) {
        // base
        if(s.length() < max) {
            return;
        }
        if(set.contains(s)) {
            return;
        }

        // logic
        set.add(s);
        if(isValid(s)) {
            if(max < s.length()) {
                max = s.length();
                result = new ArrayList<>();
                result.add(s);
            } else if(max == s.length()) {
                result.add(s);
            }
            return;
        }
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= 'a' && c <= 'z') {
                continue;
            }
            String child = s.substring(0, i) + s.substring(i + 1);
            dfs(child);
        }
    }

    private boolean isValid(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                count++;
            } else if(c == ')') {
                count--;
                if(count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }
}
