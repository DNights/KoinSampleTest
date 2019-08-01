package com.dnights.koinsample.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.dnights.koinsample.R
import com.dnights.koinsample.databinding.TictactoeBinding
import com.dnights.koinsample.viewmodel.TicTacToeViewModel
import org.koin.android.viewmodel.ext.android.getViewModel


class TicTacToeActivity : BindingActivity<TictactoeBinding>(){
    override fun getLayoutResId(): Int = R.layout.tictactoe

    private lateinit var viewModel : TicTacToeViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_tictactoe, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_reset -> {
                viewModel.onResetSelected()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setBinding() {
        viewModel = getViewModel()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }
}