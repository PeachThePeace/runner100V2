import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.*
import org.junit.jupiter.api.Assertions.assertEquals

class Runner100Test {

    @Test
    fun validInitialization() {
        val runner = Runner100("John")
        // No exception should be thrown during initialization
    }

    @Test
    fun invalidInitializationEmptyName() {
        assertThrows<IllegalArgumentException> {
            Runner100("")
        }
    }

    @Test
    fun invalidInitializationBlankName() {
        assertThrows<IllegalArgumentException> {
            Runner100("   ")
        }
    }

    @Test
    fun addValidResult() {
        val runner = Runner100("John")
        runner.addResult(10)
        assertEquals(10, runner.bestResult())
    }

    @Test
    fun addInvalidResultNegativeValue() {
        val runner = Runner100("John")
        assertThrows<IllegalStateException> {
            runner.addResult(-5)
        }
    }

    @Test
    fun worstResultNoResultsAdded() {
        val runner = Runner100("John")
        assertEquals(0, runner.worstResult())
    }

    @Test
    fun worstResultAfterAddingResults() {
        val runner = Runner100("John")
        runner.addResult(5)
        runner.addResult(10)
        assertEquals(10, runner.worstResult())
    }

    @Test
    fun bestResultNoResultsAdded() {
        val runner = Runner100("John")
        assertEquals(0, runner.bestResult())
    }

    @Test
    fun bestResultAfterAddingResults() {
        val runner = Runner100("John")
        runner.addResult(15)
        runner.addResult(10)
        assertEquals(10, runner.bestResult())
    }


}