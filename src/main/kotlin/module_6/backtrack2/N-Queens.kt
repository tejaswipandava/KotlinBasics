package module_6.backtrack2

/*
The N-queens puzzle is the problem of placing N queens on an N×N chessboard such that no two queens attack each other.

Given an integer A denoting the value of N, return all distinct solutions to the N-queens puzzle.

Each solution contains a distinct board configuration of the N-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
The final list should be generated in such a way that the indices of the queens in each list should be in reverse lexicographical order.

A = 4
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],
 */
class NQueens {
    fun solveNQueens(n: Int): List<List<String>> {
        var mat = Array(n) { CharArray(n) { '.' } }
        var result = mutableListOf<List<String>>()
        generateQBoard(mat, 0, result)
        return result
    }

    fun generateQBoard(mat: Array<CharArray>, row: Int, result: MutableList<List<String>>) {
        if (row == mat.size) {
            result.add(mat.map { String(it) }.toList())
            return
        }
        for (col in 0..mat.lastIndex) {
            if (checkQueenPosition(mat, row, col)) {
                mat[row][col] = 'Q'
                generateQBoard(mat, row + 1, result)
                mat[row][col] = '.'
            }
        }
    }

    fun checkQueenPosition(mat: Array<CharArray>, x: Int, y: Int): Boolean {

        //this is for row verification
        for (i in 0..mat.lastIndex) {
            if (mat[i][y] == 'Q') return false
        }

        //this is for column verification
        for (i in 0..mat[0].lastIndex) {
            if (mat[x][i] == 'Q') return false
        }

        //this is right diagonals
        var row = x
        var col = y
        while (row >= 0 && col <= mat.lastIndex) {
            if (mat[row][col] == 'Q') return false
            row--
            col++
        }

        //this is left diagonal
        row = x
        col = y
        while (row >= 0 && col >= 0) {
            if (mat[row][col] == 'Q') return false
            row--
            col--
        }

        return true
    }
}

fun main() {
    var result = NQueens().solveNQueens(4)
    for (ele in result) {
        for (v in ele) {
            print("$v  ")
        }
        println()
    }
}