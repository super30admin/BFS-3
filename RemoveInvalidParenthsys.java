// Time complexity -O(2^n)
//Space complexity - O(2^n)
// Solved on leetcode - yes
// faced any issue s- no

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> validList = new HashSet<>();
        Set<String> inValidList = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                String current = q.poll();
                boolean valid = isValid(current);
                if(valid) {
                    validList.add(current);
                } else {
                   // inValidList.add(current);
                    for(int j=0;j<current.length();j++) {
                        char c = s.charAt(j);
                        if (c != '(' && c != ')' && c != '{' && c != '}' && c != '[' && c != ']') continue;
                        String next = current.substring(0, j) + current.substring(j + 1);
                         if(!inValidList.contains(next)){
                            q.add(next); inValidList.add(next);}
                    }
                }
            }
        if (validList.size() > 0) return new ArrayList<>(validList);        
    }
    return new ArrayList<>(validList); 
    }

   public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    HashMap<Character, Character> pairs = new HashMap<>();
    pairs.put(')', '(');
    pairs.put('}', '{');
    pairs.put(']', '[');

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == '(' || c == '{' || c == '[') {
            stack.push(c);
        } else if (c == ')' || c == '}' || c == ']') {
            if (stack.isEmpty() || stack.peek() != pairs.get(c)) {
                return false;
            }
            stack.pop();
        }
    }
    return stack.isEmpty();
}
}
