import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BowlingTests {


    @Test
    fun `given empty game should return zero`() {
        assertEquals(0, listOf<Ball>().scoreGame())
    }

    @Test
    fun `given a game with 20 rolls scoring one should return twenty`() {
        assertEquals(20, generateGame("1",20).scoreGame())
    }


    private fun generateGame(score: String, numberOfBalls: Int): List<Ball> {
        val game = mutableListOf<Ball>()
        repeat(numberOfBalls) {
            game.add(Ball(score))
        }
        return game
    }
}