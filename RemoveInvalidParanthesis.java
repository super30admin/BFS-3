// Approach : Using BFS - Level order traversal.
// Time : O(2^n) - two choices choose or remove .  # n^(n) # worst case
// Space : O(n) + O(n) // set length 
class Solution {

    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0)
            return result;
        HashSet<String> set = new HashSet<>(); // visited set to keep track before we add it to the queue.
        Queue<String> q = new LinkedList<>();
        q.add(s);
        set.add(s);
        boolean found = false;
        while (!q.isEmpty()) {
            String curr = q.poll(); // Process the first element of the queue
            if (isValid(curr)) {
                // At this level string is valid so we dont process its children because we will never find
                // As we go level down for the children from the valid (length is even) parent then length becomes valid
                result.add(curr);
                found = true;
            }
            if (!found) {
                // not valid - then form its childrens by removing one character at a time and
                // then add resultant substring to the q
                for (int i = 0; i < curr.length(); i++) { // "()())("
                    char c = curr.charAt(i);
                    if (Character.isAlphabetic(c))
                        continue;
                    String child = curr.substring(0, i) + curr.substring(i + 1);
                    if (!set.contains(child)) {
                        // not already visisted then add to set and then Process it by adding to queue
                        set.add(child);
                        q.add(child);
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
                // first character itself is ')' then count ==0
                if (count == 0)
                    return false;
                count--;
            }
        }

        return count == 0;
    }
}


// Approach : Using BFS - Level order traversal.
// Time : O(2^n) - two choices choose or remove .  # n^(n) # worst case
// Space : O(n) + O(n) // set length 
class Solution {

    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0)
            return result;
        HashSet<String> set = new HashSet<>(); // visited set to keep track before we add it to the queue.
        Queue<String> q = new LinkedList<>();
        q.add(s);
        set.add(s);
        boolean found = false;
        while (!q.isEmpty() && !found) {
            // with SIZE VARIABLE
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll(); // Process the first element of the queue
                if (isValid(curr)) {
                    // At this level string is valid so we dont process its children because we will
                    // never find
                    // As we go level down for the children from the valid (length is even) parent
                    // then length becomes valid
                    result.add(curr);
                    found = true;
                }
                if (!found) {
                    // not valid - then form its childrens by removing one character at a time and
                    // then add resultant substring to the q
                    for (int k= 0; k < curr.length(); k++) { // "()())("
                        char c = curr.charAt(k);
                        if (Character.isAlphabetic(c))
                            continue;
                        String child = curr.substring(0, k) + curr.substring(k + 1);
                        if (!set.contains(child)) {
                            // not already visisted then add to set and then Process it by adding to queue
                            set.add(child);
                            q.add(child);
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
                // first character itself is ')' then count ==0
                if (count == 0)
                    return false;
                count--;
            }
        }

        return count == 0;
    }
}