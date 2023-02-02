import kotlin.random.Random

/**
 * TicTacToe class implements the interface
 * @author Glenn Buyce
 * @date 2/2/2023
 */
class FourInARow
/**
 * clear board and set current player
 */
    : IGame {
    // game board in 2D array initialized to zeros
    private val board = Array(GameConstants.ROWS) { IntArray(GameConstants.COLS) { 0 } }

    override fun clearBoard() {
        for (row in 0 until GameConstants.ROWS) {
            for (col in 0 until GameConstants.COLS) {
               board[row][col] = GameConstants.EMPTY
            }
        }
    }

    override fun setMove(player: Int, location: Int) {
        val col = location % 6
        val row = location / 6

        if (board[row][col] != GameConstants.EMPTY) {
            println("This space is taken. Choose again:")
        } else {
            when (player) {
                1 -> board[row][col] = GameConstants.RED

                2 -> {
                    board[row][col] = GameConstants.BLUE
                    printBoard()
                }
            }
        }
    }

    override fun computerMove(): Int {
        return Random.nextInt(0, 36)
    }

    override fun checkForWinner(): Int {

        var p1 = 1
        var p2 = 1

        //horizontal
        for (row in 0 until 6) {
            for (col in 0 until 5) {
                when (board[row][col]) {
                    GameConstants.RED -> {
                        if (board[row][col] == board[row][col + 1]) {
                            p1++
                            if (p1 == 4) return 1
                        } else {
                            p1 = 1
                        }
                    }

                    GameConstants.BLUE -> {
                        if (board[row][col] == board[row][col + 1]) {
                            p2++
                            if (p2 == 4) return 2
                        } else {
                            p2 = 1
                        }
                    }
                }
            }
        }

        p1 = 1
        p2 = 1

        //Vertical
        for (col in 0 until 6) {
            for (row in 0 until 5) {
                when (board[row][col]) {
                    GameConstants.RED -> {
                        if (board[row][col] == board[row + 1][col]) {
                            p1++
                            if (p1 == 4) return 1
                        } else {
                            p1 = 1
                        }
                    }

                    GameConstants.BLUE -> {
                        if (board[row][col] == board[row + 1][col]) {
                            p2++
                            if (p2 == 4) return 2
                        } else {
                            p2 = 1
                        }
                    }
                }
            }
        }

        p1 = 1
        p2 = 1

        //Diagonal Right
        for (right in 0 until 3) {
            when (right) {
                0 -> {
                    var row = 2
                    var col = 0
                    for (check in 0 until 6) {
                        when (board[row][col]) {
                            GameConstants.RED -> {
                                if (board[row][col] == board[row + 1][col + 1]) {
                                    p1++
                                    if (p1 == 4) return 1
                                } else {
                                    p1 = 1
                                }
                            }

                            GameConstants.BLUE -> {
                                if (board[row][col] == board[row + 1][col + 1]) {
                                    p2++
                                    if (p2 == 4) return 2
                                } else {
                                    p2 = 1
                                }
                            }
                        }

                        row++
                        col++

                        if (check == 2) {
                            row = 0
                            col = 2
                        }
                    }
                }

                1 -> {
                    var row = 1
                    var col = 0
                    for (check in 0 until 8) {
                        when (board[row][col]) {
                            GameConstants.RED -> {
                                if (board[row][col] == board[row + 1][col + 1]) {
                                    p1++
                                    if (p1 == 4) return 1
                                } else {
                                    p1 = 1
                                }
                            }

                            GameConstants.BLUE -> {
                                if (board[row][col] == board[row + 1][col + 1]) {
                                    p2++
                                    if (p2 == 4) return 2
                                } else {
                                    p2 = 1
                                }
                            }
                        }

                        row++
                        col++

                        if (check == 3) {
                            row = 0
                            col = 1
                        }
                    }
                }

                2 -> {
                    var row = 0
                    var col = 0
                    for (check in 0 until 5) {
                        when (board[row][col]) {
                            GameConstants.RED -> {
                                if (board[row][col] == board[row + 1][col + 1]) {
                                    p1++
                                    if (p1 == 4) return 1
                                } else {
                                    p1 = 1
                                }
                            }

                            GameConstants.BLUE -> {
                                if (board[row][col] == board[row + 1][col + 1]) {
                                    p2++
                                    if (p2 == 4) return 2
                                } else {
                                    p2 = 1
                                }
                            }
                        }

                        row++
                        col++

                    }
                }
            }
        }

        p1 = 1
        p2 = 1

        //Diagonal Left
        for (left in 0 until 3) {
            when (left) {
                0 -> {
                    var row = 2
                    var col = 5
                    for (check in 0 until 6) {
                        when (board[row][col]) {
                            GameConstants.RED -> {
                                if (board[row][col] == board[row + 1][col - 1]) {
                                    p1++
                                    if (p1 == 4) return 1
                                } else {
                                    p1 = 1
                                }
                            }

                            GameConstants.BLUE -> {
                                if (board[row][col] == board[row + 1][col - 1]) {
                                    p2++
                                    if (p2 == 4) return 2
                                } else {
                                    p2 = 1
                                }
                            }
                        }

                        row++
                        col--

                        if (check == 2) {
                            row = 0
                            col = 3
                        }
                    }
                }

                1 -> {
                    var row = 1
                    var col = 5
                    for (check in 0 until 8) {
                        when (board[row][col]) {
                            GameConstants.RED -> {
                                if (board[row][col] == board[row + 1][col - 1]) {
                                    p1++
                                    if (p1 == 4) return 1
                                } else {
                                    p1 = 1
                                }
                            }

                            GameConstants.BLUE -> {
                                if (board[row][col] == board[row + 1][col - 1]) {
                                    p2++
                                    if (p2 == 4) return 2
                                } else {
                                    p2 = 1
                                }
                            }
                        }

                        row++
                        col--

                        if (check == 3) {
                            row = 0
                            col = 4
                        }
                    }
                }

                2 -> {
                    var row = 0
                    var col = 5
                    for (check in 0 until 5) {
                        when (board[row][col]) {
                            GameConstants.RED -> {
                                if (board[row][col] == board[row + 1][col - 1]) {
                                    p1++
                                    if (p1 == 4) return 1
                                } else {
                                    p1 = 1
                                }
                            }

                            GameConstants.BLUE -> {
                                if (board[row][col] == board[row + 1][col - 1]) {
                                    p2++
                                    if (p2 == 4) return 2
                                } else {
                                    p2 = 1
                                }
                            }
                        }

                        row++
                        col--

                    }
                }
            }
        }


        return 3
    }

    override fun computerCheck(location: Int) {

        var col = location % 6
        var row = location / 6

        if (board[row][col] != GameConstants.EMPTY) {
            computerCheck(computerMove())
        } else {
            setMove(2, location)
        }

    }

    /**
     * Print the game board
     */
    fun printBoard() {
        for (row in 0 until GameConstants.ROWS) {
            for (col in 0 until GameConstants.COLS) {
                printCell(board[row][col]) // print each of the cells
                if (col != GameConstants.COLS - 1) {
                    print("|") // print vertical partition
                }
            }
            println()
            if (row != GameConstants.ROWS - 1) {
                println("-----------") // print horizontal partition
            }
        }
        println()
    }

    /**
     * Print a cell with the specified "content"
     * @param content either BLUE, RED or EMPTY
     */
    fun printCell(content: Int) {
        when (content) {
            GameConstants.EMPTY -> print("   ")
            GameConstants.BLUE -> print(" B ")
            GameConstants.RED -> print(" R ")
        }
    }
}

