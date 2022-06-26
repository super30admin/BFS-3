// Time Complexity : O(V+E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1) We can use BFS or DFS to traverse the graph
// 2) We travrse and create new cloned nodes
//     a. Save it dictinary old node/new node
//     b. Reason is, when we go o ther nodes, we can find in dcitionary to see if they are aready created and use the new nodes

// Definition for a Node.
public class Node {
    public int val;
    public IList<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new List<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new List<Node>();
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


public class Solution {

Dictionary<Node, Node> dict;
public Node CloneGraph(Node node) {
    if(node == null)
        return null;
    
    dict = new Dictionary<Node, Node>();
    
    //BFS
    //return BFSCloneGraph(node);
    //DFS
    DFSCloneGraph(node);
    return dict[node];
}

private Node BFSCloneGraph(Node node)
{
    Queue<Node> queue = new Queue<Node>();
    Node copyNode = clone(node);
    queue.Enqueue(node);
    
    while(queue.Count > 0)
    {
        var curr = queue.Dequeue();
        IList<Node> neighbors = curr.neighbors;
        foreach(Node neighbor in neighbors)
        {
            //if neighbor node is not present in map
            //create clone node, add to map and queue
            if(!dict.ContainsKey(neighbor))
            {
                clone(neighbor);
                queue.Enqueue(neighbor);
            }
            //get current node, then clone nodes fo it
            //and add clone node neighbors to it
            dict[curr].neighbors.Add(dict[neighbor]);
        }
    }
    
    return copyNode;
}

private void DFSCloneGraph(Node node)
{
    //base
    if(dict.ContainsKey(node))
        return;
    
    //logic
    clone(node);
    var neighbors = node.neighbors;
    foreach(var neighbor in neighbors)
    {
        DFSCloneGraph(neighbor);
        dict[node].neighbors.Add(dict[neighbor]);
    }
}

private Node clone(Node node)
{
    Node copyNode = new Node(node.val);
    
    if(!dict.ContainsKey(node))
        dict.Add(node, copyNode);
    
    return copyNode;
}