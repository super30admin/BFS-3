"""
We need to find out if we can rot all the oranges, if yes, return the time it will take, else return -1
Connected components : 
All Independent nodes which are rotten, we will initiate from those nodes
We check for 4 directional adjacent elements, if there are any fresh oranges, we put them in the queue
To avoid visited nodes,we can mutate the same node to a different state and do time++ and put the neighboring nodes which can be processed
i.e. if there is a fresh mango present

When we were putting the rotten oranges inside the queue, we can keep a count of fresh oranges at that time and reduce its count as and when the get rot

Finally we check if the freshcount is 0 in the end

TC: O(m x n)
SC: O(m x n) if all oranges are rotten, we fill the queue with all elements, hence m*n


"""

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if grid == None or len(grid)==0:
            return -1
        m = len(grid)
        n = len(grid[0])
        q = deque()
        fresh = 0
        time=0
        # we will traverse over the grid and if we find a fresh orange, we increase the count of fresh
        # if we find a rotten orange, we add it's position to the queue
        for i in range(m):
            for j in range(n):
                if grid[i][j]==1:
                    fresh+=1
                if grid[i][j]==2:
                    q.append((i,j))
        # we will now process the elements added to the queue, and add the fresh oranges neighboring the rotten ones to the queue
        
        if fresh == 0 : #if we dont have any fresh oranges, we return 0
            return 0
        dirs = [[-1,0],[0,1], [1,0], [0,-1]] #else we create a dirs array to check all the neighbors of the rotten oranges in the queue
        while q:
            size = len(q)
            for i in range(size):
                node = q.popleft()
                for pos in dirs:  
                    nr = node[0]+pos[0]
                    nc = node[1]+pos[1]
                    
                    if nr>=0 and nc>=0 and nr<m and nc<n and grid[nr][nc]==1:  # if the new pos is in range and if there is a fresh orange at that position
                        grid[nr][nc]=2 #we change it to rotten
                        fresh-=1 #and reduce the fresh count
                        q.append((nr,nc)) #and add it to the queue of rotten oranges
            time+=1   
            if fresh == 0 : #if there are no fresh oranges left, we were able to rot all of them and re return the time taken
                return time
        return -1
        
        
     
 """
 Approach 2 - DFS

 If you end up vising a nodes from two different sides, we will get different time for rotting that particular node - We will have to process each node from ever rotten node and compare the multiple times of rotting and pick the lowest 
 How is this DFS implementation?
 You visit each and every node that is fresh, and keep adding the time

 All the fresh oranges will be rotten from time>=2
 Hence, in the end we will subtract 2 from the final time. 

 """              
                
                
        
            