// Time Complexity : O(V+E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
This is a graph traversal problem, we need to clone the graph
We can use BFS to traverse the graph and clone the nodes
We can use a hash map to keep track of the visited nodes and for mapping old
nodes to new nodes
*/

/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Solution {
public:
  Node *cloneGraph(Node *node) {
    if (!node)
      return nullptr;
    vector<vector<Node *>> adjListCopy;
    unordered_map<Node *, Node *> nodeMapping; // key = old, val = new
    queue<Node *> q;
    nodeMapping[node] = new Node(node->val);
    q.push(node);
    while (!q.empty()) {
      Node *node = q.front();
      q.pop();
      for (auto &neighbor : node->neighbors) {
        if (nodeMapping.find(neighbor) == nodeMapping.end()) {
          q.push(neighbor);
          nodeMapping[neighbor] = new Node(neighbor->val);
        }
        nodeMapping[node]->neighbors.push_back(nodeMapping[neighbor]);
      }
    }

    return nodeMapping[node];
  }
};