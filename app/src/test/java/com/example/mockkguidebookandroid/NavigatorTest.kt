package com.example.mockkguidebookandroid

import io.mockk.Called
import io.mockk.mockk
import io.mockk.every
import io.mockk.verify
import org.hamcrest.CoreMatchers.any
import org.junit.Test

class NavigatorTest {

    private val navigator = mockk<Navigator>()
    val navigationView = NavigationView(navigator)
    @Test
    fun exampleTest() {
        every { navigator.navigateTo(any()) } returns Unit

        navigator.navigateTo("Park")

        /**
         * Inside the verification block (between the opening curly bracket { and closing curly bracket}),
         * you write the method you want to verify. {navigator.navigate("Park")} tells MockK to check
         * if the navigateTo method on the navigator object was called with the argument "Park".
         * */
        verify { navigator.navigateTo("Park") }
    }

    @Test
    fun verifyButton(){
        /**
         * In the previous simple example, verification isn't very helpful as it just checks that
         * the previous line ran. Verification becomes more useful when you are testing other classes,
         * that depend on mocked instances. Example of testing a button
         * */
        every { navigator.navigateTo(any()) } returns Unit

        // Test the button in navigation view
        navigationView.goToParkButton.performClick()
        verify{navigator.navigateTo("Park")}
    }

    @Test
    fun verifyButtonException(){

        every { navigator.navigateTo(any()) } returns Unit // <--- stub

        //Test verify exception thrown became method was never called
        navigationView.goToParkButton.performClick()
        verify{navigator.navigateTo("ParkABC")} //<-- never called because of ParkABC
    }

    @Test
    fun verifyThatMockFunctionWasNeverCalled(){
        verify { navigator wasNot Called }
    }

    @Test
    fun verifyThatFunctionWasNeverCalled(){

        verify(inverse = true){navigator.navigateTo("Park")}
        verify(exactly = 0) {navigator.navigateTo("Park")}
    }

    @Test
    fun verifyThatAFunctionWasCalledACertainNumberOfTimes(){

        verify(exactly = 1) {navigator.navigateTo("Park")}
        verify(atLeast = 1, atMost = 1){navigator.navigateTo("Park")}
    }

    @Test
    fun verifyThatAFunctionWasCalledBetweenACertianRange(){
     verify(atLeast = 2, atMost = 3) {navigator.navigateTo("Park")}
    }
}