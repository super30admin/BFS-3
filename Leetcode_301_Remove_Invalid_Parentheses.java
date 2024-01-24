/*
BFS Approach
TC: O(n^n)
SC: O(n) - queue + set

DFS approach: 
TC: O(n^n)
sc: O(n)
*/
//DFS APPROACH
class Solution {
    int max;
    Set<String> visited;
    List<String> result;
    public List<String> removeInvalidParentheses(String s) {
        
        this.result = new ArrayList<>();
        int n = s.length();
        
        //base case
        if(n <1)  return result;
        this.max =-1;
        //Visited set
        
        this.visited  = new HashSet<>();
        dfs(s);
      
        return result;
    }
    private void dfs(String s)
    {
        //base case
        if(visited.contains(s)) return; //if set has it, return
        if(s.length() < max) return; //if length is less, return
        
        if(isValid(s))
        {
            if(s.length() > max) //if length is more, reset list, and update max
            {
                result = new ArrayList<>();
                max = s.length();
            }
            result.add(s); //here it's equal
        }
        
        
        //logic
        visited.add(s);
        
        //generate the baby
        for(int i=0; i<s.length();i++)
        {
            char c = s.charAt(i);
            if(Character.isAlphabetic(c)) continue;
            
            String baby = s.substring(0,i)+ s.substring(i+1);
            if(!visited.contains(baby))
            {
               dfs(baby);
            }
        }
       
    }
    
    private boolean isValid(String s)
    {
        int count =0;
        for(int i=0; i<s.length(); i++)
        {
            if(Character.isAlphabetic(s.charAt(i))) continue;
            if(s.charAt(i) == '(')
            {
             count++;   
            }
            else
            {
                if(count == 0) return false;
                count--;
            }
        }
        return count==0;
    }
}

//BFS APPROACH
  class Solution {
    public List<String> removeInvalidParentheses(String s) {
        
        List<String> result = new ArrayList<>();
        int n = s.length();
        
        //base case
        if(n <1)  return result;
        
        //Visited set
        Set<String> visited  = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        
        q.add(s);
        visited.add(s);
        boolean flag = false;
        while(!q.isEmpty())
        {
            int size = q.size();
            
            //exploring strings the level by level
            //if we find the valid combination on level, we don't ahve to process level+1 (next level)
            for(int i=0; i<size; i++)
            {
                String curr = q.poll();
                //System.out.println("Curr: "+curr);
                //check if the string is not valid and we didn't find valid combination yet.
                if(isValid(curr))
                {
                    //we found the valid string
                    result.add(curr);
                    flag = true;
                }
                
                else 
                { 
                    if(!flag)
                    {
                        //generate the substring
                        for(int k=0; k<curr.length(); k++)
                        {
                            //if character, do nothing continue
                            if(Character.isAlphabetic(curr.charAt(k))) continue;

                            String baby = curr.substring(0,k)+ curr.substring(k+1);
                            if(!visited.contains(baby)) //set doesn't have this, so explore
                            {
                                visited.add(baby);
                                q.add(baby);
                                //System.out.print("  ,Baby: "+baby);
                            }
                        }
                    }
                }
                
            }
        }
        return result;
    }
    private boolean isValid(String s)
    {
        int count =0;
        for(int i=0; i<s.length(); i++)
        {
            if(Character.isAlphabetic(s.charAt(i))) continue;
            if(s.charAt(i) == '(')
            {
             count++;   
            }
            else
            {
                if(count == 0) return false;
                count--;
            }
        }
        return count==0;
    }
}
