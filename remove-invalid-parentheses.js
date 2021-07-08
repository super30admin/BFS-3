// Time Complexity : O(2^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {string} s
 * @return {string[]}
 */
var removeInvalidParentheses = function(s) {
    if (!s || !s.length) return [s];
    
    const isValid = (string) => {
        let count = 0;
        for (const char of string) {
            if (char == "(") count++;
            else if (char == ")") count--;
            if (count < 0) return false;
        }
        return count == 0;
    }

    if (isValid(s)) return [s];
    const result = new Set();
    const visited = new Set();
    const q = [s];
    let isDone = false;
    while (q.length > 0) {
        const levelCount = q.length;
        for (let i = 0; i < levelCount; i++) {
            let current = q.shift();
            if (!visited.has(current)) {
                if (isValid(current)) {
                    result.add(current);
                    isDone = true;
                }

                visited.add(current);

                if (!isDone) {
                    for (let j = 0; j < current.length; j++) {
                        if (current[j] == "(" || current[j] == ")") {
                            let temp = current.substring(0, j) + current.substring(j + 1);
                            q.push(temp);
                        }
                    }
                }
            }
        }
        if (isDone) break;
    }
    return Array.from(result);
};
