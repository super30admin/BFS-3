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
    unordered_map<Node*,Node*> um;
    Node *dfs (Node *node) {
        if (um.find(node)!=um.end()) return um[node]; 
        
        Node *clone = new Node(node->val);
        um[node]=clone;
        for (auto x:node->neighbors) {
           clone->neighbors.push_back(dfs(x));
        }
        return clone;
    } 
    Node* cloneGraph (Node* node) {
        if (node==NULL) return NULL; 
        return dfs(node);
    }
};