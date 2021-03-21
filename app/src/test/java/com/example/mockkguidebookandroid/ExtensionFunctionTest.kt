package com.example.mockkguidebookandroid

import io.mockk.every
import io.mockk.mockk
import org.junit.Test
import java.lang.reflect.Type

class ExtensionFunctionTest {

    val mainActivity = mockk<MainActivity>()

    @Test
    fun ExtFunctionTest(){
        with(mainActivity){
            every { "Something".removeFirstLastChar() } returns "return"
        }
    }
}