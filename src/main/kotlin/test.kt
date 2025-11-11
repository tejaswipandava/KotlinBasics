class test {
    fun solution(s: String) {
        var result = ""
        var i = 0
        while (i <= s.length) {
            if (s[i] == 'm') {
                result += "-"
                i = i + 5
                if (i >= s.length) break
            } else {
                result += "+"
                i = i + 4
                if (i >= s.length) break
            }
        }

        println(result)
    }
}


fun main() {
    var A = intArrayOf(50, 222, 49, 52, 25)

    var hm = HashMap<Int, IntArray>()

    var maxSum = Int.MIN_VALUE

    for (ele in A) {
        var str = ele.toString()
        var s = str[0].digitToInt()
        if (hm.contains(s)) {
            var arr = hm[s]!!
            var list = arr.toMutableList()
            list.add(ele)
            hm[s] = list.toIntArray()
        } else {
            var value = intArrayOf(ele)
            hm.put(s, value)
        }
    }

    //130,191,10
    for ((k, v) in hm) {

        var list = v
        var hm2 = HashMap<Int, IntArray>()
        for (ele in list) {
            var l = ele.toString().last().digitToInt()
            if (hm2.contains(l)) {
                var arr = hm2[l]!!
                var list = arr.toMutableList()
                list.add(ele)
                hm2[l] = list.toIntArray()
            } else {
                var value = intArrayOf(ele)
                hm2.put(l, value)
            }
        }

        for ((k, v) in hm2) {
            var lis = v
            if (lis.size >= 2) {
                lis.sortDescending()
                maxSum = Math.max(lis[0] + lis[1], maxSum)
            }
        }

    }
    var t:Int = 1000000000+1000000000

    println(maxSum)
}

