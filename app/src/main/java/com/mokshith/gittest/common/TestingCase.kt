package com.mokshith.gittest.common

import android.os.Build
import androidx.annotation.RequiresApi
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.toSet
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.time.measureTime

suspend fun main() = coroutineScope {

    val flow = flow {
        repeat(3) {
            println("stated cooking pancake $it")
            delay(100)
            println("pancake is ready $it")
            emit(it)
        }
    }.buffer()

    flow.collect {
        println("collect: Start eating pancake $it")
        delay(1000)
        println("collect: finished eating pancake $it")
    }
}


fun findFirstDoubleLetter(str: String): Char? {
    val firstOccurrence = mutableMapOf<Char, Boolean>()
    var doubleLetter: Char? = null
    for (char in str) {
        if (char.isLetter()) {
            val lowerChar = char.lowercaseChar()
            if (firstOccurrence[lowerChar] == null) {
                firstOccurrence[lowerChar] = true
            } else {
                doubleLetter = lowerChar
                break
            }
        }
    }
    return doubleLetter
}


fun reverseWords(sentence: String): String {
    val words = sentence.split(" ")
    val reversedWords = StringBuilder()

    for (word in words) {
        val reversedWord = StringBuilder()
        for (i in word.length - 1 downTo 0) {
            reversedWord.append(word[i])
        }
        reversedWords.append(reversedWord).append(" ")
    }
    return reversedWords.trim().toString()
}

fun <T> findCommonElements(list1: List<T>, list2: List<T>): List<T> {
    val commonElements = mutableListOf<T>()

    for (element in list1) {
        if (list2.contains(element)) {
            if (!commonElements.contains(element)) {
                commonElements.add(element)
            }
        }
    }
    return commonElements
}

//    we have two list
//    create a function which returns common elements in two lists
//    val list1 = listOf<Any>(1,3,4,1,1,4)
//    val list2 = listOf<Any>(1,21,13,4,6)

fun commonElements(list1: List<String>, list2: List<String>): List<String> {
    val commonElements = mutableListOf<String>()
    for (elements in list1) {
        for (elements2 in list2) {
            if (elements == elements2) {
                if (!commonElements.contains(elements)) {
                    commonElements.add(elements)
                }
                break
            }
        }
    }
    return commonElements
}


