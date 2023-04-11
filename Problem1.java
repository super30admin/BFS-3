import java.util.*;
/*
Remove Invalid Parenthesis
approach: find all possible permutations by removing one character, check if it is valid
time: O(n^n)
space: O(n^n)
 */
public class Problem1 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<>();
        boolean flag = false;
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        q.add(s);
        set.add(s);

        while (!q.isEmpty()) {
//            check if current string is valid, if yes then stop
            String curString = q.poll();
            if (isValid(curString)) {
                list.add(curString);
                flag = true;
            }
            if (!flag) {
                for (int i = 0; i < curString.length(); i++) {
                    if (Character.isLetter(curString.charAt(i))) continue;
                    String pattern = curString.substring(0, i) + curString.substring(i + 1);

                    if (!set.contains(pattern)) {
                        set.add(pattern);
                        q.add(pattern);
                    }

                }
            }
        }

        return list;
    }

    private boolean isValid(String s) {
//        if string length is odd then it's always invalid
        int count = 0;
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) continue;

            if (c==')') count--;
            else if (c=='(') count++;
            if (count<0) return false;
        }
        return count==0;
    }

    public static void main(String args[]) {
        Problem1 problem1 = new Problem1();
        problem1.removeInvalidParentheses("()())()");
    }
}
