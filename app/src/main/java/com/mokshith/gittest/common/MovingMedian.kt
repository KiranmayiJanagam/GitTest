package com.mokshith.gittest.common

fun main() {
    val arr = arrayOf(3, 0, 0, -2, 0, 2, 0, -2)
    val arr1 = arrayOf(5, 2, 4, 6)
    println(findMovingMovingMedian(arr))
    println(findMovingMovingMedian(arr1))
}

fun findMovingMovingMedian(arr: Array<Int>): String {
    var median = ""
    if (arr.isEmpty()) {
        return median
    }
    if (arr.size == 1) {
        return arr[0].toString()
    }
    val n = arr[0]
    val newArr = arr.copyOfRange(1, arr.size)
    var j = 0
    for (i in 1 until arr.size) {
        if (i < n) {
            val window = newArr.copyOfRange(j, i).sorted()
            median += "${findMedian(window)},"
        } else {
            if (j + n < arr.size) {
                val window = newArr.copyOfRange(j, j + n).sorted()
                median += "${findMedian(window)},"
                j += 1
            }
        }
    }
    return median.removeSuffix(",")
}

fun findMedian(arr: List<Int>): String {
    var median = ""
    if (arr.size == 1) {
        median = "${arr[0]}"
        return median
    }
    if (arr.size % 2 == 0) {
        val mid = arr.size / 2
        median = "${(arr[mid] + arr[mid - 1]) / 2}"
    }
    if (arr.size % 2 != 0) {
        val mid = (arr.size - 1) / 2
        median = "${arr[mid]}"
    }
    return median
}

