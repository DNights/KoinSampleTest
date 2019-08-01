package com.dnights.koinsample.viewmodel

import androidx.databinding.ObservableArrayMap
import androidx.databinding.ObservableField
import com.dnights.koinsample.model.Board

class TicTacToeViewModel : ViewModel {

    val model: Board = Board()

    val cells: ObservableArrayMap<String, String> = ObservableArrayMap()
    val winner: ObservableField<String> = ObservableField()

    override fun onCreate() {

    }

    override fun onPause() {

    }

    override fun onResume() {

    }

    override fun onDestroy() {

    }

    fun onResetSelected() {
        model.restart()
        winner.set(null)
        cells.clear()
    }

    fun onClickedCellAt(row: Int, col: Int) {
        val playerThatMoved = model.mark(row, col)
        cells["" + row + col] = playerThatMoved?.toString()
        winner.set(if (model.getWinner() == null) null else model.getWinner()!!.toString())
    }

}
