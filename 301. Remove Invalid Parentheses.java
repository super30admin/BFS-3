// Time Complexity : O(n ^ n)
// Space Complexity : O(n)
// Method used : BFS

class Solution {

    List<String> result;
    HashSet<String> set;

    // This approach doesn't need a size variable to maintain at level because we are not doing any distinct check after each level

    public List<String> removeInvalidParentheses(String s) {

        if(s == null || s.length() == 0) return new ArrayList();

        result = new ArrayList();
        set = new HashSet();

        Queue<String> queue = new LinkedList();

        queue.add(s);
        set.add(s);

        boolean found = false;

        // We also need to remove the condition check here if found == false bcoz found might have become true but we might
        // still have valid strings in queue.
        while(!queue.isEmpty())
        {
            //int size = queue.size();

            // // Level order traversal
            // for(int i = 0; i < size; i++)
            // {
                String temp = queue.poll();

                if(isValid(temp))
                {
                    result.add(temp);
                    found = true;
                }

                // The above case might fail if the string is not valid but we also need to check here if found is not true yet
                // This is bcoz if found is already true then we don't need to add the childrens of the other strings at same level
                // Bcoz the next level will never have minimum removals
                // Even though if we didn't check this condition the program will work but it will unnecessarily add the children of
                // next level and then program anyway terminates bcoz found has already become true
                else if(found == false)
                {
                    for(int j = 0; j < temp.length(); j++)
                    {
                        char c = temp.charAt(j);

                        // We can ignore these characters
                        if(c >= 'a' && c <= 'z') continue;

                        // The first substring should skip the character at i and the next substring should start from i + 1
                        String concatenated = temp.substring(0, j) + temp.substring(j + 1);

                        // So if at the same level if we have 2 strings as () and () we add that to queue only once. That's the
                        // reason in the if case at the top we are directly adding string to the result because we are not 
                        // adding duplicates to the queue
                        if(!set.contains(concatenated))
                        {
                            set.add(concatenated);
                            queue.add(concatenated);
                        }
                    }
                }
            // }
        }

        return result;
    }

    private boolean isValid(String s)
    {
        int count = 0;

        for(int i = 0; i < s.length(); i++)
        {
            // We consider only ( and )
            char c = s.charAt(i);

            if(c == '(') count++;

            else if(c == ')')
            {
                --count;

                if(count < 0) return false;
            }
        }

        // Check if count == 0 only then return true
        return count == 0;
    }
}
