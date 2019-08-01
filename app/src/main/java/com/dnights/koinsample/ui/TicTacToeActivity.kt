package com.dnights.koinsample.ui

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.dnights.koinsample.R
import com.dnights.koinsample.model.Board

class TicTacToeActivity : BaseActivity(){

    private val TAG = TicTacToeActivity::class.java.name

    private var model: Board? = null

    private var buttonGrid: ViewGroup? = null
    private var winnerPlayerViewGroup: View? = null
    private var winnerPlayerLabel: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tictactoe)
        winnerPlayerLabel = findViewById(R.id.winnerPlayerLabel) as TextView
        winnerPlayerViewGroup = findViewById(R.id.winnerPlayerViewGroup)
        buttonGrid = findViewById(R.id.buttonGrid) as ViewGroup

        model = Board()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_tictactoe, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_reset -> {
                reset()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    fun onCellClicked(v: View) {

        val button = v as Button

        val tag = button.tag.toString()
        val row = Integer.valueOf(tag.substring(0, 1))
        val col = Integer.valueOf(tag.substring(1, 2))
        Log.i(TAG, "Click Row: [$row,$col]")

        val playerThatMoved = model!!.mark(row, col)

        if (playerThatMoved != null) {
            button.setText(playerThatMoved!!.toString())
            if (model!!.getWinner() != null) {
                winnerPlayerLabel!!.setText(playerThatMoved!!.toString())
                winnerPlayerViewGroup!!.visibility = View.VISIBLE
            }
        }

    }

    private fun reset() {
        winnerPlayerViewGroup!!.visibility = View.GONE
        winnerPlayerLabel!!.text = ""

        model!!.restart()

        for (i in 0 until buttonGrid!!.childCount) {
            (buttonGrid!!.getChildAt(i) as Button).text = ""
        }
    }
}