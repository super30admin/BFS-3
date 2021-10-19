using System;
using System.Collections.Generic;
using System.Text;

namespace BFSnDFS
{
    class RemoveInvalidParenthesesLC
    {
        //TC: O(n^n) exponential
        //SC: O(n^n) exponential
        public List<string> RemoveInvalidParentheses(string s)
        {
            List<string> result = new List<string>();
            if (s == null || s.Length == 0) return result;
            Queue<string> q = new Queue<string>();
            HashSet<string> set = new HashSet<string>();
            q.Enqueue(s);
            set.Add(s);
            bool found = false;
            while (q.Count != 0 && !found)
            {
                int size = q.Count;
                for (int i = 0; i < size; i++)
                {
                    string curr = q.Dequeue();
                    if (IsValid(curr))
                    {
                        found = true;
                        result.Add(curr);
                    }
                    else if (!found)
                    {
                        for (int j = 0; j < curr.Length; j++)
                        {
                            if (char.IsLetter(curr[j])) continue;
                            string baby = curr.Substring(0, j) + curr.Substring(j + 1);
                            if (!set.Contains(baby))
                            {
                                q.Enqueue(baby);
                                set.Add(baby);
                            }
                        }
                    }
                }

            }
            return result;
        }

        private bool IsValid(string s)
        {
            if (s.Length % 2 != 0) return false;
            int count = 0;
            for (int i = 0; i < s.Length; i++)
            {
                char c = s[i];
                if (c == ')')
                {
                    if (count == 0) return false;
                    count--;
                }
                else if (c == '(')
                {
                    count++;
                }
            }
            return count == 0;
        }
    }
}
