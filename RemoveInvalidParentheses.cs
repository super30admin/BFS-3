using System;
using System.Collections.Generic;

namespace Algorithms
{
    public class RemoveInvalidParentheses
    {
        /// Time Complexity : O(N^N) 
        // Space Complexity :O(N^N) 
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  No 
        public IList<string> RemoveInvalidParentheses_BFS(string s)
        {
            IList<string> result = new List<string>();
            if (s == null || s.Length == 0) return result;
            Queue<string> q = new Queue<string>();
            HashSet<string> set = new HashSet<string>();
            q.Enqueue(s);
            bool flag = false;
            while (q.Count != 0)
            {

                string curr = q.Dequeue();
                if (IsValid(curr))
                {
                    result.Add(curr);
                    flag = true;
                }
                if (!flag)
                {
                    for (int j = 0; j < curr.Length; j++)
                    {
                        char[] charArray = curr.ToCharArray();
                        if (Char.IsLetter(charArray[j])) continue;
                        //int length = endIndex - startIndex + 1;                    
                        string sub1 = curr.Substring(0, j);
                        string sub2 = curr.Substring(j + 1, curr.Length - 1 - (j + 1) + 1);
                        string child = sub1 + sub2;
                        if (!set.Contains(child))
                        {
                            set.Add(child);
                            q.Enqueue(child);
                        }
                    }
                }
            }
            return result;
        }

        private bool IsValid(string s)
        {
            int counter = 0;
            char[] charArray = s.ToCharArray();
            for (int i = 0; i < s.Length; i++)
            {
                if (Char.IsLetter(charArray[i])) continue;
                if (charArray[i] == '(') counter++;
                else counter--;
                if (counter < 0) return false;
            }
            return counter == 0;
        }



        HashSet<string> set;
        IList<string> result;
        int max;
        public IList<string> RemoveInvalidParentheses_DFS(string s)
        {
            result = new List<string>();
            if (s == null || s.Length == 0) return result;
            set = new HashSet<string>();
            dfs(s);
            return result;
        }

        private void dfs(string curr)
        {
            //base
            if (curr.Length < max || set.Contains(curr)) return;
            if (IsValid(curr))
            {
                if (curr.Length > max)
                {
                    max = curr.Length;
                    result = new List<string>();
                    result.Add(curr);
                }
                else
                {
                    result.Add(curr);
                }
                set.Add(curr);
            }
            //logic
            set.Add(curr);
            char[] charArray = curr.ToCharArray();
            for (int j = 0; j < curr.Length; j++)
            {
                if (Char.IsLetter(charArray[j])) continue;
                string sub1 = curr.Substring(0, j);
                string sub2 = curr.Substring(j + 1, curr.Length - 1 - (j + 1) + 1);
                string child = sub1 + sub2;

                dfs(child);
            }
        }


    }
}
