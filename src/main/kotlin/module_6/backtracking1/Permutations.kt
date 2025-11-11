package module_6.backtracking1

/*
Given an integer array A of size N denoting collection of numbers , return all possible permutations.

NOTE:

No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.
Return the answer in any order
A = [1, 2, 3]
[ [1, 2, 3]
  [1, 3, 2]
  [2, 1, 3]
  [2, 3, 1]
  [3, 1, 2]
  [3, 2, 1] ]
 */
class Permutations {
    fun permute(A: IntArray): Array<IntArray> {
        var result = ArrayList<IntArray>()
        var visited = BooleanArray(A.size) { false }
        backtrack(0, A, result, arrayListOf(), visited)
        return result.toTypedArray()

    }

    fun backtrack(
        idx: Int,
        A: IntArray,
        result: ArrayList<IntArray>,
        combination: ArrayList<Int>,
        visited: BooleanArray
    ) {
        if (idx == A.size) {
            result.add(combination.toIntArray())
            return
        }

        for (i in 0..A.lastIndex) {
            if (!visited[i]) {
                visited[i] = true
                combination.add(A[i])
                backtrack(idx + 1, A, result, combination, visited)
                visited[i] = false
                combination.removeLast()
            }
        }

    }
}

fun main(){
    var result = Permutations().permute(intArrayOf(1,2,3))
    println(result)
}