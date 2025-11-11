package module_6.OneDimensionalDP

class fibonaccinumbers {
    fun main(args: Array<String>) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        var value = readln().toInt()
        var dpStore = IntArray(value + 1) { -1 }
        //println(fibonacci(value))
        //println(dpfib(value, dpStore))
        //println(iterativeFib(value, dpStore))


        //most optimal solution
        println(iterativeFibWithSpace(value))

    }

    //recursion basic
//time:2^n and space n
    fun fibonacci(n: Int): Int {
        if (n <= 1) return n

        return fibonacci(n - 1) + fibonacci(n - 2)
    }

    //Dynamic Programming with memoization
//time: n space n
//also called top down approach
    fun dpfib(n: Int, dpStore: IntArray): Int {
        if (n <= 1) return n

        if (dpStore[n] != -1) return dpStore[n]

        dpStore[n] = dpfib(n - 1, dpStore) + dpfib(n - 2, dpStore)
        return dpStore[n]
    }

    //iterative solution
//bottom up approach
//time n space n
    fun iterativeFib(n: Int, dpStore: IntArray): Int {
        dpStore[0] = 0
        dpStore[1] = 1

        for (i in 2..n) {
            dpStore[i] = dpStore[i - 1] + dpStore[i - 2]
        }

        return dpStore[n]
    }


    //iterative solution
//bottom up approach
//time n space 1
    fun iterativeFibWithSpace(n: Int): Int {
        var a = 0
        var b = 1
        var c = a + b

        if (n == 0) return a
        else if (n == 1) return b


        for (i in 2..n) {
            c = a + b
            a = b
            b = c
        }

        return c


    }
}