class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        HashSet<String> resultSet = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        boolean flag = false;

        q.add(s);

        while(!q.isEmpty() && !flag){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String curr = q.poll();
                if(visited.contains(curr)) continue;
                if(isValid(curr)){
                    flag = true;
                    if(!resultSet.contains(curr)){
                        result.add(curr);
                        resultSet.add(curr);
                    }
                }else{
                    for(int j = 0; j < curr.length(); j++){
                        String subS = curr.substring(0, j) + curr.substring(j+1, curr.length());
                        if(!visited.contains(subS) && !flag){
                            q.add(subS);
                        }
                    }
                }
                visited.add(curr);
            }
        }
        return result;
    }
    private boolean isValid(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(count < 0) return false;
            if(curr == '(') count++;
            else if (curr == ')') count--;
        }
        return count == 0;
    }
}
