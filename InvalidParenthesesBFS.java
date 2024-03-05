/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n^n)
    n - length of the string
* 
* Space Complexity: O(n^n)
* 
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InvalidParenthesesBFS {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();

        HashSet<String> hset = new HashSet<>();

        queue.add(s);

        hset.add(s);

        boolean flag = false;

        while (!queue.isEmpty()) {
            String temp = queue.poll();

            if (isValid(temp)) {
                flag = true;
                result.add(temp);
            }

            if (!flag) {
                for (int index = 0; index < temp.length(); index++) {
                    char charToRemove = temp.charAt(index);

                    if (charToRemove >= 'a' && charToRemove <= 'z') {
                        continue;
                    }

                    String trimmedString = temp.substring(0, index) + temp.substring(index + 1);

                    if (!hset.contains(trimmedString)) {
                        queue.add(trimmedString);
                        hset.add(trimmedString);
                    }
                }
            }
        }

        return result;
    }

    private boolean isValid(String s) {
        int counter = 0;

        for (int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);

            if (ch == '(') {
                counter++;
            } else if (ch == ')') {
                counter--;
            }

            if (counter < 0) {
                return false;
            }
        }

        return counter == 0;
    }
}