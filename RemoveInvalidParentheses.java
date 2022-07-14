/**
Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
public class RemoveInvalidParentheses
{
    public List<String> removeInvalidParentheses(String s)
    {
        List<String> output = new ArrayList<>();

        if(s == null || s.length() == 0)
            return output;

        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        boolean flag = false;

        queue.add(s);
        set.add(s);

        while(!queue.isEmpty() && !flag)
        {
            int levelSize = queue.size();

            for(int i = 0; i < levelSize; i++)
            {
                String current = queue.poll();

                if(isValid(current)) {
                    flag = true;
                    output.add(current);
                }
                else
                {
                    for(int j = 0; j < current.length(); j++)
                    {
                        if(Character.isLetter(current.charAt(j)))
                            continue;
                        String newString = current.substring(0,j) + current.substring(j+1);

                        if(!set.contains(newString))
                        {
                            queue.add(newString);
                            set.add(newString);
                        }

                    }
                }
            }
        }



        return output;

    }

    private boolean isValid(String input)
    {
        int count = 0;

        for(int i = 0; i < input.length(); i++)
        {
            char ch = input.charAt(i);

            if(ch == '(')
            {
                if(count < 0)
                    return false;
                count++;
            }
            else if(ch == ')')
                count--;
        }

        return count == 0;
    }
}
