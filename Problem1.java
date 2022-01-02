//DFS
// class Solution {
//     int min;
//     List<String> result;
//     HashSet<String> hs;
//     public List<String> removeInvalidParentheses(String s) {
//         result = new ArrayList<>();
//         result.add("");
//         min = Integer.MAX_VALUE;
//         helper(new Stack<Integer>(), s, 0, 0, new StringBuilder(""), false, '-');
//         return result;
//     }

//     public void helper(Stack<Integer> stack, String s, int index, int removals, StringBuilder currString, boolean prevRemoved, char c){
//         if(removals > min)
//             return;
//         if(index == s.length()){
//             if(stack.isEmpty() && removals < min){
//                 min = removals;
//                 result = new ArrayList<>();
//                 result.add(currString.toString());
//             }
//             else if(stack.isEmpty() && removals == min){
//                 result.add(currString.toString());
//             }
//             return;
//         }
//         if(prevRemoved && c == s.charAt(index)){
//             helper(stack, s, index+1, removals+1, currString, true, c);
//             return;
//         }
//         if(s.charAt(index) == ')'){
//             helper(stack, s, index+1, removals+1, currString, true, s.charAt(index));
//             if(stack.isEmpty())
//                 return;
//             stack.pop();
//             currString.append(s.charAt(index));
//             helper(stack, s, index+1, removals, currString, false, s.charAt(index));
//             currString.deleteCharAt(currString.length()-1);
//             stack.push(1);
//         }
//         else if(s.charAt(index) == '('){
//             helper(stack, s, index+1, removals+1, currString, true, s.charAt(index));
//             stack.push(1);
//             currString.append(s.charAt(index));
//             helper(stack, s, index+1, removals, currString, false, s.charAt(index));
//             currString.deleteCharAt(currString.length()-1);
//             stack.pop();
//         }
//         else{
//             currString.append(s.charAt(index));
//             helper(stack, s, index+1, removals, currString, false, s.charAt(index));
//             currString.deleteCharAt(currString.length()-1);
//         }
//     }
// }


//BFS
class Solution {
    public List<String> removeInvalidParentheses(String s1) {
        Queue<String> q = new LinkedList<>();
        q.add(s1);
        HashSet<String> hs = new HashSet<>();
        List<String> result = new ArrayList<>();
        int size;
        String s;
        String temp;
        boolean flag = false;
        while(!q.isEmpty() && !flag){
            size = q.size();

            for(int i=0;i<size;i++){
                s = q.poll();
                if(isValid(s)){
                    flag = true;
                    result.add(s);
                    continue;
                }
                for(int j=0;j<s.length();j++)
                    if(s.charAt(j) == '(' || s.charAt(j)==')')
                        if(j==0 || s.charAt(j) != s.charAt(j-1)){
                            temp = s.substring(0,j) + s.substring(j+1, s.length());
                            if(!hs.contains(temp))
                                q.add(temp);
                            hs.add(temp);
                        }

            }
        }
        return result;
    }

    public boolean isValid(String s){
        int counter = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ')')
                if(counter == 0)
                    return false;
                else
                    counter--;
            else if(s.charAt(i) == '(')
                counter++;
        }
        return counter==0;
    }
}