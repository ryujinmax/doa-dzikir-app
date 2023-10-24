package com.my.dzikirapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.my.dzikirapp.databinding.ActivityQouliyahSholatBinding
import com.my.dzikirapp.adapter.DoadanDzikirAdapter
import com.my.dzikirapp.model.DataDoaDzikir
import androidx.recyclerview.widget.LinearLayoutManager

class QouliyahSholatActivity : AppCompatActivity() {

    private var _binding: ActivityQouliyahSholatBinding? = null
    private val binding get() = _binding as ActivityQouliyahSholatBinding
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)
        _binding = ActivityQouliyahSholatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mAdapter = DoadanDzikirAdapter()
        mAdapter.setData(DataDoaDzikir.listDataQauliyah)
        binding.rvQauliyahShalat.adapter = mAdapter
        binding.rvQauliyahShalat.layoutManager = LinearLayoutManager(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}