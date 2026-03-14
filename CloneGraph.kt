// In this problem, we traverse the graph using BFS and use a hashmap to store a mapping from each original node to its cloned node, which prevents infinite loops in cyclic graphs. 
// As we visit each node, we clone it once and connect its cloned neighbors using the map.
// Time complexity =O(V + E) V is number of nodes, E is number of edges. 
// Spcae complexity = O(V)



/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var neighbors: ArrayList<Node?> = ArrayList<Node?>()
 * }
 */

class Solution {
    private val map = HashMap<Node, Node>()
    fun cloneGraph(node: Node?): Node? {
        
        if(node == null) return null

        val startNode = node  
        val queue = ArrayDeque<Node>()
        queue.addLast(startNode)

        map[startNode] = Node(startNode.`val`)

        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()
            val currClone = map[curr]!!

            for (neighbor in curr.neighbors) {
                if (neighbor == null) continue

                if (!map.containsKey(neighbor)) {
                    map[neighbor] = Node(neighbor.`val`)
                    queue.addLast(neighbor)

                }

                currClone.neighbors.add(map[neighbor]!!)
            }
        }

        return map[node]

    }
}