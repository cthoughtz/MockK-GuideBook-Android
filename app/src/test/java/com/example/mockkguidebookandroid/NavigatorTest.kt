package com.example.mockkguidebookandroid

import io.mockk.every
import io.mockk.mockkObject
import org.junit.Test

class NavigatorTest {

   @Test
   fun mockObjectText(){

       mockkObject(FeatureFlags)
       every { FeatureFlags.featureEnabled } returns false

       // prints false
       println(FeatureFlags.featureEnabled)
   }
}