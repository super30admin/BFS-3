// Time Complexity: O(n2^n)
// Space Complexity: O(n)

import java.util.*;

class RemoveInvalidParanthesis {
    public List<String> removeInvalidParenthesesBFS(String s) {
        List<String> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        set.add(s);
        boolean flag = false;

        while (!q.isEmpty()) {
            String curr = q.poll();
            // System.out.println(curr);
            if (isValid(curr)) {
                result.add(curr);
                flag = true;
            }

            if (!flag) {
                // make the babies
                for (int j = 0; j < curr.length(); j++) {
                    char c = curr.charAt(j);
                    if (Character.isAlphabetic(c))
                        continue;
                    String baby = curr.substring(0, j) + curr.substring(j + 1);
                    if (!set.contains(baby)) {
                        q.add(baby);
                        set.add(baby);
                    }
                }
            }
        }

        return result;

    }


    private int max;
    private List<String> result;
    public List<String> removeInvalidParenthesesDFS(String s) {
        result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        dfs(s, set);
        return result;
    }

    private void dfs(String s, HashSet<String> set){
        if(s.length() < max) return;
        System.out.println(s);

        //logic
        if(isValid(s)){
            if(s.length() >  max){
                max = s.length();
                result = new ArrayList<>();
            }
            result.add(s);
        }
        // make the babies
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isAlphabetic(c)) continue;
            String baby = s.substring(0, i) + s.substring(i+1);
            if(!set.contains(baby)){
                set.add(baby);
                dfs(baby, set);
            }
        }
    }

    private boolean isValid(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isAlphabetic(ch)) {
                continue;
            }

            if (ch == '(') {
                count++;
            } else {

                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}