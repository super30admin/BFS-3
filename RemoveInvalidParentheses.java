
// Time complexity - O(n*2^n)
// Space complexity - O(2^n)
// TLE

//Allocated queue to store children of a string. If children is valid then add into the result and skip adding further children into the queue. IF string is not valid then keep on adding children of string till valid string found.
class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        
        queue.offer(s);
        boolean found = false;
        System.out.println();
        
        // itertae over the queue untill it is empty
        while(!queue.isEmpty()){
            String ss = queue.poll();
            // if valid add into the result
            if(isValid(ss)){
                if(result.contains(ss))
                    continue;
                result.add(ss);
                found = true;
            }
            
            // if not valid string then add children into the queuue
            if(!found){
                for(int i=0; i< ss.length() ; i++){
                    if(Character.isLetter(ss.charAt(i)))
                        continue;
                    String temp = ss.substring(0,i)+ss.substring(i+1);
                    System.out.print(temp +"-");
                    queue.offer(temp);
                }
              
            }
        }
        return result;
    }
    
    // helper function to validate the string
    private boolean isValid(String s){
        int count =0;
        for(int i =0 ; i< s.length(); i++){
            if(s.charAt(i) == '(')
                count++;
            else if(s.charAt(i) == ')'){
                    if(count == 0)
                        return false;
                      count--;
                }
        }
        return count == 0;
    }
}


// Time complexity - O(n*2^n)
// Space complexity - O(2^n)
// Tested in leetcode

//Allocated queue to store children of a string. If children is valid then add into the result and skip adding further children into the queue. IF string is not valid then keep on adding children of string till valid string found.
// Allocated another hashset to add string which is already processed

class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        queue.offer(s);
        set.add(s);
        boolean found = false;
        System.out.println();
        
          // itertae over the queue untill it is empty
        while(!queue.isEmpty()){
            String ss = queue.poll();
            if(isValid(ss)){
                 // if valid add into the result
                if(result.contains(ss))
                    continue;
                result.add(ss);
                found = true;
            }
             // if not valid string then add children into the queuue
            if(!found){
                for(int i=0; i< ss.length() ; i++){
                    if(Character.isLetter(ss.charAt(i)))
                        continue;
                    String temp = ss.substring(0,i)+ss.substring(i+1);
                    if(!set.contains(temp)){
                        set.add(temp);
                        queue.offer(temp);
                    }
                    System.out.print(temp +"-");
                }
              
            }
        }
        return result;
    }
    
    // helper function to validate the string
    private boolean isValid(String s){
        int count =0;
        for(int i =0 ; i< s.length(); i++){
            if(s.charAt(i) == '(')
                count++;
            else if(s.charAt(i) == ')'){
                    if(count == 0)
                        return false;
                      count--;
                }
        }
        return count == 0;
    }
}