package module_6.TwiDimensionalDP

class `Dungeon princess` {
    fun calculateMinimumHP(A: Array<IntArray>): Int {
        var dp = Array(A.size) { IntArray(A[0].size) { 0 } }
        return iterativeDP(A, dp)
    }

    fun iterativeDP(A: Array<IntArray>, dp: Array<IntArray>): Int {
        var n = A.lastIndex
        var m = A[0].lastIndex

        //if lst cell is positive we want 1
        if (A[n][m] > 0) dp[n][m] = 1 else dp[n][m] = Math.abs(A[n][m]) + 1

        //for last col
        for (j in A.lastIndex - 1 downTo 0) {
            dp[n][j] = Math.max(1, dp[n][j + 1] - A[n][j]);
        }

        //for last row
        for (i in n - 1 downTo 0) {
            //dp[i][m] = max(1, dp[i + 1][m] - A[i][m])
            dp[i][m] = Math.max(1, dp[i + 1][m] - A[i][m]);
        }

        for (i in n - 1 downTo 0) {
            for (j in m - 1 downTo 0) {
                //dp[i][j] = max(1, min(dp[i + 1][j], dp[i][j + 1]) - A[i][j])
                dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - A[i][j]);
            }
        }

        return dp[0][0]
    }
}