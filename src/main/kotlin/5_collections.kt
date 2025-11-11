import java.util.ArrayDeque
import java.util.PriorityQueue

class collections {
    fun listclass() {
        var fruits = mutableListOf("apple", "bannana")
        var veg = mutableListOf<String>()
        fruits.add("mango")
        fruits.removeAt(0)
        fruits.addAll(listOf("carrot", "grapes"))

        fruits.forEach { println(it) }
        fruits.first()
        fruits.last()
        fruits.contains("apple")
        var str = fruits[2]
    }

    fun hashset() {
        var fruits = mutableListOf("apple", "bannana", "mango", "grapes", "apple", "bannana", "mango", "grapes")
        var distinctFruits = HashSet<String>()
        distinctFruits.addAll(fruits)

        distinctFruits.forEach { println(it) }

        distinctFruits.isEmpty()
        distinctFruits.size
        distinctFruits.contains("apple")
        distinctFruits.add("zen")
        distinctFruits.remove("apple")
        distinctFruits.forEach { println(it) }
    }

    fun hashmap() {
        var fruits = mutableListOf("apple", "bannana", "mango", "grapes", "apple", "bannana", "mango", "grapes")
        var fruitsQuantity = HashMap<String, Int>()

        var teja = fruits[0]

        for (ele in fruits) {
            if (fruitsQuantity.contains(ele)) {
                println("set 1  $fruitsQuantity[ele]")
                fruitsQuantity[ele]?.plus(1)
                println("set 2  $fruitsQuantity[ele]")
                fruitsQuantity[ele] = 1
                println("set 3  $fruitsQuantity[ele]")
            } else {
                fruitsQuantity.put(ele, 1)
            }
        }

        fruitsQuantity.remove("apple")
        var keys = fruitsQuantity.keys
        var values = fruitsQuantity.values
    }

    fun stack() {
        val stack = ArrayDeque<Int>()

        stack.push(1)
        stack.push(2)
        println(stack.peek())
        stack.pop()
        stack.pop()
    }

    fun queue() {
        val queue = ArrayDeque<Int>()

        queue.add(1)
        queue.add(2)
        println(queue.peek())
        queue.remove()
        queue.remove()
    }

    fun minheap() {
        val heaps = PriorityQueue<Int>()
        heaps.add(10)
        heaps.add(1)

        println(heaps.peek())
        heaps.poll()
    }

    fun maxheap() {
        val heaps = PriorityQueue<Int>(compareByDescending { it })
        heaps.add(10)
        heaps.add(1)

        println(heaps.peek())
        heaps.poll()
    }
}

fun main() {
    var c = collections()
    c.listclass()
}