package BFS-3;
// TC: O(n^n)
// SC: O(N)
public class Problem1 {
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();
        boolean flag = false;
        q.add(s);
        set.add(s);
        while(!q.isEmpty() && !flag){
            int qSize = q.size();
            for(int i=0;i<qSize;i++){
                String curr = q.poll();
                if(isValidString(curr)){
                    result.add(curr);
                    flag=true;
                }else{
                    for(int j=0;j<curr.length();j++){
                        if(Character.isAlphabetic(curr.charAt(j))) continue;
                        String newStr = curr.substring(0,j) + curr.substring(j+1);
                        if(!set.contains(newStr)){
                            q.add(newStr);
                            set.add(newStr);
                        }
                    }
                }
            }
            
        }
        return result;
    }

    private boolean isValidString(String s) {
        int count = 0;
        for (char c: s.toCharArray()) {
            if(Character.isAlphabetic(c)) continue;
            if (c == '(') {
                count++;
            } else {
                if (count == 0)
                    return false;
                count--;
            }
        }

        return count == 0;
    }
}
