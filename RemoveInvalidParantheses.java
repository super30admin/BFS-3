// Time Complexity: O(n * n!)
// Space Complexity: O(n!)

class RemoveInvalidParantheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        
        if(s == null || s.length() == 0)
            return result;

        int n = s.length();
        Set<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(s);
        set.add(s);
        boolean found = false;

        while(!q.isEmpty()){
            String curr = q.poll();
            if(isValid(curr)){
                found = true;
                result.add(curr);
            }

            if(!found){
                for(int j = 0; j < curr.length(); j++){
                    if(Character.isLetter(curr.charAt(j)))
                        continue;

                    String sub = curr.substring(0,j) + curr.substring(j+1, curr.length());
                    if(!set.contains(sub)){
                        set.add(sub);
                        q.offer(sub);
                    }
                }
            }
        }

        return result;
    }

    // Check if a string has valid parantheses or not
    private boolean isValid(String s){
        int n = s.length();
        int count = 0;
        for(char c : s.toCharArray()){
            if(c == '(')
                count++;
            else if(c == ')'){
                if(count == 0)
                    return false;
                else
                    count--;
            }
        }

        return count == 0;
    }
} 