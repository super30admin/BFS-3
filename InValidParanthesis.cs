using System;
using System.Collections.Generic;
using System.Text;

namespace DFS_And_BFS
{
    public class InValidParanthesis
    {
        /*
         * T.C: O(2 to the power N) 
         * S.C: O(N) since we are saving all the combination in the queue
         */
        public IList<string> RemoveInvalidParentheses(string s)
        {
            if (s == null || s.Length == 0) return null;

            List<string> result = new List<string>();
            int max = 0;
            HashSet<string> set = new HashSet<string>();
            //BFS
            Queue<string> queue = new Queue<string>();
            set.Add(s);
            queue.Enqueue(s);
            bool flag = false;

            while (queue.Count != 0 && flag == false)
            {

                string curr = queue.Dequeue();
                if (isValid(curr))
                {
                    set.Add(curr);
                    result.Add(curr);
                    flag = true;
                }
                else
                {
                    for (int j = 0; j < curr.Length; j++)
                    {
                        if (Char.IsLetter(curr[j])) continue;

                        string str = curr.Substring(0, j) + curr.Substring(j + 1, curr.Length - 1);

                        if (!set.Contains(str))
                        {
                            set.Add(str);
                            queue.Enqueue(str);
                        }
                    }
                }

            }


            return result;

        }

        private bool isValid(string s)
        {
            int count = 0;
            for (int i = 0; i < s.Length; i++)
            {
                if (s[i] == '(')
                {
                    count++;
                }
                else if (s[i] == ')')
                {
                    count--;
                }
            }

            return count == 0;
        }
    }
}
