// https://leetcode.com/problems/remove-invalid-parentheses/description/

// BFS
// Time Complexity: O(n * 2^n)
// Space Complexity: O(2^n)

// DFS
// Time Complexity: O(2^n)
// Space Complexity: O(2^n)

class Solution {
    List<String> result = new ArrayList<>();
    HashSet<String> set = new HashSet<>();
    int max;
    public List<String> removeInvalidParentheses(String s) {
        this.result = new ArrayList<>();
        this.set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        set.add(s);
        q.add(s);
        boolean flag = false;
        while(!q.isEmpty() && !flag) {
            int size = q.size();
            for(int i=0; i < size; i++) {
                String curr = q.poll();
                // if this is true we do not go to next levels
                if(isValid(curr)) {
                    flag = true;
                    result.add(curr);
                }
                for(int j = 0; j < curr.length(); j++) {
                    char c = curr.charAt(j);
                    if(!Character.isAlphabetic(c)) {
                        String child = curr.substring(0, j) + curr.substring(j+1);
                        if(!set.contains(child)) {
                            set.add(child);
                            q.add(child);
                        }
                    }
                }
            }
        }

        // dfs(s);

        return result;
    }

    /*
    private void dfs(String s) {
        //base
        if(s.length() < max || set.contains(s)) return;
        //logic
        if(isValid(s)) {
            if(s.length() > max) {
                result = new ArrayList<>();
                max = s.length();
            }
            result.add(s);
        }

        set.add(s);
        for(int i =0; i<s.length();i++) {
            if(!Character.isAlphabetic(s.charAt(i))) {
                String child = s.substring(0, i) + s.substring(i+1);
                dfs(child);
            }
        }
    }
    */

    private boolean isValid(String s) {
        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isAlphabetic(c)) continue;
            if(c == ')') {
                if(count == 0) return false;
                count--;
            } else {
                count++;
            }
        }

        return count == 0;
    }
}

/* BFS

1.Initialization:
- We start by creating an empty list where we'll store the valid parentheses strings that we find.
- We also set up a queue, which is a data structure that helps us perform a breadth-first search (BFS) traversal.
- Additionally, we create a set to keep track of the strings we've already visited, so we don't revisit them unnecessarily.
- Initially, we add the input string to both the queue and the set to begin our search.

2. BFS Traversal:
- We start a loop that continues until either the queue becomes empty or we find a valid string.
- In each iteration of the loop, we take a string (`curr`) from the queue.
- We then check if this string is a valid parentheses string using a helper function.
- If the current string is valid, we add it to our list of valid strings and set a flag to indicate that we've found a valid string.
- Next, we examine each character of the current string. If a character is a parenthesis, we generate a new string by removing that parenthesis.
- If the newly generated string hasn't been visited before, we add it to the queue and mark it as visited in our set.

3. Checking Validity:
- We have a helper function that checks whether a given string is a valid parentheses string.
- This function essentially ensures that the parentheses in the string are balanced.
- It keeps track of the balance of parentheses using a counter. For each opening parenthesis encountered, it increments the counter, and for each closing parenthesis, it decrements the counter.
- If at any point the counter becomes negative, it means there are more closing parentheses than opening ones, making the string invalid.
- After checking the entire string, if the counter is zero, it indicates that all opening parentheses have been closed properly, making the string valid.

4. Return Results:
- Once our BFS traversal is complete, we return the list of valid strings that we've collected during the process.
