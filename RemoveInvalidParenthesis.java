// Time Complexity : O(2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : Yes
// Approach : As we have to find valid strings with minimum removals, we can follow BFS and stop adding to the queue once the result is
// found at one level. We start from adding the input string to the queue and check if it's valid. If it's valid, we add to the result list
// and continue valuating other strings in the queue at that level. If the string is not valid, we check the flag and then remove each character
// in the string and add to the queue by avoiding duplicates, with the help of a visited set. Once a valid string is found, we process all
// strings at that level and if valid, we add to the result.

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>(); //visited set to avoid duplicates
        boolean isFound = false; //flag to stop further BFS
        queue.add(s);
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (checkIfValid(curr)) {
                isFound = true;
                res.add(curr);
            } else {
                if (!isFound) { //when result is not found at current level
                    for (int i = 0; i < curr.length(); i++) {
                        if (Character.isAlphabetic(curr.charAt(i))) {
                            continue;
                        }
                        String newStr = curr.substring(0, i) + curr.substring(i + 1); //remove the ith character and continue
                        if (!visited.contains(newStr)) { //if string is not duplicate
                            queue.add(newStr);
                            visited.add(newStr);
                        }
                    }
                }
            }
        }
        return res;
    }

    private boolean checkIfValid(String str) { //function to check if the string has valid parenthesis
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isAlphabetic(str.charAt(i))) {
                continue;
            } else if (str.charAt(i) == '(') {
                count++;
            } else {
                if (count <= 0) {
                    return false;
                }
                count--;
            }
        }
        return count == 0;
    }
}