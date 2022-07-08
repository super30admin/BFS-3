using System;
using System.Collections.Generic;

namespace Algorithms
{
    public class CloneGraph
    {
        //bfs
        /// Time Complexity : O(V+E) 
        // Space Complexity :O(V) 
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  No 
        public Node CloneGraph_BFS(Node node)
        {
            if (node == null) return node;
            Dictionary<Node, Node> map = new Dictionary<Node, Node>();
            Queue<Node> q = new Queue<Node>();
            Node newNode = new Node(node.val);
            map.Add(node, newNode);
            q.Enqueue(node);
            while (q.Count != 0)
            {
                Node curr = q.Dequeue();
                foreach (Node n in curr.neighbors)
                {
                    if (!map.ContainsKey(n))
                    {
                        map.Add(n, new Node(n.val));
                        q.Enqueue(n);
                    }
                    map.GetValueOrDefault(curr).neighbors.Add(map.GetValueOrDefault(n));
                }
            }
            return map.GetValueOrDefault(node);
        }


        Dictionary<Node, Node> map;
        public Node CloneGraph_DFS(Node node)
        {
            if (node == null) return node;
            map = new Dictionary<Node, Node>();
            Node newNode = new Node(node.val);
            map.Add(node, newNode);
            dfs(node);
            return map.GetValueOrDefault(node);
        }

        private void dfs(Node curr)
        {
            //base
            if (curr == null) return;
            //logic
            foreach (Node n in curr.neighbors)
            {
                if (!map.ContainsKey(n))
                {
                    map.Add(n, new Node(n.val));
                    dfs(n);
                }
                map.GetValueOrDefault(curr).neighbors.Add(map.GetValueOrDefault(n));
            }
        }
    }
}
