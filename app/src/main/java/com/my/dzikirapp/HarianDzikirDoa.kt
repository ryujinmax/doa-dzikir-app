package com.my.dzikirapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.my.dzikirapp.adapter.DoadanDzikirAdapter
import com.my.dzikirapp.databinding.ActivityHarianDzikirDoaBinding
import com.my.dzikirapp.model.DoadanDzikirItem
import androidx.recyclerview.widget.LinearLayoutManager


class HarianDzikirDoa : AppCompatActivity() {

    private var _binding: ActivityHarianDzikirDoaBinding? = null
    private val binding get() = _binding as ActivityHarianDzikirDoaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHarianDzikirDoaBinding.inflate(layoutInflater)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(binding.root)

        providingDzikirData()
        initView()
    }

    private fun initView() {
        val mAdapter = DoadanDzikirAdapter()
        mAdapter.setData(providingDzikirData())
        binding.rvDzikirDoaHarian.adapter = mAdapter
        binding.rvDzikirDoaHarian.layoutManager = LinearLayoutManager(this)
    }

    private fun providingDzikirData() : List<DoadanDzikirItem> {

        val judulDoa = resources.getStringArray(R.array.arr_dzikir_doa_harian)
        val isiDoa = resources.getStringArray(R.array.arr_lafaz_dzikir_doa_harian)
        val terjemahDoa = resources.getStringArray(R.array.arr_terjemah_dzikir_doa_harian)

        val listData = arrayListOf<DoadanDzikirItem>()
        for (i in judulDoa.indices) {
            val doa = DoadanDzikirItem(
                judulDoa[i],
                isiDoa[i],
                terjemahDoa[i]
            )
            listData.add(doa)
        }
        return listData
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}