
    public List<String> removeInvalidParentheses(String s) {
        
      List<String> output = new ArrayList<>();
      
      if(s==null || s.length() == 0)
      {
        return output;
      }
      
      HashSet<String> hashSet = new HashSet<>();
      
      Queue<String> queue = new LinkedList<>();
      
      queue.add(s);
      hashSet.add(s);
      
      boolean found = false;
      
      while(!queue.isEmpty())
      {
        String front = queue.poll();
        
        if(isValid(front))
        {
          found = true;
          output.add(front);
        }
        
        if(!found)
        {
          for(int i=0; i<front.length();i++)
          {
            if(Character.isLetter(front.charAt(i)))
            {
              continue;
            }
            String sub = front.substring(0,i) + front.substring(i+1,front.length());
            
            if(!hashSet.contains(sub))
            {
              hashSet.add(sub);
              queue.add(sub);
            }
          }
        }
      }
        
        return output;
    }
  
  private boolean isValid(String s)
  {
    int count = 0;
    
    for(char ch :s.toCharArray())
    {
      if(ch=='(')
      {
        count+=1;
      }
      if(ch==')')
      {
          if(count==0)
          {
            return false;
          }
        count-=1;
      }
      
    }
    return count==0;
  }
}