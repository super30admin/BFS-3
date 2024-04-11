class Solution {

    boolean checkifValid(String s) {
        int count = 0;
        
        for(int i =0; i<s.length();i++) {
            char ch = s.charAt(i);
            if(Character.isAlphabetic(ch)) {
            continue;
            }
            if(ch == '(') {
                count++;
            } else {
                if(count == 0) {
                    return false;
                }
                    count--;
            }
        }
            if(count != 0) {
                return false;
            }
            return true;
    }
    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();
        if(s.length() == 0) {
            return result;
        }
        queue.add(s);
        set.add(s);
        boolean flag = false;
        while(!queue.isEmpty() && !flag) {
            int size = queue.size();
            for(int index = 0; index< size;index++) {
                String current = queue.poll();
               if(checkifValid(current)) {
                flag = true;
                result.add(current);
            } 
                if(!flag) {
            for(int i =0; i<current.length();i++) {
                if(Character.isAlphabetic(current.charAt(i))) {
                    continue;
                }
                String newString = current.substring(0,i)+current.substring(i+1);
                if(!set.contains(newString)) {
                    set.add(newString);
                    queue.add(newString);
                }
            }

            }
            }
            }
            return result;
        }
        
    }
