// Time Complexity : O(n*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, compilation errors

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        set.add(s);
        boolean flag = false;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                String curr = q.poll();
                if(isValid(curr))
                {
                    //set.add(curr);
                    result.add(curr);
                    flag = true;
                }
                else if(!flag)
                {
                    for(int k=0; k<curr.length();k++)
                    {
                        if(Character.isAlphabetic(curr.charAt(k)))
                        {
                            continue;
                        }
                        String baby = curr.substring(0,k)+curr.substring(k+1);
                        if(!set.contains(baby))
                        {
                            set.add(baby);
                            q.add(baby);
                        }
                    }
                }
            }
        }
        return result;
    }
    private boolean isValid(String str)
    {
        int count =0;
        for(char s: str.toCharArray())
        {
            if(s=='(')
            {
                count++;
            }
            else if(s==')')
            {
                count--;
            }
            if(count==-1) return false;
        }
        return count==0;
    }
}
// Your code here along with comments explaining your approach
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, compilation errors

class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node==null) return node;
        Queue<Node> q = new LinkedList<>();
        map= new HashMap<>();
        
        q.add(node);
        Node copyNode = cloneNode(node);
        while(!q.isEmpty())
        {
            Node curr = q.poll();
            for(Node ne: curr.neighbors)
            {
                if(!map.containsKey(ne))
                {
                    q.add(ne);
                }
                map.get(curr).neighbors.add(cloneNode(ne));
            }
        }
        return copyNode;
    }
    private Node cloneNode(Node node)
    {
        if(!map.containsKey(node))
        {
            map.put(node, new Node(node.val));
        }
        return map.get(node);
    }
}
