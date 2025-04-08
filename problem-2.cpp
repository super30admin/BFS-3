// https://leetcode.com/problems/clone-graph/description/

// Time Complexity: O(n)
// Space Complexity: O(n)


class Solution {
    public:
        Node* cloneGraph(Node* node) {
            if(node == NULL) return node;
            unordered_map<Node*, Node*> mp;
            queue<Node*> q;
            q.push(node);
            mp[node] = new Node(node->val);
            while(!q.empty()){
                Node* curr = q.front(); q.pop();
                for(auto neigh : curr->neighbors){
                    if(mp.find(neigh) == mp.end()){
                        mp[neigh] = new Node(neigh->val);
                        q.push(neigh);
                    }
                    mp[curr]->neighbors.push_back(mp[neigh]);
                }
            }
            return mp[node];
    
        }
    };

