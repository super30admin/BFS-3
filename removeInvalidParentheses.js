/**
 Intuition:
 Use BFS to remove parentheses level-by-level, ensuring we find solutions with the minimum number of removals first.
 For each string, remove one parenthesis at every possible position and push the new strings into the queue if they haven't been seen before.
 Once a valid string is found at a level, stop generating deeper states and collect all valid strings at that level.
 T.C: O(n * 2^n)
 S.C: O(2^n)
 */
var removeInvalidParentheses = function (s) {
    const isValid = (s) => {
        let count = 0;
        for (let i = 0; i < s.length; i++) {
            let currChar = s[i];
            if (currChar === '(') count++;
            if (currChar === ')') count--;
            if (count < 0) return false;
        }
        return count === 0;
    };

    let queue = [s];
    let set = new Set();
    set.add(s);
    let result = [];
    let flag = false;
    let brackets = ['(', ')'];
    while (queue.length) {
        let curr = queue.shift();
        if (isValid(curr)) {
            result.push(curr);
            if (!flag) flag = true;
        } else if (!flag) {
            for (let i = 0; i < curr.length; i++) {
                if (!brackets.includes(curr[i])) continue;
                let baby = `${curr.substring(0, i)}${curr.substring(i + 1)}`;
                if (!set.has(baby)) {
                    set.add(baby);
                    queue.push(baby);
                }
            }
        }
    }

    return result;
};