//  Time Complexity: O(n ^ n)
//  Space Complexity: O(n)
//  BFS Approach
class Solution {
    Set<String> set;
    List<String> result;

    public List<String> removeInvalidParentheses(String s) {

        this.set = new HashSet<>();
        this.result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        set.add(s);

        boolean flag = false;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i<size; i++){
                String curr = queue.poll();
                if(isValid(curr)){
                    flag = true;
                    result.add(curr);
                }else if(!flag){
                    for(int k=0; k<curr.length(); k++){
                        if(Character.isAlphabetic(curr.charAt(k))) continue;
                        String subStr = curr.substring(0, k) + curr.substring(k+1);
                        if(!set.contains(subStr)){
                            queue.add(subStr);
                            set.add(subStr);
                        }
                    }
                }
            }
        }
        return result;
    }

    private boolean isValid(String s){
        int count = 0;
        for(char c: s.toCharArray()){
            if(c == '(') count++;
            else if(c == ')'){
                count--;
                if(count < 0) return false;
            }
        }
        return count == 0;
    }
}


//  Time Complexity: O(n ^ n)
//  Space Complexity: O(n)
//  DFS Approach
class Solution {
    Set<String> set;
    List<String> result;
    int max;

    public List<String> removeInvalidParentheses(String s) {
            this.set = new HashSet<>();
            this.result = new ArrayList<>();
            this.max = 0;
            set.add(s);
            dfs(s);
            return result;
    }

    private void dfs(String s){
        if(s.length() < max) 
            return;

        if(isValid(s)){
            if(s.length() > max){
                result = new ArrayList<>();
                max = s.length();
            } 
            result.add(s);
        }else if(s.length() > max){
            for(int i=0; i<s.length(); i++){
                if(Character.isAlphabetic(s.charAt(i))) continue;
                String subStr = s.substring(0, i) + s.substring(i+1);
                if(!set.contains(subStr)){
                    set.add(subStr);
                    dfs(subStr);
                }
            }
        }
    }

    private boolean isValid(String s){
        int count = 0;
        for(char c: s.toCharArray()){
            if(c == '(') count++;
            else if(c == ')'){
                count--;
                if(count < 0) return false;
            }
        }
        return count == 0;
    }
}