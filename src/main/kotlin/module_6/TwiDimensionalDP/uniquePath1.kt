package module_6.TwiDimensionalDP

class uniquePath1 {
    fun uniquePathsWithObstacles(A: Array<IntArray>): Int {
        var dp = Array(A.size) { IntArray(A[0].size) { -1 } }
        return recursiveSolution(A, 0, 0)
    }

    fun recursiveSolution(A: Array<IntArray>, x: Int, y: Int): Int {
        if (x >= A.size || y >= A[0].size || A[x][y] == 1) return 0
        if (x == A.lastIndex && y == A[0].lastIndex) return 1

        return recursiveSolution(A, x, y + 1) + recursiveSolution(A, x + 1, y)
    }

    //top down , memoization
    private fun ways(A: Array<IntArray>, dp: Array<IntArray>, i: Int, j: Int): Int {
        if (j < 0 || i < 0 || A[i][j] == 1) return 0
        if (i == 0 && j == 0) return 1

        if (dp[i][j] != -1) return dp[i][j]

        dp[i][j] = ways(A, dp, i - 1, j) + ways(A, dp, i, j - 1)

        return dp[i][j]
    }

    //iterative , tabulation
    private fun iterativeWays(A: Array<IntArray>, dp: Array<IntArray>): Int {
        if (A[0][0] != 1) dp[0][0] = 1

        var n = A.size
        var m = A[0].size

        fillcolumn(A, dp)
        fillrow(A, dp)

        for (i in 1..A.lastIndex) {
            for (j in 1..A[0].lastIndex) {
                if (A[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
                }
            }
        }

        return dp[n - 1][m - 1]
    }

    private fun fillcolumn(A: Array<IntArray>, dp: Array<IntArray>) {
        for (j in 1..A[0].lastIndex) {
            if (A[0][j] != 1) dp[0][j] = dp[0][j - 1]
        }
    }

    private fun fillrow(A: Array<IntArray>, dp: Array<IntArray>) {
        for (i in 1..A.lastIndex) {
            if (A[i][0] != 1) dp[i][0] = dp[i - 1][0]
        }
    }
}