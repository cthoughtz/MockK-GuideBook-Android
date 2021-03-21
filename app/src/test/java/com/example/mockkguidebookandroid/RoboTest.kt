package com.example.mockkguidebookandroid

import android.graphics.Color
import android.widget.Button
import com.example.mockkguidebookandroid.interfaces.Navigator
import com.example.mockkguidebookandroid.interfaces.Robot
import io.mockk.*
import org.junit.Test
import java.util.logging.Logger

class RoboTest {

    private val robo = mockk<Robot>()
    private val logger = mockk<Logger>()
    private val view: Button = mockk(relaxed = true)

    @Test
    fun coEveryExample(){
        coEvery { robo.currentModel }returns "I-Robot"
    }

    @Test
    fun coJustRun(){
        coJustRun { logger.log(any()) } // When stubbing a function that returns nothing - coroutine
    }

    @Test
    fun coVerifyExample(){
        coVerify { robo.move("Left") } // Verify that a functions is called - coroutines
      //  verify { robo.move("Left") } // Show an error because the orignial function is a suspend function
    }

    @Test
    fun coVerifyAllExample(){
        coVerifyAll {
            robo.move("Left")
            robo.findHumansAsync()
        } // Verify that all of the functions are called but not in a particular order for coroutines
    }

    @Test
    fun coVerifyOrderExample(){
        coVerifyOrder {
            robo.move("Right")
            robo.findHumansAsync()
        } // Verify that all of the functions are called in the order declared
    }

    @Test
    fun coAnswersExample(){
        /**
         * [coAnswers] may look similar to returns however it works a little differently. Rather then passing the result we want,
         * we pass a lambda. This allows for more complex mocking and could be helpful in a variety of situations
         * */
        coEvery { robo.checkStatus() } coAnswers {Status.ERROR}
       // coEvery { robo.move("testing") } coAnswers (Status.ERROR) // Returns error because method doesn't have the correct return type
    }

    @Test
    fun coVerifySequenceExample() {

        coVerifySequence(false){
            robo.move("Up")
            robo.findHumansAsync()
            robo.checkStatus()
        } // Verifies that all calls inside verifyBlock happened, and no other call was made to those mocks

        @Test
        fun coExcludeRecordsExample(){
            // https://github.com/BracketCove/SpaceNotes/blob/master/app/src/test/java/com/wiseassblog/spacenotes/NoteDetailLogicTest.kt
            coExcludeRecords (true){
                view.setBackgroundColor(Color.RED)
            } // exclude method -> Useful because button calls alot of methods and if it is set to relax then it wil lverify that all
            // of the methods are called in that class.
        }
    }

}