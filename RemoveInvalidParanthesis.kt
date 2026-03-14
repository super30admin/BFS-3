// In this problem we are using BFS to explore all possibilities withe the minimum number of removals first. The first BFS level that produces valid strings is guaranteed to be optimal so we return all valid srings found at that level and stop further processing. 
// Time complexity = O(2^n) exponential  
// Space complexity = O(2^n * n) 

class Solution {
    fun removeInvalidParentheses(s: String): List<String> {
         val results = mutableListOf<String>()
         val queue = ArrayDeque<String>()
         val visited = HashSet<String>()

         queue.addLast(s)
         visited.add(s)

         var foundAtThisLevel = false

         while(queue.isNotEmpty() && !foundAtThisLevel) {
            val levelSize = queue.size
            val levelValid = mutableListOf<String>()

            repeat(levelSize) {
                var curr = queue.removeFirst()

                if(isValid(curr)) {
                    levelValid.add(curr)
                    foundAtThisLevel = true
                }

                if(!foundAtThisLevel) {
                    for(i in curr.indices) {
                        val ch = curr[i]
                        if(ch != '(' && ch != ')') continue

                        val next = curr.substring(0, i) + curr.substring(i + 1)
                        if(visited.add(next)) {
                            queue.addLast(next)
                        }
                    }
                }
            }

            if(foundAtThisLevel) results.addAll(levelValid)
         }
         return results
    }

    private fun isValid(s: String): Boolean {
        var balance = 0
        for (ch in s) {
            when(ch) {
                '(' -> balance++
                ')' -> {
                    balance--
                    if(balance < 0) return false
                }
                else -> {}
            }
        }
        return balance == 0
    }
}