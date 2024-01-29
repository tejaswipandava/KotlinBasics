class Arrays {
    fun createOneDimentionalArray() {
        //arrays with size and values
        var arrWithSize = IntArray(10)
        var arrWithFixedDefault = IntArray(10) { 2 }
        var arrWithDefault = IntArray(10) { it }

        var arr = intArrayOf(5, 6, 8, 0)

        println("arr with only size")
        for (i in 0..9) {
            print(" ${arrWithSize[i]}")
        }
        println()
        println("arr with size and fixed default value")
        for (i in 0..9) {
            print(" ${arrWithFixedDefault[i]}")
        }
        println()
        println("arr with size and incrementing default value")
        for (i in 0..9) {
            print(" ${arrWithDefault[i]}")
        }
        println()
        println("arr creating builtin's")
        for (i in 0..3) {
            print(" ${arr[i]}")
        }

        println()

    }

    fun createMultiDimentionalArray() {
        var matrix1 = Array(3) { it -> IntArray(3) { 0 } }
        var matrix2 = Array(3) { it -> IntArray(3) { it } }

        println("2D array with default Initial values")
        printMatrix(matrix2)
        println()
    }

    fun copyOneDimentionalArray() {
        var arr = intArrayOf(5, 6, 8, 0)

        println("One Dimensional Arrays dont have this problem of shallow and deep copy")
        var arr1 = arr.copyOf()
        var arr2 = arr.clone()
        arr[0] = 10
        arr1[0] = 20
        arr2[0] = 30
        println("default array")
        for (i in 0..arr.lastIndex) {
            print("${arr[i]} ")
        }
        println("shallow copied array")
        for (i in 0..arr.lastIndex) {
            print("${arr1[i]} ")
        }
        println("shallow copied array")
        for (i in 0..arr.lastIndex) {
            print("${arr2[i]} ")
        }
    }

    fun copyTwoDimensionalArray() {
        var mat1 = Array(3) { IntArray(3) { 0 } }

        //Shallow Copy
        var mat2 = mat1.clone()
        var mat3 = mat1.copyOf()

        //Deep Copy
        var mat4 = mat1.map { it.clone() }.toTypedArray()


        //initialize the array
        var i = 0
        for (row in 0..mat1.lastIndex) {
            for (col in 0..mat1[0].lastIndex) {
                mat1[row][col] = i
                i++
            }
        }

        println("shallow copy, when one array changes so does all the arrays")
        println("main array")
        printMatrix(mat1)
        println("2nd array with clone")
        printMatrix(mat2)
        println("3rd arry with copyOf")
        printMatrix(mat3)


        println("Deep copy, when one array changes it doesnt affect other")
        printMatrix(mat4)
    }

    private fun printMatrix(mat1: Array<IntArray>) {
        for (row in 0..mat1.lastIndex) {
            for (col in 0..mat1[0].lastIndex) {
                print("${mat1[row][col]} ")
            }
            println()
        }
    }
}