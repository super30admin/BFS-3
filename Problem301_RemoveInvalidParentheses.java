/**
 * Time Complexity - O(2^n)
 */

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();

        if(s==null){
            return result;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(s);
        visited.add(s);

        boolean found = false;

        while(!queue.isEmpty()){

            String str = queue.poll();

            if(isValid(str)){
                result.add(str);
                found = true;
            }

            // Once Found, check all string at that level
            if(found)
                continue;

            for(int i=0 ; i<str.length(); i++){

                if(str.charAt(i) != '(' && str.charAt(i) != ')'){
                    continue;
                }

                String temp = str.substring(0,i) + str.substring(i+1);

                if(!visited.contains(temp)){
                    queue.add(temp);
                    visited.add(temp);
                }
            }
        }
        return result;
    }

    private boolean isValid(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') count++;
            if (c == ')' && count-- == 0) return false;
        }

        return count == 0;
    }
}