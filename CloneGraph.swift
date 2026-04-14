//
//  CloneGraph.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 3/7/26.
//

/**
 * Definition for a Node.
 * public class Node {
 *     public var val: Int
 *     public var neighbors: [Node?]
 *     public init(_ val: Int) {
 *         self.val = val
 *         self.neighbors = []
 *     }
 * }
 */
class CloneGraph {
    
    class Node: Hashable, Equatable {
        static func == (lhs: CloneGraph.Node, rhs: CloneGraph.Node) -> Bool {
            return lhs === rhs
        }
        
        func hash(into hasher: inout Hasher) {
            hasher.combine(ObjectIdentifier(self))
        }
        
        var val: Int
        var neighbors: [Node?]
        init(_ val: Int) {
            self.val = val
            self.neighbors = []
        }
    }
    
    struct QueueUsingLinkedList<T> {
        class LinkedListNode<T> {
            var value: T
            var next: LinkedListNode<T>?
            init(value: T) {
                self.value = value
            }
        }

        private var front: LinkedListNode<T>?
        private var rear: LinkedListNode<T>?

        private var count: Int = 0

        mutating func enqueue(_ value: T) {
            let newNode = LinkedListNode(value: value)
            if (front == nil) {
                front = newNode
                rear = newNode
            } else {
                rear?.next = newNode
                rear = newNode
            }
            count += 1
        }

        mutating func dequeue() -> T? {
            guard let frontN = front else {
                return nil
            }

            let val = frontN.value

            front = frontN.next
            if (front == nil) {
                rear = nil
            }
            count -= 1
            return val
        }

        var isEmpty: Bool {
            return count == 0
        }

        var size: Int {
            return count
        }

        var peek: T? {
            return front?.value
        }
    }

    //MARK: BFS
    func cloneGraph(_ node: Node?) -> Node? {
        guard let node = node else {
            return node
        }
        var queue = QueueUsingLinkedList<Node>()

        var nodeMap = Dictionary<ObjectIdentifier, Node>()

        let copyNode = Node(node.val)
        let nodeRef = ObjectIdentifier(node)
        nodeMap[nodeRef] = copyNode
        queue.enqueue(node)

        while(!queue.isEmpty) {

            guard let curr = queue.dequeue() else {
                continue
            }
                //take it's children and create new ones, update int he map, update neightbors of the currNode with newly created instance of neightbors
                let newNode = nodeMap[ObjectIdentifier(curr)]!

                for oChild in curr.neighbors {
                    guard let oChild = oChild else {
                        continue
                    }
                    let oChildRef = ObjectIdentifier(oChild)
                    if (nodeMap[oChildRef] == nil) {
                        let nChild = Node(oChild.val)
                        nodeMap[oChildRef] = nChild
                        queue.enqueue(oChild)
                    }
                    newNode.neighbors.append(nodeMap[oChildRef])
                }
        }
        return copyNode
    }
    
    //MARK: DFS
    func cloneGraphUsingDFS(_ node: Node?) -> Node? {
        var nodeMap = Dictionary<ObjectIdentifier, Node>()
        return dfs(node, nodeMap: &nodeMap)
    }

    func dfs(_ node: Node?, nodeMap: inout Dictionary<ObjectIdentifier, Node>) -> Node? {
        guard let node = node else {
            return node
        }

        let copyNode = Node(node.val)
        let nodeRef = ObjectIdentifier(node)
        nodeMap[nodeRef] = copyNode

        for oChild in node.neighbors {
            guard let oChild = oChild else {
                continue
            }
            let oChildRef = ObjectIdentifier(oChild)
            if (nodeMap[oChildRef] == nil) {
                let nChild = Node(oChild.val)
                nodeMap[oChildRef] = nChild
                let _ = dfs(oChild, nodeMap: &nodeMap)
            }
            copyNode.neighbors.append(nodeMap[oChildRef])
        }
        return copyNode
    }

}
