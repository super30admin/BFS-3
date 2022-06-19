import java.util.*;



public class InvalidParentheses {
    Set<String> set;
    List<String> result;
    public List<String> removeInvalidParentheses(String s) {
        if(s == null || s.length() == 0) return new ArrayList<>();

        set = new HashSet<>();
        result = new ArrayList<>();
        boolean found = false;

        // BFS Approach
        Queue<String> q = new LinkedList<>();
        q.add(s);


        while(!q.isEmpty() && !found) {
            int size = q.size();
            for(int i=0; i < size; i++){
                String curr = q.poll();
                if(isValid(curr)) {
                    result.add(curr);
                    found = true;
                }else {
                    if(!found){
                        for (int j=0; j < curr.length(); j++){
                            if(Character.isLetter(curr.charAt(j))) continue;
                            String child = curr.substring(0,j) + curr.substring(j + 1);
                            if(!set.contains(child)){
                                set.add(child);
                                q.add(child);
                            }
                        }
                    }
                }
            }

        }

        return result;
    }

    private boolean isValid(String curr) {
        int count = 0;
        for(int i=0; i < curr.length(); i++) {
            if(curr.charAt(i) == '(') {
                count++;
            }else if(curr.charAt(i) == ')'){
                count--;
                if(count < 0) return false;
            }
        }

        return count == 0;
    }
}
