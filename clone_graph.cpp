// Time complexity-O(V+E)
// space complexity O(n);
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// push the assumed root
// iterate over its neighbors and check if it exists in the hash map
// if it does no need to create a copy
// if it doesnt create copy and add the originally processed element to queue

#include<algorithm>
#include<iostream>
#include<vector>
#include<stack>
using namespace std;

class Solution {
public:
    Node* cloneGraph(Node* node) {
        if (!node){return nullptr;}
        queue<Node*> q;
        Node* copyNode= new Node(node->val);
        unordered_map<Node*,Node*>hash_map;
        hash_map[node]=copyNode;
        q.push(node);
        
        while(!q.empty()){
            Node* curr = q.front();q.pop();
            
            for(Node * nei : curr->neighbors){
                if(hash_map.find(nei) == hash_map.end()){
                    hash_map[nei] = new Node(nei->val);
                    q.push(nei);
                }
                hash_map[curr]->neighbors.push_back(hash_map[nei]);
            }
        }
        return copyNode;
        
    }
};