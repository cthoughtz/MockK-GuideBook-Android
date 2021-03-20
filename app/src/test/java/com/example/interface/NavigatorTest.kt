package com.example.`interface`

import com.example.mockkguidebookandroid.`interface`.Navigator
import io.mockk.every
import io.mockk.mockk
import org.junit.Test

// https://notwoods.github.io/mockk-guidebook/docs/mocking/stubbing/
class NavigatorTest {

    val navigator = mockk<Navigator>()

    @Test
    fun exampleTest(){
        //Stubbing allows you to setup canned answers when functions are called
        every { navigator.currentLocation } returns "Home"  // <--- Stub
        every { navigator.navigateTo("Part")} throws  // <-- Stub
                IllegalAccessException("Can't reach the park")

        //prints "Home"
        println(navigator.currentLocation)

        // throws an IllegalStateException
        navigator.navigateTo("Park")
    }
}