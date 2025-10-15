// This uses a BFS based approach to remove the invalid parentheses
// First we add the given string, then go level by level. Each level we iteratively remove each character and form substring
// We will basically create all the possible substrings by removing a single char at that level
// Next at each level, we will check if the string is valid using count method
// If its valid at any level, we use a flag to make sure not to get into next level and capture all the valid substrings at that level
// We will also ensure not to make duplicate string by using a set
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> response = new ArrayList();
        Queue<String> queue = new LinkedList();

        queue.add(s);

        Set<String> set = new HashSet();
        boolean flag = false;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0;i<size;i++) {

                String temp = queue.poll();
                if(isValid(temp)) {
                    flag=true;
                    response.add(temp);
                } else {
                    if(!flag) {
                        for(int j=0;j<temp.length();j++) {
                            if(Character.isAlphabetic(temp.charAt(j))) continue;
                            String curr = temp.substring(0,j)+temp.substring(j+1);
                            if(!set.contains(curr)){
                                queue.add(curr);
                                set.add(curr);
                            }
                        }
                    }
                }
            }
        }
        return response;
    }

    private boolean isValid(String curr) {
        int count = 0;

        for(int i=0;i<curr.length();i++) {
            if(Character.isAlphabetic(curr.charAt(i))) continue;
            if(curr.charAt(i)=='(') {
                count++;
            } else if(count==0 && curr.charAt(i)==')') {
                return false;
            } else {
                count--;
            }
        }
        return count==0;
    }
}

