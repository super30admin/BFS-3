/*
The time complexity is O(n*2^n) and the space complexity is O(2^n) where n is the lenght of the string.

Here the intuition is to see if the polled element is valid or not. If not valid check for validity of its children. If we find
at least one we will be stop looking for children and return a list of valid elements present in the queue.

Yes, the solution passed all the test cases in leetcode.
 */
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(s); set.add(s);

        List<String> list = new LinkedList<>();
        boolean validFound = false;

        while(q.size()>0){

            String curr = q.poll();

            //Check if valid.
            if(isValid(curr)){
                validFound = true;
                list.add(curr);
            }
            else if(!validFound){

                //Add its children to the queue.
                for(int i=0;i<curr.length();i++){
                    if(curr.charAt(i)>=97 && curr.charAt(i)<=122){
                        continue;
                    }
                    String temp = curr.substring(0,i)+curr.substring(i+1);
                    if(!set.contains(temp)){
                        set.add(temp);
                        q.offer(temp);
                    }
                }
            }
        }

        return list;
    }

    public boolean isValid(String str){
        int count = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                count++;
            }
            else if(str.charAt(i)==')'){
                count--;
                if(count<0){
                    return false;
                }
            }
        }

        return count==0;
    }
}