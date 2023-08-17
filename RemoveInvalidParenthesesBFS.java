import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class RemoveInvalidParenthesesBFS {

        // BFS - Time O(n^n) and Space O(n) - level wise number of removals
        // BFS is more effective than DFS+DP sometimes

        public List<String> removeInvalidParentheses(String s) {

            // null case
            if(s == null)     return null;

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

            // bfs over multiple levels until flag is true
            while(!q.isEmpty() && !flag) {

                // size of a level
                int sizeQ = q.size();

                // iterate over a level
                for(int k = 0; k < sizeQ; k++) {

                    // current string in a level that is being processed
                    String currStrInLevel = q.poll();

                    // to see strings in a level
                    // System.out.println(currStrInLevel);

                    // if current string in a level is valid, add to result and make boolean true so that we do not got next level
                    if(currStrInLevel != null && isValid(currStrInLevel)) {

                        uniqueStrings.add(currStrInLevel);

                        flag = true;
                    }

                    // if flag is still false, add children (of next level) to queue
                    if(!flag && currStrInLevel != null) {

                        // remove each character in string at a time
                        for(int i = 0; i < currStrInLevel.length(); i++) {

                            // form children
                            String child = currStrInLevel.substring(0, i) + currStrInLevel.substring(i+1);

                            // uniqueness check
                            if(!set.contains(child)) {

                                q.add(child);
                                set.add(child);
                            }
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

            RemoveInvalidParenthesesBFS obj = new RemoveInvalidParenthesesBFS();

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