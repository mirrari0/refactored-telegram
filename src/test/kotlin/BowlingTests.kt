import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BowlingTests {


    @Test
    fun `given empty game should return zero`() {
        assertEquals(0, listOf<Ball>().scoreGame())
    }

    @Test
    fun `given a game with 20 rolls scoring one should return twenty`() {
        assertEquals(20, generateGame("1", 20).scoreGame())
    }

    @Test
    fun `given a game with 21 rolls scoring 5 each should return two hundred`() {
        val game = generateGame("5", 21)
        for (i in 1..20 step 2) {
            game[i] = Ball("/")
        }
        assertEquals(150, game.scoreGame())
    }

    @Test
    fun `given a game with 13 rolls scoring 10 each should return three hundred`() {
        assertEquals(300, generateGame("X", 13).scoreGame())
    }

    @Test
    fun `given a game with 17 rolls scoring 10 each frame should return 195`() {
        val game = generateGame("X", 4)
        for (i in 0..12 step 2) {
            game.add(Ball("5"))
            game.add(Ball("/"))
        }
        game.add(Ball("5"))
        assertEquals(195, game.scoreGame())
    }


    private fun generateGame(score: String, numberOfBalls: Int): MutableList<Ball> {
        val game = mutableListOf<Ball>()
        repeat(numberOfBalls) {
            game.add(Ball(score))
        }
        return game
    }
}