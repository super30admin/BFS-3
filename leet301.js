TC: O(n^2)
SC: O(n)
/**
 * Check weather the given s is valid
 *
 * @param {string} s
 * @return {boolean}
 */
const checkValid =  (s) => {
 
  const stack = [];
  
  let isValid = true;
  
  for(let i = 0; i < s.length; i += 1) {
    const char = s[i];
    if(char === '(') {
      stack.push('(');
    } else if(char === ')' && stack.length === 0) {
      isValid = false;
      break;
    } else if(char === ')') {
      stack.pop();
    }
  }
  return  isValid && stack.length === 0;
}

/**
 * @param {string} s
 * @return {string[]}
 */
const removeInvalidParentheses = (s) => {
  const bfsQueue = new Queue();
  bfsQueue.enqueue({ str: s, lastRemoved: -1 });
  
  
  let minRemoved = Infinity;
  const correctedSet = new Set();
  
  
  const addedSet = new Set();
  
 
  while(!bfsQueue.isEmpty()) {
    const { str, lastRemoved } = bfsQueue.dequeue();
    
  
    if(s.length - str.length > minRemoved) {
      break;
    }
    
    
    const isValid = checkValid(str);
    if(isValid) {
      minRemoved = s.length - str.length;
      correctedSet.add(str);
    } else {
      for(let i = lastRemoved; i < str.length; i += 1) {
        if(str[i] === '(' || str[i] === ')') {
          const updated = str.slice(0, i) + str.slice(i+1);
          if(!addedSet.has(updated)) {
            addedSet.add(updated);
            bfsQueue.enqueue({ lastRemoved: i, str: updated });
          }
        }
      }
    }
  }
   return [...correctedSet];
};

