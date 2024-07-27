
/*
 * class Solution {
 * //Tc: O(n^3) Sc: O(2^N)
 * public List<String> removeInvalidParentheses(String s) {
 * 
 * List<String> result = new ArrayList<>();
 * if (s == null) return result;
 * 
 * Queue<String> queue = new LinkedList<>();
 * Set<String> visited = new HashSet<>();
 * boolean found = false;
 * 
 * queue.offer(s);
 * visited.add(s);
 * 
 * while (!queue.isEmpty()) {
 * int currentLevelSize = queue.size();
 * List<String> currentLevel = new ArrayList<>();
 * 
 * for (int i = 0; i < currentLevelSize; i++) {
 * String current = queue.poll();
 * if (isValid(current)) {
 * result.add(current);
 * found = true;
 * }
 * if (!found) {
 * for (int j = 0; j < current.length(); j++) {
 * if (current.charAt(j) == '(' || current.charAt(j) == ')') {
 * String next = current.substring(0, j) + current.substring(j + 1);
 * if (!visited.contains(next)) {
 * visited.add(next);
 * currentLevel.add(next);
 * }
 * }
 * }
 * }
 * }
 * 
 * if (found) break;
 * queue.addAll(currentLevel);
 * }
 * 
 * return result;
 * 
 * }
 * 
 * private boolean isValid(String s) {
 * int count = 0;
 * for (char c : s.toCharArray()) {
 * if (c == '(') {
 * count++;
 * } else if (c == ')') {
 * count--;
 * if (count < 0) return false;
 * }
 * }
 * return count == 0;
 * }
 * }
 * 
 */