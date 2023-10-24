package com.my.dzikirapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.viewpager2.widget.ViewPager2
import com.my.dzikirapp.Utills.OnItemCallback
import com.my.dzikirapp.adapter.ArtikelAdapter
import com.my.dzikirapp.model.Artikel
import com.my.dzikirapp.ui.DetailArtikelActivity
import com.my.dzikirapp.ui.SetiapSaatDzikir


class MainActivity : AppCompatActivity() {
    private var keep = true
    private val runner = Runnable { keep = false }

    private lateinit var vpArtikel : ViewPager2
    private lateinit var sliderIndicator : Array<ImageView?>
    private val listArtikel : ArrayList<Artikel> = arrayListOf()
    private val slidingCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            for (i in 0 until listArtikel.size) {
                sliderIndicator[i]?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.dot_inactive)
                )
            }

            sliderIndicator[position]?.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.dot_active)
            )
        }
    }

    fun serData(list: List<Artikel>){
        listArtikel.clear()
        listArtikel.addAll(list)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        initData()
        initView()
        setupViewPager()

    }

    private fun setupViewPager() {
        val llSliderDots: LinearLayout = findViewById(R.id.ll_slider_dots)

        sliderIndicator = arrayOfNulls(listArtikel.size)

        for (i in 0 until listArtikel.size) {
            sliderIndicator[i] = ImageView(this)
            sliderIndicator[i]?.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.dot_inactive
                )
            )
            val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(9, 0, 8, 0)
            params.gravity = Gravity.CENTER_VERTICAL
            llSliderDots.addView(sliderIndicator[i], params)
        }
        sliderIndicator[0]?.setImageDrawable(
            ContextCompat.getDrawable(
                applicationContext,
                R.drawable.dot_active
            )
        )
    }

    private fun initData(){
        val titleArtikel = resources.getStringArray(R.array.arr_title_artikel)
        val contentArtikel = resources.getStringArray(R.array.arr_desc_artikel)
        val imageArtikel = resources.obtainTypedArray(R.array.arr_img_artikel)

        for (i in titleArtikel.indices) {
            val data = Artikel(
                imageArtikel.getResourceId(i, 0),
                titleArtikel[i],
                contentArtikel[i]
            )
            listArtikel.add(data)
        }
        imageArtikel.recycle()
    }

    private fun initView() {
        val llDzikirDoaShalat: LinearLayout = findViewById(R.id.ll_dzikir_doa_shalat)
        llDzikirDoaShalat.setOnClickListener {
            startActivity(Intent(this, QouliyahSholatActivity::class.java))
        }

        val llSetiapSaatDzikir: LinearLayout = findViewById(R.id.ll_dzikir_setiap_saat)
        llSetiapSaatDzikir.setOnClickListener {
            startActivity(Intent(this, SetiapSaatDzikir::class.java))
        }

        val llDzikirDoaHarian: LinearLayout = findViewById(R.id.ll_dzikir_doa_harian)
        llDzikirDoaHarian.setOnClickListener {
            startActivity(Intent(this, HarianDzikirDoa::class.java))
        }

        val llDzikirDoaPilihan: LinearLayout = findViewById(R.id.ll_dzikir_pagi_petang)
        llDzikirDoaPilihan.setOnClickListener {
            startActivity(Intent(this, PagiPetangDzikirActivity::class.java))
        }
        vpArtikel = findViewById(R.id.vp_artikel)
        val mAdapter = ArtikelAdapter()
        mAdapter.setData(listArtikel)
        vpArtikel.adapter = mAdapter

        vpArtikel.registerOnPageChangeCallback(slidingCallback)

        mAdapter.setOnItemClickCallback(object : OnItemCallback{
            override fun onItemClicked(item: Artikel) {
                val intent = Intent(this@MainActivity, DetailArtikelActivity::class.java)
                intent.putExtra("data", item)
                startActivity(intent)
            }

        })
    }
    override fun onDestroy() {
        super.onDestroy()
        vpArtikel.unregisterOnPageChangeCallback(slidingCallback)
    }
}