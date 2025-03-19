class Solution {
    //Time Complexity:O(n!)
    //Space Complexity:O(1)
        public List<String> removeInvalidParentheses(String s) {
        if (s.length() == 0){
            return new ArrayList<String>();
        }
        List<String> res = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        boolean found = false;
        q.add (s);
  if (isValid(s)) {
        res.add(s);
        return res;
  }
        while (!q.isEmpty() && !found){
            int size =q.size();
            //iterate through the current patterns
            for (int i =0; i < size; i++){
                //create new String by removing char at i'th position
                String str = q.poll(); 
                for (int j =0;j < str.length();j++){
                          char c = str.charAt(j);
                            if (c != '(' && c != ')')
                    continue;
                   
                 String check = str.substring(0 ,j) + str.substring(j+1, str.length());
                if (visited.contains(check))
                continue;
                if (  isValid(check)){
                    found = true;
                    res.add (check);
                } else {
                    q.add(check);
                }
                visited.add(check);
            }
            }
        }
            return res;
    }
    private boolean isValid (String str){
        Queue<Character> q = new LinkedList<>();

        for (int i =0; i < str.length();i++){
            char c = str.charAt(i);
            if (c == '(')
            q.add(c);
            else if (c == ')'){
                if (q.isEmpty()){
                    return false;
                }
                q.poll();
            }
        }
        return q.isEmpty();
    }
}
