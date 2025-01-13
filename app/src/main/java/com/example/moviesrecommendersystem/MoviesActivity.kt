package com.example.moviesrecommendersystem

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.moviesrecommendersystem.databinding.ActivityMoviesBinding


class MoviesActivity : AppCompatActivity() {

    lateinit var binding: ActivityMoviesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bundle :Bundle ?=intent.extras
        if (bundle!=null){
            val title = bundle.getString("title")
            val overview = bundle.getString("overview")
            binding.movieTitle.text = title
            binding.movieDescription.text = overview
            val posterpath = bundle.getString("posterpath")
            var posterUrl = "https://image.tmdb.org/t/p/w500${posterpath}"
            val poster = binding.posterImage
            Glide.with(this)
                .load(posterUrl)
                .into(poster);
            val releaseDate = bundle.getString("releaseDate")
            binding.releaseDate.text = "Release Date : ${releaseDate}"
            val runtime = bundle.getString("runtime")
            binding.runtime.text = "Runtime :  ${runtime} minutes"
            val rating = bundle.getString("rating")
            binding.rating.text = rating

            val tagline = bundle.getString("tagline")
            binding.tagline.text = "Tagline : ${tagline.toString()}"

            var icon1 = binding.image1
            var icon1URL = "https://image.tmdb.org/t/p/w500/tEiIH5QesdheJmDAqQwvtN60727.png"
            Glide.with(this).load(icon1URL).circleCrop().into(icon1)

            var icon2 = binding.image2
            var icon2URL = "https://image.tmdb.org/t/p/w500/7cxRWzi4LsVm4Utfpr1hfARNurT.png"
            Glide.with(this).load(icon2URL).circleCrop().into(icon2)

            var icon3 = binding.image3
            var icon3URL = "https://image.tmdb.org/t/p/w500/A32wmjrs9Psf4zw0uaixF0GXfxq.png"
            Glide.with(this).load(icon3URL).circleCrop().into(icon3)

            var icon4 = binding.image4
            var icon4URL = "https://image.tmdb.org/t/p/w500/qZCc1lty5FzX30aOCVRBLzaVmcp.png"
            Glide.with(this).load(icon4URL).circleCrop().into(icon4)

            var icon5 = binding.image5
            var icon5URL = "https://image.tmdb.org/t/p/w500/hD8yEGUBlHOcfHYbujp71vD8gZp.png"
            Glide.with(this).load(icon5URL).circleCrop().into(icon5)

            var icon6 = binding.image6
            var icon6URL = "https://image.tmdb.org/t/p/w500/gz66EfNoYPqHTYI4q9UEN4CbHRc.png"
            Glide.with(this).load(icon6URL).circleCrop().into(icon6)

            var icon7 = binding.image7
            var icon7URL = "https://image.tmdb.org/t/p/w500/ocLZIdYJBppuCt1rhYEb2jbpt5F.png"
            Glide.with(this).load(icon7URL).circleCrop().into(icon7)



//            binding.more.setOnClickListener {
//
//                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(homepage))
//                startActivity(browserIntent)
//
//                binding.more.text = homepage
//
//            }

        }

    }
}