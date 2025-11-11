package module_6.backtrack2

class Sudoko {
    fun solveSudoku(board: Array<CharArray>) {
        Sudoko(board, 0, 0)
        return
    }

    fun printSudoko(board: Array<CharArray>) {
        for (i in 0..8) {
            for (j in 0..8) {
                print(board[i][j])
            }
            println()
        }
    }

    fun Sudoko(board: Array<CharArray>, x: Int, y: Int): Boolean {
        var x = x
        var y = y

        if (x == 9)
            return true

        if (x == 8 && y == 9) {
            printSudoko(board)
            return true
        }

        if (y == 9) {
            y = 0
            x = x + 1
        }



        if (board[x][y].equals('.')) {
            for (k in 1..9) {
                if (checkSudoko(board, x, y, k)) {
                    board[x][y] = k.digitToChar()
                    if (Sudoko(board, x, y + 1)) return true
                    board[x][y] = '.'
                }
            }
        } else {
            if (Sudoko(board, x, y + 1)) return true
        }

        return false
    }

    fun checkSudoko(board: Array<CharArray>, x: Int, y: Int, value: Int): Boolean {
        for (i in 0..board.lastIndex) {
            if (board[x][i] == value.digitToChar()) return false
        }

        for (i in 0..board.lastIndex) {
            if (board[i][y] == value.digitToChar()) return false
        }

        var row = x - (x % 3)
        var col = y - (y % 3)
        for (m in 0..2) {
            for (n in 0..2) {
                if (board[m + row][n + col] == value.digitToChar()) return false
            }
        }

        return true
    }
}


fun main() {
    val board: Array<CharArray> = arrayOf(
        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '.')
    )
    Sudoko().solveSudoku(board)
}