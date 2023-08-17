import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Scanner;

public class RemoveInvalidParenthesesDFS {

        // DFS - Time O(n^n) Exponential and Space O(n)

        List<String> uniqueStrings;
        HashSet<String> visited;
        int maxLengthOfStr;

        public List<String> removeInvalidParentheses(String s) {

            // null case
            if(s == null)     return null;

            // maximum length of unique string obtained till now
            this.maxLengthOfStr = 0;

            // result
            this.uniqueStrings = new ArrayList<>();

            // if given string is itself valid
            if(isValid(s)) {

                uniqueStrings.add(s);
                return uniqueStrings;
            }

            // to avoid checking again on same string or uniqueness in result list
            this.visited = new HashSet<>();

            // dfs from string s
            dfs(s);

            // output
            return uniqueStrings;
        }

        public void dfs(String curr) {

            // base - no dfs on smaller strings than max length of valid unique string obtained till now
            if(curr.length() < maxLengthOfStr) {

                return;
            }

            //logic
            //action
            if(isValid(curr)) {

                // if current valid unique string is longer than existing longest one in result list, empty result list and add current longest valid unique string
                if(curr.length() > maxLengthOfStr) {

                    maxLengthOfStr = curr.length();

                    uniqueStrings = new ArrayList<>();
                }

                //  valid unique strings of same length as longest one exist in same level and get added to result list without any emptying
                uniqueStrings.add(curr);
            }

            //recursion
            for(int i = 0; i < curr.length(); i++) {

                // no action for alphabet letters
                char c = curr.charAt(i);
                if(Character.isAlphabetic(c)) {
                    continue;
                }

                // child string
                String child = curr.substring(0, i) + curr.substring(i + 1);

                // if unvisited child yet, add to visited set and do dfs
                if(!visited.contains(child)) {

                    visited.add(child);

                    dfs(child);
                }
            }
        }

        // method to check validity of string
        public boolean isValid(String s) {

            // net count
            int netCount = 0;

            for(int i = 0; i < s.length(); i++) {

                char c = s.charAt(i);

                // increment for open parenthesis
                if(c == '(') {

                    netCount++;
                }

                // decrement for close parenthesis
                if(c == ')') {

                    // if net count already at zero, we will go negative by decrementing and hence false
                    if(netCount == 0) {
                        return false;
                    }

                    netCount--;
                }
            }

            // true if net count is zero
            return netCount == 0;
        }

        public static void main(String[] args) {

            RemoveInvalidParenthesesDFS obj = new RemoveInvalidParenthesesDFS();

            Scanner scanner = new Scanner(System.in);

            System.out.println("String s: ");
            String s = scanner.nextLine();

            List<String> answer = obj.removeInvalidParentheses(s);

            System.out.println("List of unique strings that are valid with the minimum number of removals: ");
            for(String str: answer) {

                System.out.println(str);
            }
        }

}

/*
TIME COMPLEXITY = O(n^n)

dfs - exponential O(n^n)

SPACE COMPLEXITY = O(n)

HashSet of O(n) space
*/