//
//  RemoveInvalidParentheses.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 3/4/26.
//

/*
 When we have valid number of characters in string then in the next level, odd number of characters will not give me valid strings surely.
 */
class RemoveInvalidParentheses {
    
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
        
        mutating func enqueue(_ element: T) {
            var newNode = LinkedListNode(value: element)
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
            if (front == nil) {
                return nil
            }
            let value = front?.value
            front = front?.next
            if (front == nil) {
                rear = nil
            }
            count -= 1
            return value
        }
        
        var size: Int {
            return count
        }
        
        var isEmpty: Bool {
            return count == 0
        }
    }
    

    init() {
        let strings = removeInvalidParentheses("()())()")
        print("strings \(strings)")
        
        let str2 = removeInvalidParenthesesUsingDFS("((((((((((((((((((aaaaa))")
        print("str2 \(str2)")
    }
    
    //MARK: BFS
    func removeInvalidParentheses(_ s: String) -> [String] {
        var queue = QueueUsingLinkedList<String>()
        let sArray = Array(s)
        // queue.enqueue(sArray[0])
        
        //first loop through the string and try removing all the character one at a time then check if any one is valid
        //we will get our first level
        
        //we will put the children of it during processing of BFS ut if we find valid data in the previous level then wouldn't be processing it
        queue.enqueue(s)
        
        var set = Set<String>()
        var maxLength = 0
        var validStrings = [String]()
        while(!queue.isEmpty) {
            //to track level
            let size = queue.size
            for i in 0..<size {
                let popped = queue.dequeue()
                guard let popped = popped else {
                    continue
                }
                if (isValid(popped)) {
                    if (maxLength == 0) {
                        maxLength = popped.count
                        validStrings.append(popped)
                    } else if (popped.count > maxLength) {
                        maxLength = popped.count
                        validStrings = []
                        validStrings.append(popped)
                    } else if (popped.count == maxLength) {
                        validStrings.append(popped)
                    }
                } else {
                    //if not valid string then next level might have valid strings
                    let poppedArr = Array(popped)
                    let count = poppedArr.count
                    for i in 0..<poppedArr.count {
                        var substring = ""
                        if (i == 0) {
                            substring = String(poppedArr[1..<poppedArr.count])
                        } else {
                            substring = String(poppedArr[0..<i]) + String(poppedArr[i+1..<count])
                        }
                        if (!set.contains(substring)) {
                            queue.enqueue(substring)
                            set.insert(substring)
                        }
                    }
                }
            }
        }
        return validStrings
    }
    
    func isValid(_ string: String) -> Bool {
        var count = 0
        for ch in string {
            if (ch == "(") {
                count += 1
            } else if (ch == ")") {
                count -= 1
                if (count == -1) {
                    return false
                }
            }
        }
        return count == 0
    }
    
    func usingFlagVariableBFS(_ s: String) -> [String] {
        /*
         BFS - n * 2^n (n - to create substrings)
         */
        var result = [String]()
        var mSet = Set<String>()
        var queue = QueueUsingLinkedList<String>()
        
        queue.enqueue(s)
        mSet.insert(s)
        var flag = false
        while (!queue.isEmpty && !flag) {
            //if we get answer at the first level, no need to process the next level
            let size = queue.size
            for i in 0..<size {
                let current = queue.dequeue()
                if let current = current {
                    if (isValid(current)) {
                        flag = true
                        result.append(current)
                    }
                    if (!flag) {
                        //we didn't find any valid strings yet
                        //have babies here
                        let currentArr = Array(current)
                        for j in 0..<currentArr.count {
                            // let currentArr = Array(current)
                            if (currentArr[j].isLetter) {
                                continue
                            }
                            let baby = String(currentArr[0..<j] + currentArr[(j+1)..<currentArr.count])
                            if (!mSet.contains(baby)) {
                                queue.enqueue(baby)
                                mSet.insert(baby)
                            }
                        }
                    }
                }
            }
        }
        return result
    }
    
    //MARK: DFS

    func removeInvalidParenthesesUsingDFS(_ s: String) -> [String]  {
        var mSet = Set<String>()
        var maxLength = 0
        var result = [String]()

        dfs(s, mSet: &mSet, maxLength: &maxLength, result: &result)
        return result
    }

    func dfs(_ s: String,  mSet: inout Set<String>, maxLength: inout Int, result: inout [String]) {
        //base
        if (s.count < maxLength) {
            return
        }
        if (isValid(s)) {
            if (s.count > maxLength) {
                maxLength = s.count
                result = []
            }
            result.append(s)
        }
        
        //logic
        let sArray = Array(s)
        for i in 0..<sArray.count {
            let ch = sArray[i]
            let baby = String(sArray[0..<i] + sArray[(i+1)..<sArray.count])
            if (!mSet.contains(baby)) {
                mSet.insert(baby)
                //recurse
                dfs(baby, mSet: &mSet, maxLength: &maxLength, result: &result)
            }
        }
    }
}
