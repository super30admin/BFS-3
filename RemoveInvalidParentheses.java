// Time Complexity: Exponential
// Space Complexity: O
// BFS without level
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        
        if(s == null || s.length() == 0)
            return result;
        
        boolean found = false;
        
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        
        q.offer(s);
        visited.add(s);
        
        while(!q.isEmpty())
        {
            String curr = q.poll();
            if(isValid(curr))
            {
                found = true; // we need not generate substring as we will violate the condition
                // condition expect valid with min removals
                result.add(curr);
                
            }
            // do not generate babies for curr string as it will be smaller
            if (found) 
                continue;
                
            // iterate over each char and remove and check
            for(int j = 0 ; j < curr.length(); j++)
            {
                if(Character.isLetter(curr.charAt(j)))
                    continue;
                String sub = curr.substring(0,j) + curr.substring(j+1);

                // check visited
                if(!visited.contains(sub))
                {
                    visited.add(sub);
                    q.add(sub);
                }
            }
        }
            
       return result; 
    }
    
    
    private boolean isValid(String s)
    {
        int count = 0;
        for(char c : s.toCharArray())
        {
            if(c == '(')
                count++;
            else if(c == ')')
                count--;
            else // letters
                continue;
            
            if(count < 0)
                return false;
        }
        
        
        return count == 0;
    }
}

// BFS with level
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        
        if(s == null || s.length() == 0)
            return result;
        
        boolean found = false;
        
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        
        q.offer(s);
        visited.add(s);
        
        while(!q.isEmpty())
        {
            int size = q.size(); // continue processing all strings, same length that could be valid
            for(int i = 0 ; i < size; i ++)
            {
                String curr = q.poll();
                if(isValid(curr))
                {
                    found = true; // we need not generate substring as we will violate the condition
                    // condition expect valid with min removals
                    result.add(curr);
                    
                }
                // do not generate babies for curr string as it will be smaller
                if (found) 
                    continue;
                    
                // iterate over each char and remove and check
                for(int j = 0 ; j < curr.length(); j++)
                {
                    if(Character.isLetter(curr.charAt(j)))
                        continue;
                    String sub = curr.substring(0,j) + curr.substring(j+1);

                    // check visited
                    if(!visited.contains(sub))
                    {
                        visited.add(sub);
                        q.add(sub);
                    }
                }
            }
        }
            
       return result; 
    }
    
    
    private boolean isValid(String s)
    {
        int count = 0;
        for(char c : s.toCharArray())
        {
            if(c == '(')
                count++;
            else if(c == ')')
                count--;
            else // letters
                continue;
            
            if(count < 0)
                return false;
        }
        
        
        return count == 0;
    }
}
// DFS
public class RemoveInvalidParentheses {
    List<String> result;
    Set<String> visited;
    int maxLevel;
    public List<String> removeInvalidParentheses(String s) {
        result = new ArrayList<>();
        
        if(s == null || s.length() == 0)
            return result;
    
        
       visited = new HashSet<>();
        
        dfs(s);
       return result; 
    }
    
    public void dfs(String s)
    {
        // if already seen return
        if(visited.contains(s))
            return;
        
        // add to visited
        visited.add(s);
        if(isValid(s)) // only if valid parantheses
        {
            // we found a valid string for same string with less brackets
            if (maxLevel < s.length())
            {
                maxLevel = s.length();
                result = new ArrayList<>();
                result.add(s);
            }
            else if(s.length() == maxLevel)
            {
                result.add(s);
                return;
            }
        }
        for(int i = 0 ; i < s.length() ; i ++)
        {
            char c = s.charAt(i);
            
            if(Character.isLetter(c))
                continue;
            // remove one bracket and check
            String sub = s.substring(0, i) + s.substring(i+1);
            dfs(sub);
        }
    }
    
    
    private boolean isValid(String s)
    {
        int count = 0;
        for(char c : s.toCharArray())
        {
            if(c == '(')
                count++;
            else if(c == ')')
                count--;
            else // letters
                continue;
            
            if(count < 0)
                return false;
        }
        
        
        return count == 0;
    }
}
