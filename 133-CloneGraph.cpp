/* 
    Time Complexity                              :  O(N+M) where N is the number of vertices and M is the number of edges. Since undirected graph. 
                                                    max number of edges can be 
    Space Complexity                             :  O(N) stored either in queue in BFS or stack in DFS
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  


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
private:
    unordered_map<Node*,Node*> mp;
public:
    Node* cloneGraph(Node* node) {
        if(!node) return nullptr;
        // return bfs(node);
        return dfs(node);
    }
    
    Node* bfs(Node* node) {
        queue<Node*> q;
        q.push(node);
        while(!q.empty()) {
            int sz = q.size();
            for(int i=0;i<sz;i++) {
                Node *top = q.front();
                q.pop();
                Node *cloneTop = new Node(top->val);
                
                if(mp.find(top) != mp.end()) {
                    cloneTop = mp[top];
                } else {
                    mp[top] = cloneTop;
                }
                
                for(auto nbr : top->neighbors) {
                    Node *cloneNbr = new Node(nbr->val);
                    if(mp.find(nbr) != mp.end()) {
                        cloneNbr = mp[nbr];
                    } else {
                        mp[nbr] = cloneNbr;
                        q.push(nbr);
                    }
                    (cloneTop->neighbors).push_back(cloneNbr);
                }
            }
        }
        return mp[node];
    }
    
    
    Node* dfs(Node *node) {
        if(!node) return nullptr;
        
        if(mp.find(node) != mp.end()) {
            return mp[node];
        }
        
        Node *cloneNode = new Node(node->val);
        mp[node] = cloneNode;

        for(auto nbr : node->neighbors) {
            (cloneNode->neighbors).push_back(dfs(nbr));
        }
        
        return cloneNode;
    }
};