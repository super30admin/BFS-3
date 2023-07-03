
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


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

// Approach : BFS 
// Time Complexity : O(V+E) V= no. of nodes, E = no. of edges
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : yes

class Solution {
public:
    unordered_map<Node*,Node*>map;
    Node* cloneGraph(Node* node) {
        if(node == NULL) return node;
        queue<Node*>q;
        Node* cloneNode = clone(node);
        q.push(node);
        while(!q.empty())
        {
            auto curr = q.front();q.pop();
            for(auto ne: curr->neighbors)
            {
                if(map.count(ne)==0){
                    q.push(ne);
                }
                Node* newne = clone(ne);
                map[curr]->neighbors.push_back(newne);
            }
        }
        return cloneNode; 
        
    }
    Node* clone(Node* node)
    {
        if(map.count(node)==0) map.insert({node,new Node(node->val)});
        return map[node];
    }
};


// Approach : DFS 
// Time Complexity : O(V+E) V= no. of nodes, E = no. of edges
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : yes


class Solution {
public:
    unordered_map<Node*,Node*>map;
    void dfs(Node* node)
    {
        
        auto newnode = clone(node);
        for(auto ne: node->neighbors)
        {
            if(map.count(ne)==0)
            {
                dfs(ne);
            }
            newnode->neighbors.push_back(clone(ne));
        }
    }
    Node* cloneGraph(Node* node) {
        if(node == NULL) return node;
        dfs(node);
        return clone(node);
    }
    Node* clone(Node* node)
    {
        if(map.count(node)==0) map.insert({node,new Node(node->val)});
        return map[node];
    }
};