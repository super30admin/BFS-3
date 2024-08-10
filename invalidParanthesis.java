//time O(n^n)
//space O(n^n * L) L is the average lengh of string

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        q.add(s);
        boolean found = false;
        while(!q.isEmpty() && !found) {
            int size = q.size();
            for(int j = 0; j < size; j++) {
                String currStr = q.poll();
                if(isValid(currStr)) {
                    found = true;
                    result.add(currStr);
            
                }
                if(!found) {
                    for(int i = 0; i < currStr.length(); i++) {
                        char c = currStr.charAt(i);
                        if(!Character.isAlphabetic(c)) {
                            String childStr = currStr.substring(0, i) + currStr.substring(i+1);
                            if(!set.contains(childStr)) {
                                q.add(childStr); set.add(childStr);
                            } 
                        }      
                    }
                }
            }
        }
        return result;
    }
    
    private boolean isValid(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isAlphabetic(c)) continue;
            if(c == '(') {
                count++;
            } else if(c == ')') {
                if(count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }
}
