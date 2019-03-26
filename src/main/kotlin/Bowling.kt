fun List<Ball>.scoreGame(): Int {
    var result = 0
    var rollCount = 0
    forEachIndexed { index, ball ->
        if(rollCount < 20) {
            result += scoreBall(index, ball, this)
            if(ball.isStrike()) rollCount+=2
            else rollCount++
        }
    }
    return result
}

fun scoreBall(index: Int, ball: Ball, game: List<Ball>): Int {
    return when {
        ball.isSpare() -> scoreSpare(index, game)
        ball.isStrike() -> scoreStrike(index, game)
        else -> ball.roll.toInt()
    }
}

private fun getNextBallValue(index: Int, game: List<Ball>):Int{
    return if(game.size >index) {
        when {
            game[index].isStrike() -> 10
            game[index].isSpare() -> 10 - game[index-1].roll.toInt()
            else -> game[index].roll.toInt()
        }
    }
    else 0
}


private fun scoreStrike(index: Int, game: List<Ball>) : Int {
    return 10 + getNextBallValue(index+1, game) + getNextBallValue(index+2, game)
}

private fun scoreSpare(index: Int, game: List<Ball>) : Int {
    return 10 - game[index - 1].roll.toInt() + getNextBallValue(index+1, game)
}

private fun Ball.isSpare(): Boolean {
    return "/" == roll
}

private fun Ball.isStrike(): Boolean {
    return "X".equals(roll, true)
}