package com.dnights.koinsample.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.dnights.koinsample.R
import com.dnights.koinsample.databinding.TictactoeBinding
import com.dnights.koinsample.viewmodel.TicTacToeViewModel


class TicTacToeActivity : BaseActivity(){

    private var viewModel = TicTacToeViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView(this, R.layout.tictactoe) as TictactoeBinding
        binding.viewModel = viewModel
        viewModel.onCreate()
    }

    override fun onPause() {
        super.onPause()
        viewModel.onPause()
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_tictactoe, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_reset -> {
                viewModel.onResetSelected()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}