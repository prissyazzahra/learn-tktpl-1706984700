package id.ac.ui.cs.mobileprogramming.prissy.helloworld

import org.junit.Assert.*
import org.junit.Test

class MainActivityUnitTest {
    private val mainActivity = MainActivity()

    @Test
    fun returnsBasicGreeting() {
        val basicGreeting = mainActivity.changeGreeting("basic", "Name")
        assertEquals(basicGreeting, "Hello there, Name!")
    }

    @Test
    fun returnsFancyGreeting() {
        val fancyGreeting = mainActivity.changeGreeting("fancy", "Name")
        assertEquals(fancyGreeting, "Salutations, Name!")
    }

    @Test
    fun returnsDandyGreeting() {
        val dandyGreeting = mainActivity.changeGreeting("dandy", "Name")
        assertEquals(dandyGreeting, "Tally ho, Name!")
    }
}