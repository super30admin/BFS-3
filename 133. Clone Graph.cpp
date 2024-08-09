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

/*
Time: O(n)
Space: O(n)

Recursively build the graph DFS-Style (maintaining visited array)
*/

class Solution {
public:
    unordered_map<int, Node*> m;
    unordered_map<int,bool> vis;
    
    Node* cloneGraph(Node* node) {
        if(node == nullptr)  return nullptr;  

        int val = node->val;
        if(vis[val])  return m[val];
        
        vis[val] = 1;

        m[val] = new Node(val);

        for(Node* adj: node->neighbors){
            Node* cloned_adj = cloneGraph(adj);
            m[val]->neighbors.push_back(cloned_adj);
        }

        return m[val];
    }
};