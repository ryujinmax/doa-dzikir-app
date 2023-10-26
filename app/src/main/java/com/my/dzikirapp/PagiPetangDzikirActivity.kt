package com.my.dzikirapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.my.dzikirapp.databinding.ActivityPagiPetangDzikirBinding

class PagiPetangDzikirActivity : AppCompatActivity(), View.OnClickListener {

    private var _binding: ActivityPagiPetangDzikirBinding? = null
    private val binding get() = _binding as ActivityPagiPetangDzikirBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        _binding = ActivityPagiPetangDzikirBinding.inflate(layoutInflater)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val btnPagi = findViewById<ImageButton>(R.id.img_btn_dzikir_pagi)
        val btnPetang = findViewById<ImageButton>(R.id.img_btn_dzikir_petang)

        btnPagi.setOnClickListener {this}
        btnPetang.setOnClickListener {this}
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.img_btn_dzikir_pagi -> startActivity(Intent(this, HarianDzikirDoa::class.java))
            R.id.img_btn_dzikir_petang -> startActivity(Intent(this, HarianDzikirDoa::class.java))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}