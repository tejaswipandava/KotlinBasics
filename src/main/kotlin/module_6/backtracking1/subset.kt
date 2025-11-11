package module_6.backtracking1

/*
Given a set of distinct integers A, return all possible subsets.
NOTE:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The initial list is not necessarily sorted.

A = [1, 2, 3]
o/p
[
 []
 [1]
 [1, 2]
 [1, 2, 3]
 [1, 3]
 [2]
 [2, 3]
 [3]
]
 */
class subset {
    fun subsets(A: IntArray): List<List<Int>> {
        A.sort()
        var result = ArrayList<IntArray>()
        var permutation = ArrayList<Int>()
        backtrack(A, 0, result, permutation)
        for (ele in result) {
            println(ele.toString())
        }
        return result.map { it.toList() }.toList()
    }

    fun backtrack(A: IntArray, idx: Int, result: ArrayList<IntArray>, permutation: ArrayList<Int>) {
        if (idx == A.size) {
            result.add(permutation.toIntArray())
            return
        }
        backtrack(A, idx + 1, result, permutation)
        permutation.add(A[idx])
        backtrack(A, idx + 1, result, permutation)
        permutation.removeAt(permutation.lastIndex)
    }
}

fun main() {
    var A = intArrayOf(1, 2, 2)
    var result = subset().subsets(A)
    println(result)
}