package com.example.mockkguidebookandroid

import com.example.mockkguidebookandroid.interfaces.Navigator
import io.mockk.every
import io.mockk.mockk
import org.junit.Test

class NavigatorTest {

    /**
     * If a method has not been stubbed, MockK will throw an error if it is called. This is designed
     * to help make your tests easier to debug. For more complicated objects, you can tell MockK to
     * return simple values for all methods that have not been stubbed. This is done by using the
     * relaxed parameter when calling the mockk function
     * */

    @Test
    fun automaticStubTest() {

        val navigator = mockk<Navigator>(relaxed = true)
        every { navigator.currentLocation } returns "Home"

        // prints "Home"
        println(navigator.currentLocation)
        // does nothing
        navigator.navigateTo("Store")
    }

    //You can also only relax methods that return Unit

    @Test
    fun autoStubForMethodsThatReturnUnti(){
        val navigator = mockk<Navigator>(relaxUnitFun = true)
    }
}