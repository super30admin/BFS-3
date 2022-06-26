// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1) We will traverse the string
//     a. Remove the bracket at every index and check if the remain string is valid
//     b. If it is valid, add to result.
//     c. If it is not, then keep removing one more character in the strign from above
//     d. This is BFS or DFS, we are exploring all possible options.
// It could be possible, at every level, we can find same strign somehwere, so we can maintain hashset to check for duplication to explore its more children or not

HashSet<string> set;
IList<string> result;
int max = 0;
public IList<string> RemoveInvalidParentheses(string s) {
    result = new List<string>();
    if(String.IsNullOrEmpty(s))
        return  new List<string>();
    
    set = new HashSet<string>();
    
    //BFS
    //BFSRemoveInvalidParentheses(s);
    
    //DFS
    DFSRemoveInvalidParentheses(s);
    
    return result;
}

private void DFSRemoveInvalidParentheses(string s)
{
    //base
    if(s.Length < max)
        return;
    
    //logic
    if(isValid(s)){
        //if valid string, if lenght is greater than max, clear the result, add to result, 
        //because we need to find the valid string with minimum removal of parenthesis
        //if length equals to max, add to rersult
        if(s.Length > max)
        {
            max = s.Length;
            result = new List<string>();
            result.Add(s);
        }
        else if(max == s.Length)
            result.Add(s);
    }
    else
    {
        //get all possible childrens, after removing one parenthesis one by one
        int n = s.Length;
        for(int j = 0; j < n; j++)
        {
            if(Char.IsLetter(s[j]))
                continue;
            string child = s.Substring(0, j) + s.Substring(j+1);
            if(!set.Contains(child))
            {
                set.Add(child);
                DFSRemoveInvalidParentheses(child);
            }
        }
    }

}


private IList<string> BFSRemoveInvalidParentheses(string s)
{
    Queue<string> queue = new Queue<string>();
    bool found = false;
    
    queue.Enqueue(s);
    set.Add(s);
    while(queue.Count > 0)
    {
        //we need to explore all childrens at every level
        int size = queue.Count;
        //for(int i = 0; i < size; i++)
        //{
            string curr = queue.Dequeue();
            //if current string is valid, means all open paranthesis has closed paranthesis
            //add to set, result and make found variable to true
            if(isValid(curr))
            {                     
                set.Add(curr);
                result.Add(curr);
                found = true;                    
            }
            else
            {
                if(!found)
                {
                    int n = curr.Length;
                    for(int j = 0; j < n; j++)
                    {
                        if(Char.IsLetter(curr[j]))
                            continue;
                        string child = curr.Substring(0, j) + curr.Substring(j+1);
                        if(!set.Contains(child))
                        {
                            set.Add(child);
                            queue.Enqueue(child);
                        }
                    }
                }
            }
        //}
    }
    return result;
}

private bool isValid(string s)
{
    int count = 0;
    for(int i = 0; i < s.Length; i++)
    {
        char c = s[i];
        if(c == '(')
            count++;
        else if(c == ')')
        {
            count --;
            if(count < 0)
                return false;
        }
            
    }
    return count == 0;
}