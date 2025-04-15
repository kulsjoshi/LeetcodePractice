/**
 * Problem: 1. Two Sum
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers
 * such that they add up to target.
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: nums[0] + nums[1] == 9
 */

fun main() {
    val intArray = intArrayOf(7, 11, 2, 12)
    val target = 9
//    val result = twoSum(intArray, target)
//    println(result.joinToString())

    val resultWithHashMap = findTwoSum(intArray, target)
    println(resultWithHashMap.joinToString())
}


fun findTwoSum(numbers: IntArray, target: Int): IntArray {

    /**
     * We create a mutable map to keep track of each number we’ve seen and its index.
     *
     * Key: the number itself (Int)
     * Value: its index in the array (Int)
     *
     * So as we loop through the array, this map will help us check if we’ve already seen a number
     * that can pair with the current one to make the target.
     */
    val numToIndex = mutableMapOf<Int, Int>()

    /**
     * This is Kotlin’s nice way to loop through both the index and value at the same time.
     * For example:
     * We get:
     * index = 0, num = 3
     * index = 1, num = 2
     * index = 2, num = 4
     */
    for ((index, num) in numbers.withIndex()) {

        /**
         * We calculate the complement — the number we need to reach the target.
         * For example, if:
         * target = 6
         * num = 2
         * then complement = 6 - 2 = 4
         */
        val complement = target - num

        /**
         * We check if complement is already in the map.
         *
         * If yes: that means we’ve already seen the other number that pairs with
         * the current one to make the target.
         * We return both indices:
         * numToIndex[complement]!! — the index of the earlier number
         * index — the current index
         *
         * ✅ !! is safe here because we just checked that the key exists
         */
        if (numToIndex.containsKey(complement)) {
            return intArrayOf(numToIndex[complement]!!, index)
        }
        /**
         * We didn’t find a match yet, so we store this number and its index in the map.
         * That way, future numbers can find it if needed.
         */
        numToIndex[num] = index
    }

    /**
     * This is technically never reached, since the problem guarantees one solution.
     * But Kotlin needs a return at the end.
     */
    return intArrayOf()
}


/**
 * Brut force attack solution
 */
fun twoSum(intArray: IntArray, target: Int): IntArray {
    for (i in intArray.indices) {
        println("i is ${intArray[i]}")
        for (j in i + 1 until intArray.size) {
            println("j is ${intArray[j]}")
            if (intArray[i] + intArray[j] == target) {
                return intArrayOf(i, j)
            }
        }
        println("---------")
    }
    return intArrayOf()
}