/**
Time Complexity - O(2 ^ n * n) n is the length of input string s.
Space Complexity - O(2 ^ n)
 */
class Solution {
    public List<String> removeInvalidParentheses(String s) {
    
        List<String> result = new ArrayList<String>();

        if(s == null || s.length() == 0)
            return result;
        
        if(isValid(s)) {
            result.add(s);
            return result;
        }

        Queue<String> queue = new LinkedList<String>();
        Set<String> set = new HashSet<String>();
        queue.offer(s);
        set.add(s);
        Boolean minRemovalFound = false;

        while(!queue.isEmpty() && !minRemovalFound) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String child = queue.poll();
                if(isValid(child)) {
                    result.add(child);
                    minRemovalFound = true;
                } else if(!minRemovalFound) {
                    for(int j = 0; j < child.length(); j++) {
                        String newChild = child.substring(0, j) + child.substring(j + 1);
                        if(!set.contains(newChild)) {
                            set.add(newChild);
                            queue.offer(newChild);
                        } 
                    }
                }
            }
        }
        return result;
    }

    public boolean isValid(String s) {
        int count = 0;
        if(s == null || s.length() == 0)
            return true;
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(')
                count++;
            else if (s.charAt(i) == ')') {
                count--;
                if(count < 0)
                    return false;
            }
        }
        return count == 0;
    }
}
