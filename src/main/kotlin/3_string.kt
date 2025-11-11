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

    fun stringToChar() {
        var str = "Hello"
        var chr = str.toCharArray()

        println("we have the char : $chr and its datatype ${chr::class.simpleName}")
    }

    fun stringSplitAndMerge() {
        var str = arrayOf("str1", "str2", "str3")
        var finalString = str.joinToString(" ")
        println("we have the merged final string as $finalString")
        var newstr = finalString.split(" ")
        newstr.forEach { println("we have string $it") }
    }
}


fun main() {
    var strclass = stringClass()
    strclass.chatToInt()
    strclass.charToASCII()
    strclass.charToString()
    strclass.charArrayToString()
    strclass.stringToChar()
    strclass.stringSplitAndMerge()
}