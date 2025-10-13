#include<iostream>
#include<bits/stdc++.h>
#include<vector>
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
/*
We start cloning fromt the given node using BFS
As we visit a node, we create its copy and remember it using a map
Then we connect each copied node to the copies of its neighbors
*/
class Solution{
public:
    unordered_map<Node*, Node*> map;
    Node* cloneGraph(Node* node){
        if(!node) return nullptr;

        queue<Node*> q;
        q.push(node);

        while(!q.empty()){
            Node* curr = q.front(); q.pop();
            Node* copyCurr = clone(curr);

            for(Node* ne : curr->neighbors){
                if(map.find(ne) == map.end()) q.push(ne);
                copyCurr->neighbors.push_back(clone(ne));
            }
        }
        return map[node];
    }

    Node* clone(Node* node){
        if(!node) return nullptr;
        if(map.count(node)) return map[node];
        map[node] = new Node(node->val);
        return map[node];
    }
};
