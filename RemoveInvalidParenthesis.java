// Time complexity: n^2 * 2^n -> 2 choices at every node, n -> time complexity for checking if it is a valid string or not,
// substring for each child.

// Space Complexity: not sure


class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if(s == null) return result;
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>(); // to prevent getting the same valid string after removing different characters
        boolean flag = false; // to check whether we have found a valid string at a level

        // never add duplicates in queue, hashset is used for that.
        q.add(s);
        set.add(s);

        while(!q.isEmpty()){
            String curr = q.poll();
            if(isValid(curr)){
                flag = true;
                result.add(curr);
            }
            if(!flag){   // put all children of current in queue
                for(int i = 0 ; i < curr.length() ; i++){
                    if(Character.isLetter(curr.charAt(i))) continue;
                    String child = curr.substring(0, i) + curr.substring(i+1);
                    if(!set.contains(child)){
                        q.add(child);
                        set.add(child);
                    }
                }

            }
        }
        return result;
    }



    private boolean isValid(String s){
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(c == '('){
                count += 1;
            }
            else if(c == ')'){
                if(count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }
}
