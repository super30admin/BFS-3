//TC : O(n^n)
//SC: O(n^n)
//runs on leetcode

package coverage;

public class RemoveInvalidPareth {

  public List<String> removeInvalidParentheses(String s) {
    //in bfs we explore all the levels and we stop at the one that we get a solution at the level

    List<String> result = new ArrayList<>();

    // for bfs we use a queue and keep track of the level using size of the queue

    // we use HashSet so we can add the results and don't have to care about duplicates
    HashSet<String> set = new HashSet<>();

    Queue<String> q = new LinkedList<>();

    // once this boolean flag is set to true i will know i do not have to create elements for the next level
    boolean found = false;

    q.add(s);
    set.add(s);

    while (!q.isEmpty() && !found) {
      int size = q.size();

      for (int i = 0; i < size; i++) {
        // take out the first string and check if the current string is valid
        String curr = q.poll();

        if (isValid(curr)) {
          found = true;
          result.add(curr);
        } else {
          //if the flag is not true then process
          if (!found) {
            for (int k = 0; k < curr.length(); k++) {
              char c = curr.charAt(k);
              // if c is a alphabet
              if (Character.isAlphabetic(c)) continue;

              // take the substring
              // 0 to k = 0,1,2
              // k+1 onwards till the end, so that way we pluck every character from the string
              String child = curr.substring(0, k) + curr.substring(k + 1);

              //check if the set contains the child, if not then continue
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

  public boolean isValid(String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (c == '(') {
        count++;
      } else if (c == ')') {
        if (count == 0) return false; else count--;
      }
    }

    return count == 0;
  }
}
