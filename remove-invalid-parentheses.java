// Time complexity: O(N^N)
// Space complexity: O(N)

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();
        q.add(s);
        set.add(s);
        boolean flag = false;

        while(!q.isEmpty() && !flag){
            int size = q.size();
            for(int j=0; j<size; j++){
                String cur = q.poll();
                if(isValid(cur)){
                    result.add(cur);
                    flag = true;
                } else {
                    for(int i=0; i<cur.length(); i++){
                        if(Character.isLetter(cur.charAt(i))) continue;
                        String newStr = cur.substring(0,i) + cur.substring(i+1);
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

    private boolean isValid(String str){
        int count = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '(')
                count++;
            else if(str.charAt(i) == ')'){
                if(count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }
}