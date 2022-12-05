package structures.stack

class StackK(val size: Int): Stack {
    var stack: IntArray = intArrayOf(0);
    var position: Int = -1

    init {
        stack = IntArray(size)
        println(stack.size)
    }

    override fun push(i: Int) {
        position++
        stack[position] = i
    }

    override fun pull(): Int {
        val tmp = stack[position]
        stack[position] = 0
        position--
        return tmp
    }

    override fun peek(): Int {
        return stack.get(position)
    }

    override fun isFull(): Boolean {
        return position == stack.size - 1
    }

    override fun isEmpty(): Boolean {
        return position < 0
    }

    override fun size(): Int {
        return stack.size
    }


}