package com.my.dzikirapp.ui


import android.annotation.SuppressLint
import android.os.Bundle
import com.my.dzikirapp.databinding.ActivityDetailArtikelBinding
import com.my.dzikirapp.model.Artikel
import android.os.Build.VERSION.SDK_INT
import androidx.appcompat.app.AppCompatActivity

class DetailArtikelActivity : AppCompatActivity() {

    private var _binding: ActivityDetailArtikelBinding? = null
    private val binding get() = _binding as ActivityDetailArtikelBinding

    //companion object {
        //const val DATA_TITLE = "title"
        //const val DATA_DESC = "data"
        //const val DATA_IMAGE = "image"
    //}

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailArtikelBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)

        val data = when {
            SDK_INT >= 33 -> intent.getParcelableExtra("key", Artikel::class.java)
            else -> @Suppress("DEFECATION") intent.getParcelableExtra("key") as? Artikel
        }

        binding.apply {
            tvDetailTitle.text = data?.titleArtikel
            tvDetailDesc.text = data?.descArtikel
            data?.imageArtikel?.let { imgDetail.setImageResource(it) }

        }
    }
}