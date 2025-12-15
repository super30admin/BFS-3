
// Time Complexity : O(2^n)
// Space Complexity :O(n);
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

/*
Appraoch we are suing BFS to find out if a string is valid or not, to check this we have the isValid function that uses the count to check

We maintain a hashset to keep track of all the invalid string so we dont itterate over them again
we also that a flag variable, this is used to stop the search when we find a valid string, when this flag == True
element in the queue will be processed but no addtion strings will be added to the queue

*/

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        set.add(s);
        q.add(s);
        boolean flag = false;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (isValid(cur)) {
                    result.add(cur);
                    flag = true;
                }
                if (!flag) {
                    for (int j = 0; j < cur.length(); j++) {
                        char ch = cur.charAt(j);
                        if (Character.isAlphabetic(ch))
                            continue;
                        String baby = cur.substring(0, j) + cur.substring(j + 1);
                        if (!set.contains(baby)) {
                            q.add(baby);
                            set.add(baby);
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
            char ch = s.charAt(i);
            if (Character.isAlphabetic(ch))
                continue;
            if (ch == '(') {
                count++;
            } else {
                if (count == 0) {
                    return false;
                }
                count--;
            }
        }
        return count == 0;
    }
}