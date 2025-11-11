import java.util.LinkedList
import java.util.Queue

fun main() {
    val queue: Queue<String> = LinkedList()

    // Adding elements
    queue.add("Apple")
    queue.add("Banana")
    queue.add("Cherry")

    // Accessing the head of the queue
    println("Head of the queue: ${queue.peek()}")

    // Removing elements
    println("Removed element: ${queue.poll()}")
    println("Queue after removal: $queue")
}
