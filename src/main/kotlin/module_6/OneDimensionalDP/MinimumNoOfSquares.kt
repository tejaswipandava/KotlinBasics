package module_6.OneDimensionalDP

class MinimumNoOfSquares {
    fun countMinSquares(A: Int): Int {
        var dp = IntArray(A + 1) { -1 }
        return iterativeSquare(A, dp)
    }

    fun recursiveSolution(A: Int): Int {
        if (A <= 1) return A
        var i = 1
        var ans = Int.MAX_VALUE
        while (i * i <= A) {
            ans = Math.min(ans, recursiveSolution(A - (i * i)))
            i++
        }

        return ans + 1
    }

    fun recursiveSquare(A: Int, dp: IntArray): Int {
        if (A <= 1) return A

        if (dp[A] != -1) return dp[A]

        var i = 1
        var ans = Int.MAX_VALUE
        while (i * i <= A) {
            ans = Math.min(ans, recursiveSquare(A - (i * i), dp))
            i++
        }

        dp[A] = ans + 1
        return dp[A]
    }

    fun iterativeSquare(A: Int, dp: IntArray): Int {
        dp[0] = 0
        dp[1] = 1

        for (i in 1..A) {
            var j = 1
            var ans = Int.MAX_VALUE
            while (j * j <= i) {
                var idx = i - (j * j)
                ans = Math.min(dp[idx], ans)
                j++
            }
            dp[i] = ans + 1
        }

        return dp[A]
    }
}