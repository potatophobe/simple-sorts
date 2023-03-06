package ru.potatophobe.simplesorts

//                  100     1000    10000
//  bubbleSort      30ms    10ms    287ms
//  insertionSort   0ms     10ms    37ms
//  shellSort       29ms    1ms     7ms
//

fun bubbleSort(array: IntArray) {
    repeat(array.size) {
        for (i in 0 until array.lastIndex) {
            if (array[i] > array[i + 1]) {
                array.swap(i, i + 1)
            }
        }
    }
}

fun insertionSort(array: IntArray) {
    for (i in array.indices) {
        var j = i
        while (j > 0 && array[j] <= array[j - 1]) {
            array.swap(j, j - 1)
            j--
        }
    }
}

fun shellSort(array: IntArray) {
    var gap = array.size
    while (gap > 0) {
        gap /= 2
        for (i in gap..array.lastIndex) {
            var j = i
            while (j >= gap && array[j - gap] > array[j]) {
                array.swap(j, j - gap)
                j -= gap
            }
        }
    }
}

private fun IntArray.swap(i: Int, j: Int) {
    val temp = get(i)
    set(i, get(j))
    set(j, temp)
}
