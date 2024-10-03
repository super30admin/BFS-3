/*
**Time Complexity (TC):** O(V + E)

**Space Complexity (SC):** O(V)

Where:
- `V` is the number of vertices (nodes) in the graph.
- `E` is the number of edges in the graph.
*/

class Solution {
public:
    unordered_map<int, Node*> clonedNodesList;
    Node* cloneGraph(Node* node) {
        Node *cloneNode = NULL;
        if(node) {
            if(clonedNodesList.count(node->val)) {
                cloneNode = clonedNodesList[node->val];
            } else {
                cloneNode = new Node(node->val);
                clonedNodesList[node->val] = cloneNode;
                for(auto &nei : node->neighbors) {
                    cloneNode->neighbors.push_back(cloneGraph(nei));
                }
            }
        }
        return cloneNode;
    }
};