// Time Complexity : O(n)
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this - Yes. Needed help in coding it out. Wasn't clear with the logic

class Solution {
public:
    Node* cloneGraph(Node* node) {
        
        if(node == NULL)
            return node;
        
        map<int, Node*> clones_map = {};
        set<Node*> visited_set;
        
        return helper_dfs(node, clones_map, visited_set);
        
    }
    
    Node* helper_dfs(Node* node, map<int, Node*>& clones, set<Node*>& visited_set)
    {
        visited_set.emplace(node);
        Node* curr = new Node(node->val);
        clones.emplace(node->val, curr);
        
        for(Node* neighbor: node->neighbors)
        {
            if(visited_set.find(neighbor) == visited_set.end())
            {
                helper_dfs(neighbor, clones, visited_set);
            }
            
            curr->neighbors.push_back(clones[neighbor->val]);
        }
        
        return curr;
    }
};