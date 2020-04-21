
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        
        List<String> result = new ArrayList<>();
        
        if(s == null)
            return result;
   
        /* Level wise exploration of each sub-String */
        Queue<String> queue = new LinkedList<>();
        
        /* sometimes it could happend when we generate same substring which was processed previously 
            like "()())()   ==> if we remove 4th / 5th we get the same subString ()()()"*/
        Set<String> visited = new HashSet<>();
        
        /* to track should we explore more in the upcoming levels or not */
        boolean flag = false;
        
        queue.offer(s);
        visited.add(s);
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i=0; i<size; i++)
            {
                /* for each subString we would need to check if its valid, if its already present in the set*/
                String current = queue.poll();
                if(!isValid(current))
                {
                    for(int j=0; j<current.length(); j++)
                    {
                        String newStr = current.substring(0, j) + current.substring(j+1, current.length());
                        if(!visited.contains(newStr))
                        {
                            queue.offer(newStr);
                            visited.add(newStr);
                        }
                    }
                }else
                {
                    result.add(current);
                    flag = true;
                }
            }
            
            /* If we get a valid string in earlier stages we dont need to explore more since we have been asked to remove                      minimum char to make it valid and return all possible solutions */
            if(flag)
                break;
        }
        
        return result;
    }
    
    /* Function to check id string is valid */
    private boolean isValid(String str)
    {
        int count = 0;
        
        for(int i=0; i<str.length(); i++)
        {
            if(count < 0)
                return false;
            
            if(str.charAt(i) == '(')
                count ++;
            else if(str.charAt(i) == ')')
                count --;
        }
        
        return count == 0;
    }
}
