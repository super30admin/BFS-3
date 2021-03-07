/*
class Solution:

    def removeInvalidParentheses(self, s: str) -> List[str]:
        if s is None:
            return []
        
        result = []
        queue = collections.deque()
        queue.append(s)
        hashset = set()
        hashset.add(s)
        finished = False
        
        while len(queue)>0 and not finished:
            size = len(queue)
            for i in range(size):
                popped = queue.popleft()
                if self.isvalid(popped):
                    finished = True
                    result.append(popped)
                
                if not finished:
                    for j in range(len(popped)):
                        substring = popped[0:j] + popped[j+1:]
                        if substring not in hashset:
                            hashset.add(substring)
                            queue.append(substring)
        return result
    def isvalid(self, string):
        cnt = 0
        for k in range(len(string)):
            if string[k] == "(":
                cnt += 1
            elif string[k] == ")" and cnt == 0:
                return False
            
            elif string[k] == ")":
                cnt -= 1
        return cnt == 0


class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        if s is None:
            return []
        
        result = []
        queue = collections.deque()
        queue.append(s)
        hashset = set()
        hashset.add(s)
        finished = False
        
        while len(queue)>0:
            # size = len(queue)                 when we remove bfs size and travel levelwise we have to remove finished from while condition but this condition made sure alphabets are allowed in final result so when we remove this we have add if condition to skip alphabet
            # for i in range(size):
            popped = queue.popleft()
            if self.isvalid(popped):
                finished = True
                result.append(popped)

            if not finished:
                for j in range(len(popped)):
                    if popped[j].isalpha():  # added this condition because finished was removed from while condition
                        continue
                    substring = popped[0:j] + popped[j+1:]
                    
                    if substring not in hashset:
                        hashset.add(substring)
                        queue.append(substring)
        return result
    def isvalid(self, string):
        cnt = 0
        for k in range(len(string)):
            if string[k] == "(":
                cnt += 1
            elif string[k] == ")" and cnt == 0:
                return False
            
            elif string[k] == ")":
                cnt -= 1
        return cnt == 0
*/
/*
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null)
            return result;
        
        HashSet<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        set.add(s);
        
        boolean finished = false;
        
        while (!q.isEmpty()){
            // int size = q.size();
            // for (int i=0; i<size; i++){
                String popped = q.poll();
                if (isValid(popped)){
                    result.add(popped);
                    finished = true;
                }
                if (!finished){
                    for (int j=0; j<popped.length(); j++){
                        if (Character.isLetter(popped.charAt(j)))
                            continue;
                        String substr = popped.substring(0,j) + popped.substring(j+1);
                        if (!set.contains(substr)){
                            set.add(substr);
                            q.add(substr);
                        }
                    }
                }
            //}
        }
        return result;
    }
    public boolean isValid(String g){
        int cnt = 0;
        for (int k=0; k<g.length(); k++){
            char c = g.charAt(k);
            if (c == '(')
                cnt ++;
            else if (c == ')' && cnt == 0)
                return false;
            else if (c == ')')
                cnt -= 1;
        }
        return cnt == 0;
    }
}
*/

// time - O(2^n)
// space - O(n)
// logic - we remove one by one parenthesis to check whether it is valid 
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null)
            return result;
        
        HashSet<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        set.add(s);
        
        boolean finished = false;
        
        while (!q.isEmpty() && !finished){
            int size = q.size();
            for (int i=0; i<size; i++){
                String popped = q.poll();
                if (isValid(popped)){
                    result.add(popped);
                    finished = true;
                }
                if (!finished){
                    for (int j=0; j<popped.length(); j++){
                        String substr = popped.substring(0,j) + popped.substring(j+1);
                        if (!set.contains(substr)){
                            set.add(substr);
                            q.add(substr);
                        }
                    }
                }
            }
        }
        return result;
    }
    public boolean isValid(String g){
        int cnt = 0;
        for (int k=0; k<g.length(); k++){
            char c = g.charAt(k);
            if (c == '(')
                cnt ++;
            else if (c == ')' && cnt == 0)
                return false;
            else if (c == ')')
                cnt -= 1;
        }
        return cnt == 0;
    }
}