package com.my.dzikirapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.my.dzikirapp.adapter.DoadanDzikirAdapter
import com.my.dzikirapp.databinding.ActivityDzikirPagiBinding
import com.my.dzikirapp.model.DataDoaDzikir

class DzikirPagiActivity : AppCompatActivity() {

    private var _binding: ActivityDzikirPagiBinding? = null
    private val binding get() = _binding as ActivityDzikirPagiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        title = "Dzikir Pagi"
        super.onCreate(savedInstanceState)
        _binding = ActivityDzikirPagiBinding.inflate(layoutInflater)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(binding.root)

        binding.rvDzikirPagi.apply {
            val mAdapter = DoadanDzikirAdapter()
            mAdapter.setData(DataDoaDzikir.listDzikirPagi)
            adapter = mAdapter
            layoutManager = LinearLayoutManager(applicationContext)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}