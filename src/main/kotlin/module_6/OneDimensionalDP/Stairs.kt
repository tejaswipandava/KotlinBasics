package module_6.OneDimensionalDP

class Stairs {
    fun climbStairs(A: Int): Int {

        var dpStore = IntArray(A + 1) { -1 }
        return stairs(A, dpStore)

//        return interativeStairs(A)
    }

    fun stairs(n: Int, dpStore: IntArray): Int {
        if (n <= 1) return n

        if (dpStore[n] != -1) return dpStore[n]

        dpStore[n] = stairs(n - 1, dpStore) + stairs(n - 2, dpStore)
        return dpStore[n]
    }

    fun interativeStairs(n: Int): Int {
        var a = 1
        var b = 1
        if (n == 0) return a
        else if (n == 1) return b

        var c = a + b

        for (i in 2..n) {
            c = (a + b) % 1000000007
            a = b
            b = c
        }

        return c % 1000000007
    }

    fun fibIterative(A: Int): Int {
        if (A <= 1) return 1
        var count = 1
        var a = 1
        var b = 1
        var c = a + b
        while (count != A) {
            c = (a + b) % 1000000007
            a = b
            b = c
            count++
        }

        return c
    }
}

fun main() {
    Stairs().climbStairs(4)
}