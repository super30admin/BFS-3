// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


//dp_subsets
public class dp_subsetsem {
    // A recursive solution for subset sum
// problem


	// Returns true if there is a subset
	// of set[] with sum equal to given sum
	static boolean isSubsetSum(int set[],
							int n, int sum)
	{
		// Base Cases
		if (sum == 0)
			return true;
		if (n == 0)
			return false;

		// If last element is greater than
		// sum, then ignore it
		if (set[n - 1] > sum)
			return isSubsetSum(set, n - 1, sum);

		/* else, check if sum can be obtained
		by any of the following
			(a) including the last element
			(b) excluding the last element */
		return isSubsetSum(set, n - 1, sum)
			|| isSubsetSum(set, n - 1, sum - set[n - 1]);
	}

	/* Driver code */
	public static void main(String args[])
	{
		int set[] = { 3, 34, 4, 12, 5, 2 };
		int sum = 9;
		int n = set.length;
		if (isSubsetSum(set, n, sum) == true)
			System.out.println("Found a subset"
							+ " with given sum" + "true") ;
		else
			System.out.println("No subset with"
							+ " given sum");
	}


/* This code is contributed by Rajat Mishra */

}

// GFG.java


// Here is the top-down approach of
// dynamic programming
public class GFG{
	
    // A utility function that returns
    // maximum of two integers	
    static int max(int a, int b)	
    {	
        return (a > b) ? a : b;	
    }
    
    // Returns the value of maximum profit
    static int knapSackRec(int W, int wt[],
                        int val[], int n,
                        int [][]dp)
    {
        // Base condition
        if (n == 0 || W == 0)
            return 0;
            
        if (dp[n][W] != -1)
            return dp[n][W];
        
        if (wt[n - 1] > W)
            // Store the value of function call
            // stack in table before return
            return dp[n][W] = knapSackRec(W, wt, val,
                                        n - 1, dp);                                   
        else
            // Return value of table after storing
            return dp[n][W] = max((val[n - 1] +
                                knapSackRec(W - wt[n - 1], wt,
                                            val, n - 1, dp)),
                                knapSackRec(W, wt, val,
                                            n - 1, dp));			
    }
    
    static int knapSack(int W, int wt[], int val[], int N)
    {
        
        // Declare the table dynamically
        int dp[][] = new int[N + 1][W + 1];
        
        // Loop to initially filled the
        // table with -1
        for(int i = 0; i < N + 1; i++)
            for(int j = 0; j < W + 1; j++)
                dp[i][j] = -1;
        
        return knapSackRec(W, wt, val, N, dp);	
    }
    
    // Driver Code
    public static void main(String [] args)
    {	
        int val[] = { 60, 100, 120 };
        int wt[] = { 10, 20, 30 };
        
        int W = 50;
        int N = val.length;		
        
        System.out.println(knapSack(W, wt, val, N));
    }	
    }
    
   
    //top_down.java

	public class topdown_subset {
		// A Dynamic Programming solution for subset
	// sum problem
	
	
		// Returns true if there is a subset of
		// set[] with sum equal to given sum
		static boolean isSubsetSum(int set[],
								int n, int sum)
		{
			// The value of subset[i][j] will be
			// true if there is a subset of
			// set[0..j-1] with sum equal to i
			boolean subset[][] = new boolean[sum + 1][n + 1];
	
			// If sum is 0, then answer is true
			for (int i = 0; i <= n; i++)
				subset[0][i] = true;
	
			// If sum is not 0 and set is empty,
			// then answer is false
			for (int i = 1; i <= sum; i++)
				subset[i][0] = false;
	
			// Fill the subset table in bottom
			// up manner
			for (int i = 1; i <= sum; i++) {
				for (int j = 1; j <= n; j++) {
					subset[i][j] = subset[i][j - 1];
					if (i >= set[j - 1])
						subset[i][j] = subset[i][j]
									|| subset[i - set[j - 1]][j - 1];
				}
			}
	
			 // uncomment this code to print table
			for (int i = 0; i <= sum; i++)
			{
			for (int j = 0; j <= n; j++)
				System.out.print(subset[i][j] + " ");
			} 
			System.out.println();
			return subset[sum][n];
		}
	
		/* Driver code*/
		public static void main(String args[])
		{
			int set[] = { 3, 34, 4, 12, 5, 2 };
			int sum = 9;
			int n = set.length;
			if (isSubsetSum(set, n, sum) == true)
				System.out.println("helloooo Found a subset"
								+ " with given sum");
			else
				System.out.println("No subset with"
								+ " given sum");
		}
	
	
	
	
	}
	