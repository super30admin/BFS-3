// Problem1 Remove Invalid Parentheses(https://leetcode.com/problems/remove-invalid-parentheses/)

// Time Complexity : O(2^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

var isValid = (str) => {
    let count = 0;
    for (let i = 0; i < str.length; i++) {
        if (str[i] === '(') {
            count++;
        } else if (str[i] === ')') {
            count--;
        }
        if (count < 0)
            return false;
    }
    if (count === 0)
        return true;

    return false;
}
/**
 * @param {string} s
 * @return {string[]}
 */
var removeInvalidParentheses = function (s) {
    if (s === null || s.length === 0)
        return [];

    // BFS
    let queue = [];
    let result = [];
    let visited = new Set();
    queue.push(s);
    // Once true, we will find the valid string with minimum removals
    let found = false;
    while (queue.length > 0) {
        let str = queue.shift();
        if (isValid(str)) {
            found = true;
            result.push(str);
        }
        // Add to queue only if not in set.
        if (found === false) {
            for (let j = 0; j < str.length; j++) {
                if (str[j] === '(' || str[j] === ')') {
                    let baby = str.slice(0, j) + str.slice(j + 1);
                    if (!visited.has(baby)) {
                        visited.add(baby);
                        queue.push(baby);
                    }
                }
            }
        }
    }
    return result;
};
