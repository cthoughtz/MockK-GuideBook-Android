package com.example.mockkguidebookandroid

import io.mockk.mockk
import io.mockk.mockkObject
import io.mockk.unmockkObject
import org.junit.Test

class CalculatorTest {

    val calculator1 = mockk<Calculator1>()

    @Test
    fun objectTest(){

        // mockkObject() works on companion objects and enum classes as well.
        mockkObject(Calcualtor2) // The real method is called if the method is not stubbed.

        //throws because the method was not stubbed
        println(calculator1.add(2,2))

        // returns the result from the real method
        println(Calcualtor2.add(2,2,))

        // You can also unmock and object
        //unmockkObject(Calcualtor2)
    }

    /**
     * Note: You can mock static objects [Used in Java]
     * mockkStatic ("com.name.app.writer")
     * */
}