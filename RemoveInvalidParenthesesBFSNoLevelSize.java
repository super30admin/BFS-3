import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class RemoveInvalidParenthesesBFSNoLevelSize {

        // BFS - Time O(n^n) and Space O(n) - relaxed level traversal without queue size variable

        // level traversal is not strictly done as there is no level queue size variable, next level children will not be valid solutions for sure. So, if we process them in bfs, there is no risk of them getting added to output list because those children are certainly invalid

        // because if valid strings are found at a level of even length strings (assume no alphabet letters for instance), next level will have odd length strings which can never be valid even if processed. Therefore, there is no risk of mixing of valid strings from different levels

        public List<String> removeInvalidParentheses(String s) {

            // null case
            if(s == null) {
                return null;
            }

            // result
            List<String> uniqueStrings = new ArrayList<>();

            // for bfs
            Queue<String> q = new LinkedList<>();
            q.add(s);

            // for uniqueness
            HashSet<String> set = new HashSet<>();
            set.add(s);

            // to decide if to go to next level by removal
            boolean flag = false;

            // bfs until flag is true
            while(!q.isEmpty()) {

                // no size variable and no strict level traversal

                // current string that is being processed
                String currStr = q.poll();

                // to see strings processed in no strict level traversal
                // System.out.println(currStr);

                // if current string is valid, add to result and make boolean true so that we do not go to next level
                if(isValid(currStr)) {

                    uniqueStrings.add(currStr);

                    flag = true;
                }

                // if flag is still false, add children (of next level) to queue
                if(!flag) {

                    // remove each character in string at a time
                    for(int i = 0; i < currStr.length(); i++) {

                        char c = currStr.charAt(i);

                        // no action on alphabets
                        if(Character.isAlphabetic(c)) {

                            continue;
                        }

                        // form children
                        String child = currStr.substring(0, i) + currStr.substring(i+1);

                        // uniqueness check
                        if(!set.contains(child)) {

                            q.add(child);
                            set.add(child);
                        }
                    }
                }

            }
            // output
            return uniqueStrings;
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

            RemoveInvalidParenthesesBFSNoLevelSize obj = new RemoveInvalidParenthesesBFSNoLevelSize();

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

bfs - exponential

SPACE COMPLEXITY = O(n)

HashSet and Queue of O(n) space
*/