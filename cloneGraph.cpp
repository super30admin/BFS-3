// Time Complexity :O(V+E) where V and E are vertices and edges
// Space Complexity : O(V)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    Node* cloneGraph(Node* node) {
        if(!node) return node;
        unordered_map<Node*,Node*> hMap;
        queue<Node*> q;
        Node *head = new Node(node->val,{});
        hMap[node] = head;
        q.push(node);
        while(!q.empty()){
            Node *curr = q.front();
            q.pop();
            for(auto c : curr->neighbors){
                if(hMap.find(c) == hMap.end()){
                    hMap[c] = new Node(c->val,{});
                    q.push(c);
                }
                hMap[curr]->neighbors.push_back(hMap[c]);
            }  
        }
        return head;
    }
};