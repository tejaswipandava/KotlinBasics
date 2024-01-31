class stringClass {

    fun chatToInt() {
        var chr = '9'
        var digit: Int = chr.digitToInt()

        println("digit is haivng $digit")
    }

    fun charToASCII() {
        var chr = 'A'
        var ascii = chr.code

        println("ASCII value of A is $ascii")
    }

    fun charToString() {
        var cha = 'A'
        var str = cha.toString()
        println("str contains $str and its datatype ${str::class.simpleName}")
    }

    fun charArrayToString() {
        var charArray = charArrayOf('H', 'e', 'l', 'l', 'o')

        var str1 = String(charArray)
        var str2 = charArray.joinToString("")
        var str3 = StringBuilder().append(charArray).toString()

        println("$str1 world")
        println("$str2 world")
        println("$str3 world")
    }
}