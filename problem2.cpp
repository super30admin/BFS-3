/*
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
*/

#include<iostream>
#include<vector>
#include<queue>

using namespace std;

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

class Solution {
    
public:
    Node* cloneGraph(Node* node) {
        if(node == NULL) return NULL;
        if(node->neighbors.size() == 0){
            Node* clone = new Node(node->val);
            return clone;
        }
        unordered_map<Node*,Node*> umap{};
        queue<Node*> que{};
        que.push(node);
        while(!que.empty()){
            int sz = que.size();
            for(int i{};i<sz;++i){
                Node* curr = que.front();
                //cout<<curr->val<<" ";
                que.pop();
                if(umap.find(curr) == umap.end()){
                    Node* clone = new Node(curr->val);
                    umap[curr] = clone;
                }
                for(Node* child:curr->neighbors){
                    if(umap.find(child)==umap.end()){
                        Node* clone_child = new Node(child->val);
                        umap[child] = clone_child;
                        que.push(child);
                    }
                    umap[curr]->neighbors.push_back(umap[child]);
                }
                
            }
        }
        return umap[node];
    }
};