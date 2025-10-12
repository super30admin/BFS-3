//Idea is to use BFS to traverse through the string to find the invalid parenthesis
//Time Complexity:O(2^n)
//Space Complexity:o(n*2^n)
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        HashSet<String> set = new HashSet<String>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        boolean flag = false;

        while(!q.isEmpty())
        {
                String str = q.poll();
                if(isValid(str))
                {
                    result.add(str);
                    flag = true;
                }
                else{
                    if(!flag){
                    for(int j=0;j<str.length();j++)
                    {
                        if(Character.isAlphabetic(str.charAt(j))) continue;
                        String newstr = str.substring(0,j)+str.substring(j+1);
                        if(!set.contains(newstr))
                        {
                            q.add(newstr);
                            set.add(newstr);
                        }
                    }
                    }
                }
        }
        return result;
    }

    private boolean isValid(String s){
        int count = 0;
        for(char c: s.toCharArray() ){
            if(Character.isAlphabetic(c)) continue;
            if(c=='(')
            {
                count++;
            }else
            {
                count--;
            }
            if(count<0) return false;
        }
        return count==0;
    }
}