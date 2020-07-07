// Time Complexity : O(V+E) - vertices and edges
// Space Complexity : O(V) map and queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. Maintain and map of original node and its clone like in Copy List with Random Ptr and a queue for BFS
// 2. Place given node in queue, and go thru its neighbors and create them and add to map,queue, and list neighbors
// 3. Continue till q is not empty, always check if clone is present in map before creating it 

/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;    
    }
};
*/

class Solution {
public:
    Node* cloneGraph(Node* node) {
        if(node == nullptr)
            return node;
        queue<Node*> q;
        map<Node*,Node*> nodes;
        q.push(node);
        // q will only contain nodes of original graph
        while(!q.empty()){
            auto curr = q.front(); q.pop();
            Node* clone = nullptr;
            // if clone not created already
            if(nodes.find(curr) == nodes.end()){
                clone = new Node(curr->val);
                nodes[curr] = clone;
            }
            else // clone already created
                clone = nodes[curr];
           
            for(auto neigh: curr->neighbors){
                // neighbor not present in map; create and add to map, queue n list of neighbors
                if(nodes.find(neigh) == nodes.end()){
                    Node* temp = new Node(neigh->val);
                    nodes[neigh] = temp;
                    q.push(neigh); // push orig node to queue 
                    clone->neighbors.emplace_back(temp);
                }
                else // neighbor already created, add to list of neighbors
                    clone->neighbors.emplace_back(nodes[neigh]);
            }
        }    
        return nodes[node];
    }
};