using System;
using System.Collections.Generic;
using System.Text;

namespace BFSnDFS
{
    //TC: O(V+E)
    //SC: O(V)
    class CloneGraphLC
    {
        //Definition for a Node
        public class Node
        {
            public int val;
            public List<Node> neighbors;
            public Node()
            {
                val = 0;
                neighbors = new List<Node>();
            }
            public Node(int _val)
            {
                val = _val;
                neighbors = new List<Node>();
            }
            public Node(int _val, List<Node> _neighbors)
            {
                val = _val;
                neighbors = _neighbors;
            }
        }

        Dictionary<Node, Node> map;
        public Node CloneGraph(Node node)
        {
            if (node == null) return null;
            map = new Dictionary<Node, Node>();
            Queue<Node> q = new Queue<Node>();
            Node copyNode = new Node(node.val);
            q.Enqueue(node);
            map.Add(node, copyNode);
            //BFS
            while (q.Count != 0)
            {
                Node curr = q.Dequeue();
                foreach (Node neighbor in curr.neighbors)
                {
                    if (!map.ContainsKey(neighbor))
                    {
                        Node copy = new Node(neighbor.val);
                        map.Add(neighbor, copy);
                        q.Enqueue(neighbor);
                    }
                    map[curr].neighbors.Add(map[neighbor]);
                }
            }
            return map[node];
        }

        public Node CloneGraphDFS(Node node)
        {
            if (node == null) return null;
            map = new Dictionary<Node, Node>();
            dfs(node);
            return map[node];
        }
        private void dfs(Node node)
        {
            //base
            if (map.ContainsKey(node))
            {
                return;
            }
            //logic
            Node copy = new Node(node.val);
            map.Add(node, copy);
            foreach (Node neighbor in node.neighbors)
            {
                dfs(neighbor);
                map[node].neighbors.Add(map[neighbor]);
            }
        }
    }
}
