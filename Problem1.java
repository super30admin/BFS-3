
// time - O(2^n)
// space - O(n)



class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();

        if(s == null || s.length() == 0) return result;
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        q.add(s);
        set.add(s);
        boolean flag = false;

        while(!q.isEmpty() && !flag) { // if the queue is not empty and when the flag turns true stop

            int size = q.size();

            for(int i = 0; i < size; i++) {

                String curr = q.poll();
                if(isValid(curr)) { // if the current string is valid then add to the result

                    flag = true;
                    result.add(curr);

                } else {

                    for(int j = 0; j < curr.length(); j++) { //if the string is not valid traverse through the children to find valid string

                        String child = curr.substring(0,j) + curr.substring(j+1);
                        if(!set.contains(child)) {
                            q.add(child);
                            set.add(child);
                        }

                    }

                }


            }


        }
        return result;
    }

    private boolean isValid(String s) { // valid string function
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ')') {
                if(count == 0) return false;
                count--;
            }
            else if(c == '(') {
                count++;
            }

        }
        return count == 0;
    }


}