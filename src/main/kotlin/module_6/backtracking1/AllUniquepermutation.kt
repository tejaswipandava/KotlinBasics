package module_6.backtracking1

/*
Given an array A of size N denoting collection of numbers that might contain duplicates, return all possible unique permutations.
NOTE: No 2 entries in the permutation sequence should be the same.

Problem Constraints
1 <= |A| <= 9
0 <= A[i] <= 10

input
A = [1, 1, 2]
A = [1, 2]

output

[ [1,1,2]
  [1,2,1]
  [2,1,1] ]

[ [1, 2]
  [2, 1] ]

 */
class AllUniquepermutation {
    fun permute(A: IntArray): Array<IntArray> {
        var result = HashSet<List<Int>>()
        var visited = BooleanArray(A.size)
        backtrack(0, A, visited, result, mutableListOf())
        return result.map { it.toIntArray() }.toTypedArray()

    }

    fun permute2(A: IntArray): Array<IntArray> {
        var alpha = IntArray(11)
        var ans = ArrayList<IntArray>()
        var permutation = IntArray(A.size)


        //freq map
        for (i in 0..A.lastIndex) {
            var index = A[i]
            alpha[index]++
        }

        recusrsivePermutation(A, alpha, ans, permutation, 0)
        return ans.toTypedArray()
    }

    fun backtrack(
        idx: Int,
        A: IntArray,
        visited: BooleanArray,
        result: HashSet<List<Int>>,
        combination: MutableList<Int>
    ) {
        if (idx == A.size) {
            result.add(combination.toList())
            return
        }

        for (i in 0..A.lastIndex) {
            if (!visited[i]) {
                visited[i] = true
                combination.add(A[i])
                backtrack(idx + 1, A, visited, result, combination)
                visited[i] = false
                combination.removeLast()
            }
        }
    }

    fun recusrsivePermutation(A: IntArray, alpha: IntArray, ans: ArrayList<IntArray>, permutation: IntArray, idx: Int) {
        if (idx == A.size) {
            ans.add(permutation.clone())
            return
        }

        for (i in 0..10) {
            if (alpha[i] > 0) {
                alpha[i]--
                permutation[idx] = i
                recusrsivePermutation(A, alpha, ans, permutation, idx + 1)
                alpha[i]++
            }
        }
    }
}

fun main() {
    var result = AllUniquepermutation().permute(intArrayOf(1, 1, 2))
    println(result)
}