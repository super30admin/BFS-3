// Time Complexity: O(2^n * n), where n is te length of the input string
// Space Complexity: O(2^n * n)
function removeInvalidParentheses(s: string): string[] {
	const result = [];
	if (!s || s.length === 0) return result;

	const set = new Set<string>();
	const q = [s];
	set.add(s);

	// flag to stop BFS once a valid string is found at the current level
	// and to ensures we only collect results with the minimum number of removals
	let flag = false;
	while (q.length > 0 && !flag) {
		const size = q.length;

		for (let i = 0; i < size; i++) {
			const curr = q.shift();

			// check if current string is valid
			if (isValid(curr)) {
				// push valid string to result and mark flag true to avoid deletion exploration at curent level
				result.push(curr);
				flag = true;
				continue;
			}

			// if we haven't found a valid string at current level
			if (!flag) {
				for (let j = 0; j < curr.length; j++) {
					// create a new strig by removing character at index j
					const baby = curr.substring(0, j) + curr.substring(j + 1);
					if (!set.has(baby)) {
						// if the new baby is not visisted, add it to the queue for processig
						q.push(baby);
						set.add(baby);
					}
				}
			}
		}
	}
	return result;

	function isValid(s: string) {
		let count = 0;

		for (let i = 0; i < s.length; i++) {
			const ch = s[i];
			if (isCharAlphabet(ch)) continue;
			if (ch == "(") count++;
			else {
				if (count == 0) return false;
				count--;
			}
		}

		return count === 0;
	}

	function isCharAlphabet(ch: string): boolean {
		if (ch.length !== 1) return false;
		// get ASCII for the ch
		const code = ch.charCodeAt(0);
		// check for uppercase letters (A=65 to Z=90)
		const isUppercase = code >= 65 && code <= 90;
		// check for lowercase letters (a=97 to z=122)
		const isLowercase = code >= 97 && code <= 122;

		return isUppercase || isLowercase;
	}
}
