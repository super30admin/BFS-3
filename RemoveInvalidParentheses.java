// Time Complexity: O(2^n)
// Space Complexity: O(n)

class Solution {
    public List<String> removeInvalidParentheses(String s) {
    	List<String> result = new LinkedList<>();

    	if (s == null) return result;

    	boolean shouldExploreNextLevel = true;
    	Set<String> visited = new HashSet<>();
    	Queue<String> queue = new LinkedList<>();

    	queue.offer(s);
    	//visited.add(s);

    	while(!queue.isEmpty()) {
    		int levelCount = queue.size();

    		for(int i = 0; i < levelCount; i++) {
    			String current = queue.poll();

    			if(!visited.contains(current)) {
    				if(isValid(current)) {
    					shouldExploreNextLevel = false;
    					result.add(current);
    				}

    				visited.add(current);

    				if(shouldExploreNextLevel) {
    					for(int j = 0; j < current.length(); j++) {
    						if(Character.isLetter(current.charAt(j))) continue;
    						String child = current.substring(0, j) + current.substring(j + 1);

    						//if(!visited.contains(child)) {
    							queue.offer(child);
    							//visited.add(child);
    						//}
    					}
    				}
    			}
    		}

    		if(!shouldExploreNextLevel) break;
    	}

    	return result;
        
    }

    private boolean isValid(String s) {
    	int count = 0;
    	for(int i = 0; i < s.length(); i++) {
    		char ch = s.charAt(i);

    		if(ch == 'C') count++;
    		if(ch == ')') count--;

    		if(count < 0) return false;
    	}

    	return count == 0;
    }
}