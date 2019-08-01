package com.dnights.koinsample.model

class Board {

    private val cells = Array(3) { arrayOfNulls<Player>(3) }

    private var winner: Player? = null
    private var state: GameState? = null
    private var currentTurn: Player? = null

    private enum class GameState {
        IN_PROGRESS, FINISHED
    }

    init {
        restart()
    }

    fun restart() {
        clearCells()
        winner = null
        currentTurn = Player.X
        state = GameState.IN_PROGRESS
    }

    fun mark(row: Int, col: Int): Player? {

        var playerThatMoved: Player? = null

        if (isValid(row, col)) {

            cells[row][col] = currentTurn
            playerThatMoved = currentTurn

            if (isWinningMoveByPlayer(currentTurn, row, col)) {
                state = GameState.FINISHED
                winner = currentTurn

            } else {
                flipCurrentTurn()
            }
        }

        return playerThatMoved
    }

    fun getWinner(): Player? {
        return winner
    }

    private fun clearCells() {
        for (i in 0..2) {
            for (j in 0..2) {
                cells[i][j] = null
            }
        }
    }

    private fun isValid(row: Int, col: Int): Boolean {
        return if (state == GameState.FINISHED) {
            false
        } else if (isOutOfBounds(row) || isOutOfBounds(col)) {
            false
        } else !isCellValueAlreadySet(row, col)
    }

    private fun isOutOfBounds(idx: Int): Boolean {
        return idx < 0 || idx > 2
    }

    private fun isCellValueAlreadySet(row: Int, col: Int): Boolean {
        return cells[row][col] != null
    }

    private fun isWinningMoveByPlayer(player: Player?, currentRow: Int, currentCol: Int): Boolean {

        return ((cells[currentRow][0] === player         // 3-in-the-row

                && cells[currentRow][1] === player
                && cells[currentRow][2] === player)
                || (cells[0][currentCol] === player      // 3-in-the-column

                && cells[1][currentCol] === player
                && cells[2][currentCol] === player)
                || (currentRow == currentCol            // 3-in-the-diagonal

                && cells[0][0] === player
                && cells[1][1] === player
                && cells[2][2] === player)
                || (currentRow + currentCol == 2    // 3-in-the-opposite-diagonal

                && cells[0][2] === player
                && cells[1][1] === player
                && cells[2][0] === player))
    }

    private fun flipCurrentTurn() {
        currentTurn = if (currentTurn === Player.X) Player.O else Player.X
    }

}
