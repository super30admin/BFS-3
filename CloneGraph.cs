using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Graph
{
    public class CloneGraph
    {
        /*
         * T.C: O(V+E) where v is vertices (people) & e is edges
         * S.C: O(V)
         */
        Dictionary<Node, Node> map;
        public Node CloneGraph1(Node node)
        {
            if (node == null) return null;

            Queue<Node> queue = new Queue<Node>();
            map = new Dictionary<Node, Node>();

            Node newNode = CloneNode(node);
            //Node curr = node;

            queue.Enqueue(node);

            while (queue.Count != 0)
            {
                Node curr = queue.Dequeue();
                List<Node> neighbors = curr.neighbors.ToList();

                foreach (Node neighbor in neighbors)
                {
                    if (!map.ContainsKey(neighbor))
                    {
                        CloneNode(neighbor);
                        queue.Enqueue(neighbor);
                    }

                    map[curr].neighbors.Add(map[neighbor]);
                }
            }

            //dfs(node);

            return map[node];

        }

        private Node CloneNode(Node node)
        {
            Node newNode = new Node(node.val);
            map.Add(node, newNode);
            return newNode;
        }


        //DFS approch

        private void dfs(Node node)
        {
            //base
            if (map.ContainsKey(node)) return;

            //logic
            CloneNode(node);
            List<Node> neighbors = node.neighbors.ToList();
            foreach (Node neighbor in neighbors)
            {
                dfs(neighbor);
                map[node].neighbors.Add(map[neighbor]);
            }

        }
    }
}
