/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Neighbors []*Node
 * }
 */
/*
    approach: BFS
    - Similar type of approach as Copy LL with random pointers ( approach that used extra space )
    time: o(v+e) where v is the number of verticies and e is number of edges.
    Space: o(v) - we only ever store verticies in our {$srcNode:$clonedCopy} map
*/
// func cloneGraph(node *Node) *Node {
//     if node == nil {return nil}
//     clone := &Node{Val: node.Val}
//     q := []*Node{node}
//     visited := map[*Node]*Node{node: clone}    
//     for len(q) != 0 {
//         dq := q[0]
//         q = q[1:]
//         cloneOfDq := visited[dq]
//         for _, n := range dq.Neighbors {
//             if visited[n] == nil {
//                 clone := &Node{Val: n.Val}
//                 visited[n] = clone
//                 q = append(q, n)
//             }
//             cloneOfDq.Neighbors = append(cloneOfDq.Neighbors, visited[n])
//         }
//     }    
//     return clone
// }



func cloneGraph(node *Node) *Node {
    visited := map[*Node]*Node{}
    var dfs func(n *Node) *Node
    dfs = func(n *Node) *Node {
        // base
        if n == nil {return nil}
        if _, ok := visited[n]; ok {return nil}
        
        // logic
        copyOfN := &Node{Val: n.Val}
        visited[n] = copyOfN
        for _, ne := range n.Neighbors {
            dfs(ne)
            copyOfN.Neighbors = append(copyOfN.Neighbors, visited[ne])
        }
        return copyOfN
    }
    clone := dfs(node)
    return clone
}
