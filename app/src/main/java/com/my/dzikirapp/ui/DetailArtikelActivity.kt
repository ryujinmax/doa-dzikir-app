package com.my.dzikirapp.ui


import android.os.Bundle
import com.my.dzikirapp.databinding.ActivityDetailArtikelBinding
import com.my.dzikirapp.model.Artikel
import android.os.Build.VERSION.SDK_INT
import androidx.appcompat.app.AppCompatActivity

class DetailArtikelActivity : AppCompatActivity() {

    private var _binding: ActivityDetailArtikelBinding? = null
    private val binding get() = _binding as ActivityDetailArtikelBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        title = "Artikel Islam"
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailArtikelBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val data = when {
            SDK_INT >= 33 -> intent.getParcelableExtra("data", Artikel::class.java)
            else -> @Suppress("DEPRECATION") intent.getParcelableExtra("data") as? Artikel
        }

        binding.apply {
            tvDetailTitle.text = data?.titleArtikel
            tvDetailDesc.text = data?.descArtikel
            data?.imageArtikel?.let { imgDetail.setImageResource(it) }

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}