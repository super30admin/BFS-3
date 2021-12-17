// Time Complexity : 0(n)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

    var hashmap = [Node:Node]()
    func cloneGraph(_ node: Node?) -> Node? {
        if node == nil {
            return nil
        }
        return dfs(node) 
    }
    func dfs(_ node:Node?) -> Node? {
        guard let node = node else { return nil}
        var newNode : Node? = nil
        if let nnode = hashmap[node] {
                newNode =  nnode
                return newNode
            } else {
                newNode =  Node(node.val) 
                hashmap[node] = newNode
            }
        for oldNode in node.neighbors {
            newNode?.neighbors.append(dfs(oldNode))
        }
        return newNode
    }