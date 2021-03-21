package com.example.mockkguidebookandroid

import com.example.mockkguidebookandroid.interfaces.Navigator
import io.mockk.every
import io.mockk.mockk
import org.junit.Test

class AnswersTest {

    /**
     * [answers] takes the place of [returns] after an [every] call. When using [returns], it should be
     * followed by a value to return. When using [answers], it should be followed by a lambda function that
     * is run when the mocked method is called.
     * */
    val navigator = mockk<Navigator>()
    val calculator = mockk<Calculator>()

    @Test
    fun answerTest() {
        every { navigator.currentLocation } returns "Home"
        every { navigator.currentLocation } answers { "Home" }
    }

    /**
     * A function has "side effects" if it does something other than just returning a value, such as
     * logging or mutating some outside state. [answers] let you model side effects by putting
     * additional statements inside its lambda function.
     * */
    @Test
    fun sideEffectsTest() {
        every { navigator.currentLocation } answers {
            println("Hello World!")

            "Work"
        }

        // prints "Hello World!"
        val location = navigator.currentLocation

        // prints "Work"
        println(location)
    }


    @Test
    fun answerScopeExample() {

        every { navigator.navigateTo(any()) } answers {
            val destination = firstArg<String>() //<-- firstArg is from the MockKAnswerScope Class
            throw IllegalAccessException("Can't reach $destination")
        }
    }


    /**
     * Individual arguments
     * Single arguments can be obtained using [firstArg()], [secondArg()], [thirdArg()], and
     * [lastArg()]. Other arguments can be obtained with arg(n), where n is the index for the
     * argument.
     *
     * For Example, arg(3) would return the forth argument.
     * */
    @Test
    fun castingStringExample() {

        every { calculator.add(any<Int>(),any<Int>()) } answers {

            // tries to cast the second argument to a string
            println(secondArg<String>())
            0
        }
    }


 /**
  * All arguments
  * The entire list of arguments can be obtained using [args]. [args] has the type [List<Any?>],so
  * you will need to manually cast values in the list if you want to work with them.
  * */
    @Test
    fun allArgumentsTest(){

        every { calculator.add(any<Int>(),any<Int>()) } answers {
            val numbers = args as List<Int>
            numbers.sum()
        }

     // prints "4"
     println(calculator.add(2,2))
    }

}